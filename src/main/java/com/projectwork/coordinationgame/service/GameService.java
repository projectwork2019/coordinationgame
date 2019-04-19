/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.service;

import com.projectwork.coordinationgame.dao.GameDAO;
import com.projectwork.coordinationgame.model.Game;
import java.util.List;

/**
 *
 * @author mohamadhassan
 */
public class GameService {
    private static GameDAO gameDAO;
    
    public GameService() {
        gameDAO = new GameDAO();
    }
 
    public void persist(Game entity) {
        gameDAO.openCurrentSessionWithTransaction();
        gameDAO.persist(entity);
        gameDAO.closeCurrentSessionWithTransaction();
    }
 
    public void update(Game entity) {
        gameDAO.openCurrentSessionWithTransaction();
        gameDAO.update(entity);
        gameDAO.closeCurrentSessionWithTransaction();
    }
 
    public Game findById(Integer id) {
        gameDAO.openCurrentSession();
        Game game = gameDAO.findById(id);
        gameDAO.closeCurrentSession();
        return game;
    }
 
    public void delete(Integer id) {
        gameDAO.openCurrentSessionWithTransaction();
        Game game = gameDAO.findById(id);
        gameDAO.delete(game);
        gameDAO.closeCurrentSessionWithTransaction();
    }
 
    public List<Game> findAll() {
        gameDAO.openCurrentSession();
        List<Game> games = gameDAO.findAll();
        gameDAO.closeCurrentSession();
        return games;
    }
 
    public void deleteAll() {
        gameDAO.openCurrentSessionWithTransaction();
        gameDAO.deleteAll();
        gameDAO.closeCurrentSessionWithTransaction();
    }

    public GameDAO gameDao() {
        return gameDAO;
    }
    
}
