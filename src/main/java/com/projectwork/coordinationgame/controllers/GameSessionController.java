/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.controllers;

import com.projectwork.coordinationgame.dao.GameDAO;
import com.projectwork.coordinationgame.dao.GameSessionDAO;
import com.projectwork.coordinationgame.dao.GameSessionSettingsDAO;
import com.projectwork.coordinationgame.dao.PresentationDAO;
import com.projectwork.coordinationgame.dao.SelectionDAO;
import com.projectwork.coordinationgame.model.Category;
import com.projectwork.coordinationgame.model.Game;
import org.springframework.web.bind.annotation.*;
import com.projectwork.coordinationgame.model.GameSession;
import com.projectwork.coordinationgame.model.GameSessionSettings;
import com.projectwork.coordinationgame.model.GameSessionWrapper;
import com.projectwork.coordinationgame.model.Presentation;
import com.projectwork.coordinationgame.model.Selection;
import com.projectwork.coordinationgame.model.SelectionIdentity;

import com.projectwork.coordinationgame.repository.GameRepository;
import com.projectwork.coordinationgame.repository.GameSessionRepository;
import com.projectwork.coordinationgame.repository.PresentationRepository;
import com.projectwork.coordinationgame.repository.SelectionRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */

@RestController
public class GameSessionController {
    
    public static Integer DEFAULT_SESSION_SIZE = 10;
    
    @Autowired
    private GameSessionRepository gameSessionRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private SelectionRepository selectionRepository;
    @Autowired
    private PresentationRepository presentationRepository;
    
    private PresentationDAO presentationDao = new PresentationDAO();
    private SelectionDAO selectionDao = new SelectionDAO();
    private GameSessionDAO gameSessionDao = new GameSessionDAO();
    private GameSessionSettingsDAO gameSessionSettingsDao = new GameSessionSettingsDAO();
    private GameDAO gameDao = new GameDAO();
    
    /**
     * Rest endpoint (GET): /api/gamesessions
     * Get list of presentations to include in game session
     */
    @GetMapping("/api/gamesessions")
    public List<Presentation> getGameSessions() {
        GameSessionSettings settings = gameSessionSettingsDao.findDefaultSettings();
        List<Game> games = gameDao.findAll();
        Collections.shuffle(games);
        
        List<Presentation> presentationList = new ArrayList<>();
        Random random = new Random();
        // If no sessions are defined, generate session by selecting 10 random presentations from 10 random games
        if(settings == null){
            do{
            // Get default_session_size worth of presentation from different games, unless less than that games are found in system
                for(int i = 0; presentationList.size() < DEFAULT_SESSION_SIZE && i < games.size(); i++){
                    List<Presentation> p = games.get(i).getPresentations();
                    presentationList.add(p.get(random.nextInt(p.size())));
                }
            }
        // Loop here just in case the system has less games than needed for these settings
            while(!(presentationList.size() == DEFAULT_SESSION_SIZE));
            return presentationList;
        }
        
        // If settings are found, generate session based on those
        
        do {
            // Loop categories in session settings
            for(Category c : settings.getCategories()){
                boolean found = false;
                int i = 0;
                // Loop games until one is found which contains category
                do {
                    if(games.get(i).getCategories().contains(c)){
                        found = true;
                        List<Presentation> p = games.get(i).getPresentations();
                        presentationList.add(p.get(random.nextInt(p.size())));
                    }
                    i++;
                } while (!found && i < games.size());
            }
        // Loop here just in case the system has less games than needed for these settings
        } while (!(presentationList.size() == settings.getCategories().size()));
        return presentationList;
    }

    /**
     * Rest endpoint (POST): /api/gamesessions
     * Add data of a game session to database
     * @param GameSession new game play session
     */
    @PostMapping("/api/gamesessions")
    public List<String> createGameSession(@RequestBody GameSession requestData) { 
        GameSession gameSession = requestData;
        ArrayList<String> response = new ArrayList<>();
        // Persist all of the selections present in gamesession
        // Note: Due to database structure, only new selections that are not present in database are stored.
        gameSession.getSelections().forEach((s) -> {
           selectionDao.persist(s);
        });
        // After persisting selections persist the gameSession.
        gameSessionDao.persist(gameSession);   
        return response;
    }
    
    /**
     * Rest endpoint (GET): /api/gamesessions/settings/{id}
     * Get game session settings by id
     * @param Integer id
     * @return Session settings if found
     */
    @GetMapping("/api/gamesessions/settings/{id}")
    public GameSessionSettings getSettingsById(@PathVariable Integer id) {
        return gameSessionSettingsDao.findById(id);
    }
    
    /**
     * Rest endpoint (GET): /api/gamesessions/settings
     * Get default game session settings
     * @return Default session settings
     */
    @GetMapping("/api/gamesessions/settings")
    public GameSessionSettings getDefaultSessionSettings() {
        GameSessionSettings settings = gameSessionSettingsDao.findDefaultSettings();
        return settings;
    }
    
    /**
     * Rest endpoint (POST): /api/gamessessions/settings
     * Set game session settings to be used by the application
     * @param GameSessionSettings to be used
     * @return Created gamesession settings object
     */
    @PostMapping("/api/gamesessions/settings")
    public GameSessionSettings createGameSessionSettings(@RequestBody GameSessionSettings requestData) { 
        GameSessionSettings settings = gameSessionSettingsDao.findById(requestData.getId());
        settings.setCategories(requestData.getCategories());
        gameSessionSettingsDao.persist(settings);   
        return settings;
    }   
}
