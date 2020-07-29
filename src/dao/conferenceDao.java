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
public class conferenceDao {

    private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
    private static Session session = sf.openSession();

    public List<Conference> findAll() {
//        try {
////            session.getTransaction().begin();
////            session.getTransaction().commit();
////            return session.createCriteria(Conference.class).list();
//            sf.getCurrentSession().beginTransaction();
//            List<Conference> a = sf.getCurrentSession().createCriteria(Conference.class).list();
//
//            return a;
////            return sf.getCurrentSession().createQuery("from Conference").list();
//        } catch (HibernateException e) {
//            return null;
//        }
        try {
            session.getTransaction().begin();
            session.getTransaction().commit();
            return session.createCriteria(Conference.class).list();
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }

    }

    public static Conference find(String id) {
        try {
            session.getTransaction().begin();
            String hql = "from Conference a where a.idConference = :id";
            Query query = session.createQuery(hql);
            query.setString("id", id);
            List<Conference> ls = query.list();
            session.getTransaction().commit();
            return ls.get(0);
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public static Conference findByName(String id) {
        try {
            session.getTransaction().begin();
            String hql = "from Conference a where a.name = :id";
            Query query = session.createQuery(hql);
            query.setString("id", id);
            List<Conference> ls = query.list();
            session.getTransaction().commit();
            return ls.get(0);
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean delete(Conference ad) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(ad);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            System.out.println(e);
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    public boolean save(Conference ad) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(ad);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            sf.getCurrentSession().getTransaction().rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean update(Conference ad) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().merge(ad);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            sf.getCurrentSession().getTransaction().rollback();
            System.out.println(e);
            return false;
        }
    }
}
