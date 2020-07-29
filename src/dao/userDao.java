/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.*;
import pojos.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author LONG LIN
 */
public class userDao {

    private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
    private static Session session = sf.openSession();

    public List<User> findAll() {
        try {
            session.getTransaction().begin();
            session.getTransaction().commit();
            return session.createCriteria(User.class).list();
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public static User find(String id) {
        try {
            session.getTransaction().begin();
            String hql = "from User a where a.idUser = :id";
            Query query = session.createQuery(hql);
            query.setString("id", id);
            List<User> ls = query.list();
            session.getTransaction().commit();
            return ls.get(0);
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public List<User> findByName(String id) {
        try {
            id = "%" + id + "%";
            session.getTransaction().begin();
            String hql = "from User a where a.name like :id";
            Query query = session.createQuery(hql);
            query.setString("id", id);
            List<User> ls = query.list();
            session.getTransaction().commit();
            return ls;
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public List<User> findByType(String id) {
        try {
            session.getTransaction().begin();
            String hql = "from User a where a.type like :id";
            Query query = session.createQuery(hql);
            query.setString("id", id);
            List<User> ls = query.list();
            session.getTransaction().commit();
            return ls;
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public User login(String user, String pass) {
        try {
            session.getTransaction().begin();
            String hql = "select a from User a where a.username = :user and a.password = :pass";
            Query query = session.createQuery(hql);
            query.setString("user", user);
            query.setString("pass", pass);
            List<User> ls = query.list();
            session.getTransaction().commit();
            if (ls.isEmpty()) {
                return null;
            } else {
                return ls.get(0);
            }
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean delete(User ad) {
        try {
            session.getTransaction().begin();
            session.delete(ad);
//            session.getTransaction().commit();
            if (!session.getTransaction().wasCommitted()) {
                session.getTransaction().commit();
            }
            return true;
        } catch (HibernateException e) {
            System.out.println(e);
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    public boolean save(User ad) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(ad);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    public boolean update(User ad) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().merge(ad);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
}
