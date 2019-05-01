/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.service;

import com.projectwork.coordinationgame.dao.GameSessionSelectionDAO;
import com.projectwork.coordinationgame.model.GameSessionSelection;
import java.util.List;

/**
 *
 * @author mohamadhassan
 */
public class GameSessionSelectionService {
    private static GameSessionSelectionDAO gameSessionSelectionDAO;
    
    public GameSessionSelectionService() {
        gameSessionSelectionDAO = new GameSessionSelectionDAO();
    }
 
    public void persist(GameSessionSelection entity) {
        gameSessionSelectionDAO.openCurrentSessionWithTransaction();
        gameSessionSelectionDAO.persist(entity);
        gameSessionSelectionDAO.closeCurrentSessionWithTransaction();
    }
 
    public void update(GameSessionSelection entity) {
        gameSessionSelectionDAO.openCurrentSessionWithTransaction();
        gameSessionSelectionDAO.update(entity);
        gameSessionSelectionDAO.closeCurrentSessionWithTransaction();
    }
 
    public GameSessionSelection findById(Integer id) {
        gameSessionSelectionDAO.openCurrentSession();
        GameSessionSelection gameSessionSelection = gameSessionSelectionDAO.findById(id);
        gameSessionSelectionDAO.closeCurrentSession();
        return gameSessionSelection;
    }
 
    public void delete(Integer id) {
        gameSessionSelectionDAO.openCurrentSessionWithTransaction();
        GameSessionSelection gameSessionSelection = gameSessionSelectionDAO.findById(id);
        gameSessionSelectionDAO.delete(gameSessionSelection);
        gameSessionSelectionDAO.closeCurrentSessionWithTransaction();
    }
 
    public List<GameSessionSelection> findAll() {
        gameSessionSelectionDAO.openCurrentSession();
        List<GameSessionSelection> gameSessionSelectionss = gameSessionSelectionDAO.findAll();
        gameSessionSelectionDAO.closeCurrentSession();
        return gameSessionSelectionss;
    }
 
    public void deleteAll() {
        gameSessionSelectionDAO.openCurrentSessionWithTransaction();
        gameSessionSelectionDAO.deleteAll();
        gameSessionSelectionDAO.closeCurrentSessionWithTransaction();
    }
 
    public GameSessionSelectionDAO gameSessionSelectionDao() {
        return gameSessionSelectionDAO;
    }
}
