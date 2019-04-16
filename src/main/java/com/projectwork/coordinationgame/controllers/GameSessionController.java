/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.controllers;

import com.projectwork.coordinationgame.model.Game;
import org.springframework.web.bind.annotation.*;
import com.projectwork.coordinationgame.model.GameSession;
import com.projectwork.coordinationgame.model.GameSessionWrapper;
import com.projectwork.coordinationgame.model.Selection;

import com.projectwork.coordinationgame.repository.GameRepository;
import com.projectwork.coordinationgame.repository.GameSessionRepository;
import com.projectwork.coordinationgame.repository.SelectionRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
    
     @GetMapping("/api/gamesessions")
    public List<Integer> getGameSessions() {
        // Get list of 10 random games
        List<Integer> gameIdList = new ArrayList<>();
        gameRepository.findAll().forEach((gameItem) -> gameIdList.add(gameItem.getId()));
        Collections.shuffle(gameIdList);
        if (gameIdList.size() > 10) {
            return gameIdList.subList(0, 10);
        } else {
            return gameIdList;
        }
    }

    @PostMapping("/api/gamesessions")
    public List<String> createGameSession(@RequestBody GameSessionWrapper gameSessionWrapper) {        
        GameSession gameSession = gameSessionWrapper.getGameSession();
        List<Selection> selections = gameSessionWrapper.getSelections();
                
        ArrayList<String> response = new ArrayList<>();
        response.add(gameSession.toString());
        selections.forEach((s) -> {
            if (s != null) {
                gameSession.addSelection(s);
            }
            response.add("Added selection: " + s.toString());
        });
        
        gameSessionRepository.save(gameSession);
        
        return response;
    }   
}