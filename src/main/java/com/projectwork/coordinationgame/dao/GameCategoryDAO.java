/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.GameCategory;
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
public class GameCategoryDAO implements DAOInterface<GameCategory, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;

    //Default constructor used to instanciate an empty GameSelectioDAO object
    public GameCategoryDAO() {
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
    public void persist(GameCategory entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(GameCategory entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public GameCategory findById(Integer id) {
        GameCategory gameCategory = (GameCategory) getCurrentSession().get(GameCategory.class, id);
        return gameCategory;
    }

    @Override
    public void delete(GameCategory entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<GameCategory> findAll() {
        List<GameCategory> gameCategorys = (List<GameCategory>) getCurrentSession().createQuery("from game_category").list();
        return gameCategorys;
    }

    @Override
    public void deleteAll() {
        List<GameCategory> entityList = findAll();
        for (GameCategory entity : entityList) {
            delete(entity);
        }
    }
    
}
