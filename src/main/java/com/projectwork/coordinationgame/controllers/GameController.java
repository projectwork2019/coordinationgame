package com.projectwork.coordinationgame.controllers;

import com.projectwork.coordinationgame.dao.GameDAO;
import com.projectwork.coordinationgame.dao.PresentationDAO;
import org.springframework.web.bind.annotation.*;
import com.projectwork.coordinationgame.model.Game;
import com.projectwork.coordinationgame.model.Presentation;
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
    
    private GameDAO gameDao = new GameDAO();
    private PresentationDAO presentationDao = new PresentationDAO();
    

    @GetMapping("/api/games")
    public List<Game> getGames() {
        // create list for games to be returned
        List<Game> games = new ArrayList<>();
        // Call gameRepository interface to find all games
        gameRepository.findAll().forEach(games::add);
        return games;
    }
    
    @GetMapping("/api/games/{gameId}")
    public Game getGames(@PathVariable Integer gameId) {
        // Fetch the game from repository
        Optional<Game> optionalEntity = gameRepository.findById(gameId);
        // Convert the Optional to Game object
        Game game = optionalEntity.get();
        return game;
    }

    @PostMapping("/api/games")
    // @CrossOrigin(origins = "http://localhost:4200")
    public Game createGame(@RequestBody Game game) {
        System.out.println("POST: Received game data object: " + game.getGameDataObject());
        //return gameRepository.save(game);
        gameDao.persist(game);
        Presentation presentation = new Presentation();
        presentation.setComponentOrder("DEFAULT");
        presentation.setMirror(false);
        presentation.setGames(game);
        presentationDao.persist(presentation);
        presentation = new Presentation();
        presentation.setComponentOrder("DEFAULT");
        presentation.setMirror(true);
        presentation.setGames(game);
        presentationDao.persist(presentation);
        return game;
    }
}