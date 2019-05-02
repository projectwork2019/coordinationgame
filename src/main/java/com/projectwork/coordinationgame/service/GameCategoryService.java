/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.service;

import com.projectwork.coordinationgame.dao.GameCategoryDAO;
import com.projectwork.coordinationgame.model.GameCategory;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mohamadhassan
 */
public class GameCategoryService {
    private static GameCategoryDAO gameCategoryDAO;
    
    public GameCategoryService() {
        gameCategoryDAO = new GameCategoryDAO();
    }
 
    public void persist(GameCategory entity) {
        gameCategoryDAO.openCurrentSessionWithTransaction();
        gameCategoryDAO.persist(entity);
        gameCategoryDAO.closeCurrentSessionWithTransaction();
    }
 
    public void update(GameCategory entity) {
        gameCategoryDAO.openCurrentSessionWithTransaction();
        gameCategoryDAO.update(entity);
        gameCategoryDAO.closeCurrentSessionWithTransaction();
    }
 
    public GameCategory findById(Integer id) {
        gameCategoryDAO.openCurrentSession();
        GameCategory gameCategory = gameCategoryDAO.findById(id);
        gameCategoryDAO.closeCurrentSession();
        return gameCategory;
    }
 
    public void delete(Integer id) {
        gameCategoryDAO.openCurrentSessionWithTransaction();
        GameCategory gameCategory = gameCategoryDAO.findById(id);
        gameCategoryDAO.delete(gameCategory);
        gameCategoryDAO.closeCurrentSessionWithTransaction();
    }
 
    public List<GameCategory> findAll() {
        gameCategoryDAO.openCurrentSession();
        List<GameCategory> gameCategoryss = gameCategoryDAO.findAll();
        gameCategoryDAO.closeCurrentSession();
        return gameCategoryss;
    }
 
    public void deleteAll() {
        gameCategoryDAO.openCurrentSessionWithTransaction();
        gameCategoryDAO.deleteAll();
        gameCategoryDAO.closeCurrentSessionWithTransaction();
    }
 
    public GameCategoryDAO gameCategoryDao() {
        return gameCategoryDAO;
    }
}
