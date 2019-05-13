/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.service.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mohamadhassan
 * @param <T>
 */
public class GenericDAO<T> implements DAOInterface<T, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;

    //Default constructor used to instanciate an empty GenericDAO object
    public GenericDAO() {
    }

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
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

//    private static SessionFactory getSessionFactory() {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
//        return sessionFactory;
//    }

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
    public void persist(T entity) {
        openCurrentSessionWithTransaction().saveOrUpdate(entity);
        getCurrentTransaction().commit();
        closeCurrentSession();
    }

    @Override
    public void update(T entity) {
        openCurrentSession().update(entity);
        closeCurrentSession();
    }

    @Override
    public T findById(Integer id) {
        T t = (T) openCurrentSession().get(((Class<T>) ((ParameterizedType) getClass()
        .getGenericSuperclass()).getActualTypeArguments()[0]) , id);
        closeCurrentSession();
        return t;
    }

    @Override
    public void delete(T entity) {
        openCurrentSession().delete(entity);
        closeCurrentSession();
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder builder = openCurrentSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery((Class<T>) ((ParameterizedType) getClass()
                            .getGenericSuperclass()).getActualTypeArguments()[0]);
        Root<T> genericRoot=criteria.from((Class<T>) ((ParameterizedType) getClass()
                            .getGenericSuperclass()).getActualTypeArguments()[0]);
        criteria.select(genericRoot);
        
        List<T> tList = (List<T>) currentSession.createQuery(criteria).getResultList();
        closeCurrentSession();
        return tList;
    }
    
    @Override
    public List<T> findAllShuffeled() {
        List<T> list = this.findAll();
        Collections.shuffle(list);
        return list;
    }

    @Override
    public void deleteAll() {
        List<T> entityList = findAll();
        entityList.forEach((entity) -> {
            delete(entity);
        });
    }
    
}
