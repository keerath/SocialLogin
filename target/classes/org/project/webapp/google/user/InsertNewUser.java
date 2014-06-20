package org.project.webapp.google.user;

import java.util.List;

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
    session.close();
  }

  public boolean checkEmailIsUnique(String email) {
    session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    List<String> result =
        session.createQuery("select password from UserInfo where email=:email")
            .setParameter("email", email).list();
    session.close();
    if (!result.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }
}
