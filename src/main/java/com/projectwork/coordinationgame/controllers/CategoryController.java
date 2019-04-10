/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.controllers;

import com.projectwork.coordinationgame.model.Category;
import com.projectwork.coordinationgame.model.Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */

@RestController
public class CategoryController {
    private static Map<Integer, Category> categoryRepository = new HashMap<>();
    
    static {
        int startId = 40001;
        String[] names = {
            "Category 1: Basic games",
            "Category 2: Advanced games",
            "Category 3: Advanced games for first time players",
            "Category 4: Games from previous research",
            "Category 5: Games without any specific categorization"
        };
        
        for (String name : names) {
            Category c = new Category();
            c.setCategory_id(startId);
            c.setName(name);
            categoryRepository.put(c.getCategory_id(), c);
            startId++;            
        }
    }
    
    @GetMapping("/api/category")
    public List<Category> getCategories() {
        // create list for games to be returned
        List<Category> categories = new ArrayList<>();
        
        // Call gameRepository interface to find all games
        return categories;
    }
    
    @GetMapping("/api/caregory/{categoryId}")
    public Game getGames(@PathVariable Integer categoryId) {
        return game;
    }
}
