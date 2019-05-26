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
    

     /**
     * Rest endpoint (GET): /api/games
     * Get all games
     * @return List<Game> all games in system
     */
    @GetMapping("/api/games")
    public List<Game> getGames() {
        // create list for games to be returned
        List<Game> games = new ArrayList<>();
        // Call gameRepository interface to find all games
        gameRepository.findAll().forEach(games::add);
        return games;
    }
    
     /**
     * Rest endpoint (GET): /api/games/{gameId}
     * Get game by id
     * @param Integer gameId
     * @return game if found by id
     */
    @GetMapping("/api/games/{gameId}")
    public Game getGames(@PathVariable Integer gameId) {
        // Fetch the game from repository
        Optional<Game> optionalEntity = gameRepository.findById(gameId);
        // Convert the Optional to Game object
        Game game = optionalEntity.get();
        return game;
    }

     /**
     * Rest endpoint (POST): /api/games
     * Create new game
     * @param Game new game object to be created
     * @return created game
     */
    @PostMapping("/api/games")
    // @CrossOrigin(origins = "http://localhost:4200")
    public Game createGame(@RequestBody Game game) {
        // Disable game when created
        game.setEnabled(false);
        gameDao.persist(game);
        // Add default presentations (normal and mirrored) for created game
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
    
     /**
     * Rest endpoint (GET): /api/games/enable
     * Enable game with id
     * @param Integer game id
     * @return HttpStatus 200 if succesfull,HttpStatus 400 if not 
     */
    @GetMapping("/api/games/enable")
    public ResponseEntity<Game> toggleGameEnabled(@RequestParam Integer id) {
        Game game = gameDao.findById(id);
        if(game != null){
            game.setEnabled(!game.isEnabled());
            gameDao.persist(game);
            return new ResponseEntity<Game>(game, HttpStatus.OK);
        }
        return new ResponseEntity<Game>(HttpStatus.BAD_REQUEST);
    }
    
     /**
     * Rest endpoint (GET): /api/games/delete
     * Delete game with id
     * @param Integer game id
     * @return HttpStatus 200 if succesfull, HttpStatus 400 if not 
     */
    @GetMapping("/api/games/delete")
    public ResponseEntity<Game> deleteGame(@RequestParam Integer id) {
        Game game = gameDao.findById(id);
        if(game != null){
            gameDao.delete(game);
            return new ResponseEntity<Game>(game, HttpStatus.OK);
        }
        return new ResponseEntity<Game>(HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Rest endpoint (POST): /api/games/categories
     * Add categories to game
     * @param Game with categories present
     * @return HttpStatus 200 if succesfull,HttpStatus 400 if not 
     */
    @PostMapping("/api/games/categories")
    public Game addCategories(@RequestBody Game request) {
        // Check if game is found in the database
        Game game = gameDao.findById(request.getGameID());
        if(game != null){
            // Add categories to the game
            game.setCategories(request.getCategories());
            gameDao.persist(game);
        }
        return game;
    }
    
}