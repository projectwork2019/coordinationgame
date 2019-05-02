/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.controllers;

import com.projectwork.coordinationgame.dao.GameSessionDAO;
import com.projectwork.coordinationgame.dao.PresentationDAO;
import com.projectwork.coordinationgame.dao.SelectionDAO;
import com.projectwork.coordinationgame.model.Game;
import org.springframework.web.bind.annotation.*;
import com.projectwork.coordinationgame.model.GameSession;
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
    
     @GetMapping("/api/gamesessions")
    public List<Presentation> getGameSessions() {
        // Get list of 10 random games
//        List<Integer> gameIdList = new ArrayList<>();
//       
//        gameRepository.findAll().forEach((gameItem) -> gameIdList.add(gameItem.getId()));
        
        List<Presentation> presentationList = new ArrayList<>();
       
        presentationDao.findAll().forEach((gameItem) -> presentationList.add(gameItem));
        
        Collections.shuffle(presentationList);
        
        if (presentationList.size() > 10) {
            return presentationList.subList(0, 10);
        } else {
            return presentationList;
        }
    }

    @PostMapping("/api/gamesessions")
    public List<String> createGameSession(@RequestBody GameSession requestData) {        
        GameSession gameSession = requestData;
//        GameSession gs = requestData.getGameSession();
//        List<SelectionIdentity> selections = requestData.getSelections();
        ArrayList<String> response = new ArrayList<>();
//
//        response.add(gameSession.toString());
//        
        gameSession.getSelections().forEach((s) -> {
           selectionDao.persist(s);
        });
//            Selection selection = new Selection(s);
//            selectionDao.persist(selection);
//            gs.addSelection(selection);
            
//            if (s != null) {
//                Integer presentationId = s.getSelection_id().getPresentationId();
//                Optional<Presentation> optionalEntity = presentationRepository.findById(presentationId);
//                Presentation presentation;
//                if(optionalEntity != null) {
//                    presentation = new Presentation();
//                } else {
//                    presentation = optionalEntity.get();
//                }
//                presentation.addSelection(s);
//                //TODO: NOT NEEDED AFTER PROPERLY GENERATING PRESENTATIONS IN GAMECONTROLLER
//                presentation.setComponentOrder("DEFAULT");    
////                presentation.setGameId(s.getSelection_id().getPresentationId());
//                presentationRepository.save(presentation);
//                //gameSession.addSelection(s);
//                response.add("Added selection: " + s.toString());
//            } else {
//                response.add("Null");
//            }

//        });
        gameSessionDao.persist(gameSession);
        //gameSessionRepository.save(gameSession.getGameSession());
        
        return response;
    }   
}
