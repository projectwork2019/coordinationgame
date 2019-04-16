/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.controllers;

import com.projectwork.coordinationgame.model.Presentation;
import com.projectwork.coordinationgame.repository.PresentationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */
public class PresentationController {
    @Autowired
    private PresentationRepository presentationRepository;
    
    @GetMapping("/api/presentation")
    public List<Presentation> getPresentations() {
        // create list for games to be returned
        List<Presentation> presentations = new ArrayList<>();
        // Call presentaton repository interface to find all presentations
        presentationRepository.findAll().forEach(presentations::add);
        return presentations;
    }
    
    @GetMapping("/api/presentations/{presentationId}")
    public Presentation getPresentations (@PathVariable Integer presentationId) {
        // Fetch the game from repository
        Optional<Presentation> optionalEntity = presentationRepository.findById(presentationId);
        // Convert the Optional to Game object
        Presentation presentation = optionalEntity.get();
        return presentation;
    }

    @PostMapping("/api/presentations")
    // @CrossOrigin(origins = "http://localhost:4200")
    public Presentation createPresentation(@RequestBody Presentation presentation) {
        System.out.println("POST: Received presentation object: " + presentation.toString());
        return presentationRepository.save(presentation);
    }
}
