/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author Lephise
 */
@Entity
@Table(name = "game_session_settings")
public class GameSessionSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="game_session_settings_id")
    private Integer id;

    @Type(type = "text")
    private String name;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinTable(
            name="game_session_settings_categories",
            joinColumns = @JoinColumn(name = "game_session_settings_id"),
            inverseJoinColumns = 
                    {
                        @JoinColumn(name = "category_id"),
                    }
            
    )
    @OrderColumn(name="list_index")
    private List<Category> categories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
