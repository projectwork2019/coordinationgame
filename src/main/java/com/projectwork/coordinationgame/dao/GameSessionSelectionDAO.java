/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.GameSessionSelection;
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
public class GameSessionSelectionDAO implements DAOInterface<GameSessionSelection, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;

    //Default constructor used to instanciate an empty GameSessionSelectioDAO object
    public GameSessionSelectionDAO() {
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
    public void persist(GameSessionSelection entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(GameSessionSelection entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public GameSessionSelection findById(Integer id) {
        GameSessionSelection gameSessionSelection = (GameSessionSelection) getCurrentSession().get(GameSessionSelection.class, id);
        return gameSessionSelection;
    }

    @Override
    public void delete(GameSessionSelection entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<GameSessionSelection> findAll() {
        List<GameSessionSelection> gameSessionSelections = (List<GameSessionSelection>) getCurrentSession().createQuery("from game_session_selection").list();
        return gameSessionSelections;
    }

    @Override
    public void deleteAll() {
        List<GameSessionSelection> entityList = findAll();
        for (GameSessionSelection entity : entityList) {
            delete(entity);
        }
    }
    
}
