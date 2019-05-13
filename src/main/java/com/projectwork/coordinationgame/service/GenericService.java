/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.service;

import com.projectwork.coordinationgame.dao.GenericDAO;
import java.util.List;

/**
 *
 * @author mohamadhassan
 * @param <T>
 */
public class GenericService<T> {
    
    private static GenericDAO genericDAO;
    
    public GenericService() {
        genericDAO = new GenericDAO();
    }
 
    public void persist(T entity) {
        genericDAO.openCurrentSessionWithTransaction();
        genericDAO.persist(entity);
        genericDAO.closeCurrentSessionWithTransaction();
    }
 
    public void update(T entity) {
        genericDAO.openCurrentSessionWithTransaction();
        genericDAO.update(entity);
        genericDAO.closeCurrentSessionWithTransaction();
    }
 
    public T findById(Integer id) {
        genericDAO.openCurrentSession();
        T t = (T) genericDAO.findById(id);
        genericDAO.closeCurrentSession();
        return t;
    }
 
    public void delete(Integer id) {
        genericDAO.openCurrentSessionWithTransaction();
        T t = (T) genericDAO.findById(id);
        genericDAO.delete(t);
        genericDAO.closeCurrentSessionWithTransaction();
    }
 
    public List<T> findAll() {
        genericDAO.openCurrentSession();
        List<T> t = genericDAO.findAll();
        genericDAO.closeCurrentSession();
        return t;
    }
 
    public void deleteAll() {
        genericDAO.openCurrentSessionWithTransaction();
        genericDAO.deleteAll();
        genericDAO.closeCurrentSessionWithTransaction();
    }
 
    public GenericDAO genericDAO() {
        return genericDAO;
    }
}
