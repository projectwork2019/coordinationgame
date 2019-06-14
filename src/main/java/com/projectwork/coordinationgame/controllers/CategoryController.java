/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.controllers;

import com.projectwork.coordinationgame.dao.CategoryDAO;
import com.projectwork.coordinationgame.model.Category;
import com.projectwork.coordinationgame.model.Game;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */


/**
*Controller class for Categories 
*/
@RestController
public class CategoryController {
    
    private static Map<Integer, Category> categoryRepository = new HashMap<>();
    private static int id;
    
    private CategoryDAO categoryDao = new CategoryDAO();
    
    static {
        id = 40001;
        String[] names = {
            "Category 1: Basic games",
            "Category 2: Advanced games",
            "Category 3: Advanced games for first time players",
            "Category 4: Games from previous research",
            "Category 5: Games without any specific categorization"
        };
        
        for (String name : names) {
            Category c = new Category();
            c.setCategoryID(id);
            c.setName(name);
            categoryRepository.put(c.getCategoryID(), c);
            id++;           
        }
    }
    
    @RequestMapping("/api/user")
  public Principal user(Principal user) {
    return user;
  }
    
    /**
     * Rest endpoint (GET): /api/categories/{categoryID}
     * @return All categories
     */
    @GetMapping("/api/categories")
    public List<Category> getCategories() {
        return categoryDao.findAll();
    }
    
    /**
     * Rest endpoint (GET): /api/categories/{categoryID}
     * @param Integer categoryId
     * @return Category by id.
     */
    @GetMapping("/api/categories/{categoryId}")
    public Category getCategories(@PathVariable Integer categoryId) {
        return categoryRepository.getOrDefault(categoryId, null);
    }
    
     /**
     * Rest endpoint (POST): /api/categories
     * @param Category newCategory
     * @return Category created category.
     */
    @PostMapping("/api/categories")
    public Category createCategory(@RequestBody Category newCategory) {
       categoryDao.persist(newCategory);
       return newCategory;
    }
}
