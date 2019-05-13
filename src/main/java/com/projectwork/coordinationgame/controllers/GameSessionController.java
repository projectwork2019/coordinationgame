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
    
    @GetMapping("/api/gamesessions")
    public List<Presentation> getGameSessions() {
        // Get list of 10 random games
//        List<Integer> gameIdList = new ArrayList<>();
//       
//        gameRepository.findAll().forEach((gameItem) -> gameIdList.add(gameItem.getId()));
        GameSessionSettings settings = gameSessionSettingsDao.findDefaultSettings();
        List<Game> games = gameDao.findAll();
        Collections.shuffle(games);
        
        List<Presentation> presentationList = new ArrayList<>();
        Random random = new Random();
        
        // Loop here just in case the system has less games than needed for these settings
        do {
            for(Category c : settings.getCategories()){
                boolean found = false;
                int i = 0;
                do {
                    if(games.get(i).getCategories().contains(c)){
                        found = true;
                        List<Presentation> p = games.get(i).getPresentations();
                        presentationList.add(p.get(random.nextInt(p.size())));
                    }
                    i++;
                } while (!found && i < games.size());
            }
        } while (!(presentationList.size() == settings.getCategories().size()));
        
        
       
//        presentationDao.findAll().forEach((gameItem) -> presentationList.add(gameItem));
        
//        Collections.shuffle(presentationList);
        
//        if (presentationList.size() > 10) {
//            return presentationList.subList(0, 10);
//        } else {
            return presentationList;
//        }
    }

    @PostMapping("/api/gamesessions")
    public List<String> createGameSession(@RequestBody GameSession requestData) { 
        GameSession gameSession = requestData;
        ArrayList<String> response = new ArrayList<>();
        gameSession.getSelections().forEach((s) -> {
           selectionDao.persist(s);
        });
        gameSessionDao.persist(gameSession);   
        return response;
    }
    
    @GetMapping("/api/gamesessions/settings/{id}")
    public GameSessionSettings getSettingsById(@PathVariable Integer id) {
        return gameSessionSettingsDao.findById(id);
    }
    
    @GetMapping("/api/gamesessions/settings")
    public GameSessionSettings getDefaultSessionSettings() {
        GameSessionSettings settings = gameSessionSettingsDao.findDefaultSettings();
        return settings;
    }
    
    @PostMapping("/api/gamesessions/settings")
    public GameSessionSettings createGameSessionSettings(@RequestBody GameSessionSettings requestData) { 
        GameSessionSettings settings = gameSessionSettingsDao.findById(requestData.getId());
        settings.setCategories(requestData.getCategories());
        gameSessionSettingsDao.persist(settings);   
        return settings;
    }   
}
