package org.project.webapp.google.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;


@Configuration
@ComponentScan(basePackages = "org.project.webapp.google",
    excludeFilters = {@Filter(Configuration.class)})
public class MainConfig {

  @Bean(destroyMethod = "shutdown")
  public DataSource dataSource() {
    EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
    factory.setDatabaseName("Google-Info");
    factory.setDatabaseType(EmbeddedDatabaseType.H2);
    factory.setDatabasePopulator(databasePopulator());
    return factory.getDatabase();
  }

  // internal helpers

  private DatabasePopulator databasePopulator() {
    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScript(new ClassPathResource(
        "JdbcUsersConnectionRepository.sql",
        JdbcUsersConnectionRepository.class));
    return populator;
  }
}
