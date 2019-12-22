package com.olzumzum.weblab4.server.model.repository;


import com.olzumzum.weblab4.server.model.HibernateUtil;
import com.olzumzum.weblab4.server.model.entities.User;
import org.hibernate.Session;

import java.util.List;

public class UsersRepository {

    public static void insert(User user){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
    }

    public static void update(User user){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

    public static void delete(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        User user = (User) session.get(User.class, id);
        session.delete(user);

        session.getTransaction().commit();
    }

    public static User get(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        User user = (User) session.get(User.class, id);

        session.getTransaction().commit();
        return user;
    }

    public static List<User> get(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        List<User> list = session.createQuery("From User").list();

        session.getTransaction().commit();

        return list;
    }
}
