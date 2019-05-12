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
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        System.out.println("POST: Received game data object: " + game.getGameDataObject().toString());
        //return gameRepository.save(game);
        game.setEnabled(false);
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
    
    @GetMapping("/api/games/enable")
    // @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Game> toggleGameEnabled(@RequestParam Integer id) {
        Game game = gameDao.findById(id);
        if(game != null){
            game.setEnabled(!game.isEnabled());
            gameDao.persist(game);
            return new ResponseEntity<Game>(game, HttpStatus.OK);
        }
        return new ResponseEntity<Game>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/api/games/delete")
    // @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Game> deleteGame(@RequestParam Integer id) {
        Game game = gameDao.findById(id);
        if(game != null){
//            System.out.println("PRESENTATION: " + game.getPresentations().size());
//            for(Presentation p : game.getPresentations()) {
//                System.out.println("PRESENTATION: " + p.getPresentationId());
////                presentationDao.delete(p);
//            }
            gameDao.delete(game);
            return new ResponseEntity<Game>(game, HttpStatus.OK);
        }
        return new ResponseEntity<Game>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping("/api/games/categories")
    // @CrossOrigin(origins = "http://localhost:4200")
    public Game addCategories(@RequestBody Game request) {
//        System.out.println("POST: Received game data object: " + game.getGameDataObject().toString());
        //return gameRepository.save(game);
        Game game = gameDao.findById(request.getGameID());
        game.setCategories(request.getCategories());
        gameDao.persist(game);
        return game;
    }
    
}