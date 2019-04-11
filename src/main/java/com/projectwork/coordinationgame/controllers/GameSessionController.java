/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.controllers;

import com.projectwork.coordinationgame.model.Game;
import org.springframework.web.bind.annotation.*;
import com.projectwork.coordinationgame.model.GameSession;
import com.projectwork.coordinationgame.model.Selection;
import com.projectwork.coordinationgame.model.SelectionWrapper;

import com.projectwork.coordinationgame.repository.GameRepository;
import com.projectwork.coordinationgame.repository.GameSessionRepository;
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
    public List<String> createGameSession(@RequestBody List<Selection> selections) {
        // Create new gameSession instance
        
        // Get gameSession ID
        
        // Persist selections (SelectionDAO) related to session ID
        ArrayList<String> response = new ArrayList<>();
        selections.forEach((s) -> {
            response.add("Added selection: " + s.toString());
        });
        //  
        return response;
    }   
}
