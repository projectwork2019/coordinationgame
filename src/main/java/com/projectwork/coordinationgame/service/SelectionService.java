/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.service;

import com.projectwork.coordinationgame.dao.SelectionDAO;
import com.projectwork.coordinationgame.model.Selection;
import java.util.List;

/**
 *
 * @author mohamadhassan
 */
public class SelectionService {
    private static SelectionDAO selectionDAO;
    
    public SelectionService() {
        selectionDAO = new SelectionDAO();
    }
 
    public void persist(Selection entity) {
        selectionDAO.openCurrentSessionWithTransaction();
        selectionDAO.persist(entity);
        selectionDAO.closeCurrentSessionWithTransaction();
    }
 
    public void update(Selection entity) {
        selectionDAO.openCurrentSessionWithTransaction();
        selectionDAO.update(entity);
        selectionDAO.closeCurrentSessionWithTransaction();
    }
 
    public Selection findById(Integer id) {
        selectionDAO.openCurrentSession();
        Selection selection = selectionDAO.findById(id);
        selectionDAO.closeCurrentSession();
        return selection;
    }
 
    public void delete(Integer id) {
        selectionDAO.openCurrentSessionWithTransaction();
        Selection selection = selectionDAO.findById(id);
        selectionDAO.delete(selection);
        selectionDAO.closeCurrentSessionWithTransaction();
    }
 
    public List<Selection> findAll() {
        selectionDAO.openCurrentSession();
        List<Selection> selectionss = selectionDAO.findAll();
        selectionDAO.closeCurrentSession();
        return selectionss;
    }
 
    public void deleteAll() {
        selectionDAO.openCurrentSessionWithTransaction();
        selectionDAO.deleteAll();
        selectionDAO.closeCurrentSessionWithTransaction();
    }
 
    public SelectionDAO bookDao() {
        return selectionDAO;
    }
}
