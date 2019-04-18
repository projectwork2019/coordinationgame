/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.service;

import com.projectwork.coordinationgame.dao.CategoryDAO;
import com.projectwork.coordinationgame.model.Category;
import java.util.List;

/**
 *
 * @author mohamadhassan
 */
public class CategoryService {
    private static CategoryDAO categoryDAO;
    
    public CategoryService() {
        categoryDAO = new CategoryDAO();
    }
 
    public void persist(Category entity) {
        categoryDAO.openCurrentSessionWithTransaction();
        categoryDAO.persist(entity);
        categoryDAO.closeCurrentSessionWithTransaction();
    }
 
    public void update(Category entity) {
        categoryDAO.openCurrentSessionWithTransaction();
        categoryDAO.update(entity);
        categoryDAO.closeCurrentSessionWithTransaction();
    }
 
    public Category findById(Integer id) {
        categoryDAO.openCurrentSession();
        Category category = categoryDAO.findById(id);
        categoryDAO.closeCurrentSession();
        return category;
    }
 
    public void delete(Integer id) {
        categoryDAO.openCurrentSessionWithTransaction();
        Category category = categoryDAO.findById(id);
        categoryDAO.delete(category);
        categoryDAO.closeCurrentSessionWithTransaction();
    }
 
    public List<Category> findAll() {
        categoryDAO.openCurrentSession();
        List<Category> categoryss = categoryDAO.findAll();
        categoryDAO.closeCurrentSession();
        return categoryss;
    }
 
    public void deleteAll() {
        categoryDAO.openCurrentSessionWithTransaction();
        categoryDAO.deleteAll();
        categoryDAO.closeCurrentSessionWithTransaction();
    }
 
    public CategoryDAO ctegoryDao() {
        return categoryDAO;
    }
}
