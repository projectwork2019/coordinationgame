/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.Category;
import com.projectwork.coordinationgame.model.Presentation;
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
public class CategoryDAO implements DAOInterface<Category, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;

    //Default constructor used to instanciate an empty GameDAO object
    public CategoryDAO() {
    }
    
    @Override
    public void persist(Category entity) {
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
    public void update(Category entity) {
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
    }

    @Override
    public Category findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Category category = (Category) session.get(Category.class, id);
        session.close();
        return category;
    }

    @Override
    public void delete(Category entity) {
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
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        List<Category> categorys = (List<Category>) session.createQuery("from category").list();
        List<Category> categories = (List<Category>) session.createCriteria(Category.class).list();
        session.close();
        return categories;
    }

    @Override
    public void deleteAll() {
        List<Category> entityList = findAll();
        for (Category entity : entityList) {
            delete(entity);
        }
    }
    
}
