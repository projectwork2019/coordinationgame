package com.projectwork.coordinationgame.dao;

import java.io.Serializable;
import java.util.List;

/**
 * This interface is based on the DAO Interface conventions.
 * 
 * @author mohamadhassan
 * @param <T>
 * @param <Id>
 */
public interface DAOInterface<T, Id extends Serializable> {

    public void persist(T entity);

    public void update(T entity);

    public T findById(Id id);

    public void delete(T entity);

    public List<T> findAll();
    
    public List<T> findAllShuffeled();

    public void deleteAll();
}
