/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.service;

import com.projectwork.coordinationgame.dao.GameSessionDAO;
import com.projectwork.coordinationgame.model.GameSession;
import java.util.List;

/**
 *
 * @author mohamadhassan
 */
public class GameSessionService {
    private static GameSessionDAO gameSessionDAO;
    
    public GameSessionService() {
        gameSessionDAO = new GameSessionDAO();
    }
 
    public void persist(GameSession entity) {
        gameSessionDAO.openCurrentSessionWithTransaction();
        gameSessionDAO.persist(entity);
        gameSessionDAO.closeCurrentSessionWithTransaction();
    }
 
    public void update(GameSession entity) {
        gameSessionDAO.openCurrentSessionWithTransaction();
        gameSessionDAO.update(entity);
        gameSessionDAO.closeCurrentSessionWithTransaction();
    }
 
    public GameSession findById(Integer id) {
        gameSessionDAO.openCurrentSession();
        GameSession gameSession = gameSessionDAO.findById(id);
        gameSessionDAO.closeCurrentSession();
        return gameSession;
    }
 
    public void delete(Integer id) {
        gameSessionDAO.openCurrentSessionWithTransaction();
        GameSession gameSession = gameSessionDAO.findById(id);
        gameSessionDAO.delete(gameSession);
        gameSessionDAO.closeCurrentSessionWithTransaction();
    }
 
    public List<GameSession> findAll() {
        gameSessionDAO.openCurrentSession();
        List<GameSession> gameSessionss = gameSessionDAO.findAll();
        gameSessionDAO.closeCurrentSession();
        return gameSessionss;
    }
 
    public void deleteAll() {
        gameSessionDAO.openCurrentSessionWithTransaction();
        gameSessionDAO.deleteAll();
        gameSessionDAO.closeCurrentSessionWithTransaction();
    }
 
    public GameSessionDAO gameSessionDao() {
        return gameSessionDAO;
    }
}
