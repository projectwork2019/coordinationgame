/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.GameSession;
import com.projectwork.coordinationgame.service.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mohamadhassan
 */
public class GameSessionDAO implements DAOInterface<GameSession, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;

    //Default constructor used to instanciate an empty GameDAO object
    public GameSessionDAO() {
    }

//    public Session openCurrentSession() {
//        currentSession = getSessionFactory().openSession();
//        currentTransaction = currentSession.beginTransaction();
//        return currentSession;
//    }
//    
//    public Session openCurrentSessionWithTransaction() {
//        currentSession = getSessionFactory().openSession();
//        currentTransaction = currentSession.beginTransaction();
//        return currentSession;
//    }
//
//    public void closeCurrentSession() {
//        currentSession.close();
//    }
//
//    public void closeCurrentSessionWithTransaction() {
//        currentTransaction.commit();
//        currentSession.close();
//    }
//
//    private static SessionFactory getSessionFactory() {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
//        return sessionFactory;
//    }
//
//    public Session getCurrentSession() {
//        return currentSession;
//    }
//
//    public void setCurrentSession(Session currentSession) {
//        this.currentSession = currentSession;
//    }
//
//    public Transaction getCurrentTransaction() {
//        return currentTransaction;
//    }
//
//    public void setCurrentTransaction(Transaction currentTransaction) {
//        this.currentTransaction = currentTransaction;
//    }

    @Override
    public void persist(GameSession entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(session.merge(entity));
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
//        getCurrentSession().save(entity);
    }

    @Override
    public void update(GameSession entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
//        getCurrentSession().update(entity);
    }

    @Override
    public GameSession findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        GameSession gameSession = (GameSession) session.get(GameSession.class, id);
        return gameSession;
    }

    @Override
    public void delete(GameSession entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
//        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<GameSession> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<GameSession> gameSessions = (List<GameSession>) session.createQuery("from game_session").list();
        return gameSessions;
    }

    @Override
    public void deleteAll() {
        List<GameSession> entityList = findAll();
        for (GameSession entity : entityList) {
            delete(entity);
        }
    }
    
}
