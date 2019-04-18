package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.Game;
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

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(Game entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Game entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Game findById(Integer id) {
        Game game = (Game) getCurrentSession().get(Game.class, id);
        return game;
    }

    @Override
    public void delete(Game entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Game> findAll() {
        List<Game> games = (List<Game>) getCurrentSession().createQuery("from game").list();
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
