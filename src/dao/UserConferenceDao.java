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
public class UserConferenceDao {

    private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
    private static Session session = sf.openSession();

    public static List<UserConference> findAll() {
        try {
            session.getTransaction().begin();
            session.getTransaction().commit();
            return session.createCriteria(UserConference.class).list();
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public static UserConference find(int id, int id1) {
        UserConferenceId a = new UserConferenceId(id1, id);
//        System.out.println(a.getIdConference() + " haha " + a.getIdUser());
        UserConference b = null;
        try {
            b = (UserConference) session.get(UserConference.class, a);
//            System.out.println(b.getId());
            return b;
        } catch (HibernateException e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean update(UserConference ad) {
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

//    public boolean save(UserConference ad) {
//        try {
//            sf.getCurrentSession().beginTransaction();
//            sf.getCurrentSession().save(ad);
//            sf.getCurrentSession().getTransaction().commit();
//            return true;
//        } catch (HibernateException e) {
//            sf.getCurrentSession().getTransaction().rollback();
//            System.out.println(e);
//            return false;
//        }
//    }
    public static boolean save(String userId, String conId) {
        UserConferenceId userConId = new UserConferenceId(parseInt(userId), parseInt(conId));
        User user = new User();
        user = userDao.find(userId);
        Conference con = conferenceDao.find(conId);
        UserConference userHoinghi = new UserConference(userConId, con, user, 0);
        if (UserConferenceDao.find(parseInt(userId), parseInt(conId)) != null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(userHoinghi);
            transaction.commit();
            return true;
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.out.println(ex);
            return false;
        }
    }
}
