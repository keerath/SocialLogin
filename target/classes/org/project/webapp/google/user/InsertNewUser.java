package org.project.webapp.google.user;

import org.hibernate.Session;
import org.project.webapp.google.hibernate.HibernateUtil;
import org.project.webapp.google.hibernate.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class InsertNewUser {
  private Session session;

  public void insert(String email, String password) {
    session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    UserInfo user = new UserInfo();
    user.setEmail(email);
    user.setPassword(password);
    session.save(user);
    session.getTransaction().commit();
  }
}
