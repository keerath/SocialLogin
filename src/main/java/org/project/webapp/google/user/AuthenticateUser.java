package org.project.webapp.google.user;

import java.util.List;

import org.hibernate.Session;
import org.project.webapp.google.hibernate.HibernateUtil;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateUser {
  public synchronized boolean authenticate(String email, String password) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    List<String> result =
        session.createQuery("select password from UserInfo where email=:email")
            .setParameter("email", email).list();
    session.getTransaction().commit();
    session.close();
    if (result.get(0).toString().equals(password)) {
      return true;
    } else {
      return false;
    }
  }
}
