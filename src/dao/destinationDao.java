/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static java.lang.Integer.parseInt;
import java.util.*;
import pojos.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author LONG LIN
 */
public class destinationDao {

    private SessionFactory sf = new Configuration().configure().buildSessionFactory();
    private Session session = sf.openSession();

    public List<Destination> findAll() {
        try {
            session.getTransaction().begin();
//            List<Destination> aa =  session.createCriteria(Destination.class).list();
//            for (int i = 0; i < aa.size(); i++) {
//                System.out.println(aa.get(i).getName());
//            }
            session.getTransaction().commit();
            return session.createCriteria(Destination.class).list();
//            return sf.getCurrentSession().createQuery("from Destination").list();
        } catch (HibernateException e) {
            return null;
        }
    }

    public Destination find(String id) {
        try {
            session.getTransaction().begin();
            String hql = "from Destination a where a.idDestination = :id";
            Query query = session.createQuery(hql);
            query.setString("id", id);
            List<Destination> ls = query.list();
            session.getTransaction().commit();
            return ls.get(0);
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public Destination findByName(String id) {
        try {
            session.getTransaction().begin();
            String hql = "from Destination a where a.name = :id";
            Query query = session.createQuery(hql);
            query.setString("id", id);
            List<Destination> ls = query.list();
            session.getTransaction().commit();
            return ls.get(0);
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean delete(Destination ad) {
        try {
            session.getTransaction().begin();
            session.delete(ad);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            System.out.println(e);
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    public boolean save(Destination ad) {
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

    public boolean update(Destination ad) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().merge(ad);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            System.out.println(e);
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
}
