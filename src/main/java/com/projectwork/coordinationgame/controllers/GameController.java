package com.projectwork.coordinationgame.controllers;

import org.springframework.web.bind.annotation.*;
import com.projectwork.coordinationgame.model.Game;
import com.projectwork.coordinationgame.repository.GameRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author antti
 */
@RestController
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public List<Game> getGames() {
        // create list for games to be returned
        List<Game> games = new ArrayList<>();
        // Call gameRepository interface to find all games
        gameRepository.findAll().forEach(games::add);
        return games;
    }
    
    @GetMapping("/games/{gameId}")
    public Game getGames(@PathVariable Long gameId) {
        // Fetch the game from repository
        Optional<Game> optionalEntity = gameRepository.findById(gameId);
        // Convert the Optional to Game object
        Game game = optionalEntity.get();
        return game;
    }

    @PostMapping("/games")
    // @CrossOrigin(origins = "http://localhost:4200")
    public Game createGame(@RequestBody Game game) {
        System.out.println("POST: Received game data object: " + game.getGameDataObject());
        return gameRepository.save(game);
    }
}