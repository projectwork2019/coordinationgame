package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.Game;
import com.projectwork.coordinationgame.service.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *This class is based on the convention of DAO classes with Hibernate used in many such projects.
 * 
 * @author mohamadhassan
 */
public class GameDAO implements DAOInterface<Game, Integer> {

    private Session currentSession;
    private Transaction currentTransaction;

    //Default constructor used to instanciate an empty GameDAO object
    public GameDAO() {
        
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

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(Game entity) {
        //getCurrentSession().save(entity);
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
        
    }

    @Override
    public void update(Game entity) {
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
    public Game findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Game game = (Game) session.get(Game.class, id);
        session.close();
        //Game game = (Game) getCurrentSession().get(Game.class, id);
        return game;
    }

    @Override
    public void delete(Game entity) {
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
    public List<Game> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //List<Game> games = (List<Game>) getCurrentSession().createQuery("from game").list();
        List<Game> games = (List<Game>) session.createQuery("from game").list();
        session.close();
        return games;
    }

    @Override
    public void deleteAll() {
        List<Game> entityList = findAll();
        for (Game entity : entityList) {
            delete(entity);
        }
    }

}
