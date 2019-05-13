/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.GameSessionSettings;
import com.projectwork.coordinationgame.service.HibernateUtil;
import java.util.Collections;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lephise
 */
public class GameSessionSettingsDAO implements DAOInterface<GameSessionSettings, Integer> {

    public GameSessionSettingsDAO() {
    }
    
    @Override
    public void persist(GameSessionSettings entity) {
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
    public void update(GameSessionSettings entity) {
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
    public GameSessionSettings findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(GameSessionSettings.class);
        criteria.add(Restrictions.eq("id", id));
        GameSessionSettings settings = (GameSessionSettings) criteria.uniqueResult();
        session.close();
        return settings;
    }
    
    public GameSessionSettings findDefaultSettings() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(GameSessionSettings.class);
        criteria.add(Restrictions.eq("name", "DEFAULT"));
        GameSessionSettings settings = (GameSessionSettings) criteria.uniqueResult();
        session.close();
        return settings;
    }

    @Override
    public void delete(GameSessionSettings entity) {
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
    public List<GameSessionSettings> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<GameSessionSettings> settings = (List<GameSessionSettings>) session.createQuery("from selection").list();
        return settings;
    }
    
    @Override
    public List<GameSessionSettings> findAllShuffeled() {
        List<GameSessionSettings> list = this.findAll();
        Collections.shuffle(list);
        return list;
    }

    @Override
    public void deleteAll() {
        List<GameSessionSettings> entityList = findAll();
        for (GameSessionSettings entity : entityList) {
            delete(entity);
        }
    }
}
