/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.Selection;
import com.projectwork.coordinationgame.service.HibernateUtil;
import java.util.Collections;
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
public class SelectionDAO implements DAOInterface<Selection, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;

    //Default constructor used to instanciate an empty GameDAO object
    public SelectionDAO() {
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
    public void persist(Selection entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(entity);
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        //getCurrentSession().save(entity);
    }

    @Override
    public void update(Selection entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        
        //getCurrentSession().update(entity);
    }

    @Override
    public Selection findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Selection selection = (Selection) session.get(Selection.class, id);
        return selection;
    }

    @Override
    public void delete(Selection entity) {
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
        //getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Selection> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Selection> selections = (List<Selection>) session.createQuery("from selection").list();
        return selections;
    }
    
    @Override
    public List<Selection> findAllShuffeled() {
        List<Selection> list = this.findAll();
        Collections.shuffle(list);
        return list;
    }

    @Override
    public void deleteAll() {
        List<Selection> entityList = findAll();
        for (Selection entity : entityList) {
            delete(entity);
        }
    }
    
}
