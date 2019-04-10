/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.controllers;

import org.springframework.web.bind.annotation.*;
import com.projectwork.coordinationgame.model.GameSession;
import com.projectwork.coordinationgame.repository.GameSessionRepository;
import java.util.ArrayList;
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
    
     @GetMapping("/api/gamesessions")
    public List<GameSession> getGameSessions() {
        // create list for games to be returned
        List<GameSession> gameSessions = new ArrayList<>();
        // Call gameRepository interface to find all games
        gameSessionRepository.findAll().forEach(gameSessions::add);
        return gameSessions;
    }
    
    @GetMapping("/api/gamesessions/{gameSessionId}")
    public GameSession getGameSession (@PathVariable Integer gameId) {
        // Fetch the game from repository
        Optional<GameSession> optionalEntity = gameSessionRepository.findById(gameId);
        // Convert the Optional to Game object
        GameSession gameSession = optionalEntity.get();
        return gameSession;
    }

    @PostMapping("/api/gamesessions")
    // @CrossOrigin(origins = "http://localhost:4200")
    public GameSession createGame(@RequestBody GameSession gameSession) {
        System.out.println("POST: Received game session with ID: " + gameSession.getId());
        return gameSessionRepository.save(gameSession);
    }   
}
