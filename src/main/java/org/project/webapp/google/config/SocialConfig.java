package org.project.webapp.google.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.project.webapp.google.user.SecurityContext;
import org.project.webapp.google.user.SimpleConnectionSignUp;
import org.project.webapp.google.user.SimpleSignInAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.connect.GoogleConnectionFactory;

@Configuration
public class SocialConfig {

  @Inject
  private Environment environment;

  @Inject
  private DataSource dataSource;


  @Bean
  public ConnectionFactoryLocator connectionFactoryLocator() {
    ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
    registry.addConnectionFactory(new GoogleConnectionFactory(environment
        .getProperty("google.clientId"), environment
        .getProperty("google.clientSecret")));
    return registry;
  }

  @Bean
  public UsersConnectionRepository usersConnectionRepository() {
    JdbcUsersConnectionRepository repository =
        new JdbcUsersConnectionRepository(dataSource,
            connectionFactoryLocator(), Encryptors.noOpText());
    repository.setConnectionSignUp(new SimpleConnectionSignUp());
    return repository;
  }

  @Bean
  @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
  public ConnectionRepository connectionRepository() {
    org.project.webapp.google.user.User user = SecurityContext.getCurrentUser();
    return usersConnectionRepository().createConnectionRepository(user.getId());
  }


  @Bean
  @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
  public Google google() {
    return connectionRepository().getPrimaryConnection(Google.class).getApi();
  }


  @Bean
  public ProviderSignInController providerSignInController() {
    return new ProviderSignInController(connectionFactoryLocator(),
        usersConnectionRepository(), new SimpleSignInAdapter());
  }

}
