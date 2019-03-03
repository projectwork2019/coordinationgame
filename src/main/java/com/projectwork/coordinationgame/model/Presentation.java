/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.util.Objects;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author antti
 */
@Entity
@Table(name = "presentation")
public class Presentation {
    @Id
    @GeneratedValue(generator = "presentation_generator")
    @SequenceGenerator(
            name = "presentation_generator",
            sequenceName = "presentation_sequence",
            initialValue = 1
    )
    private Long id;
    
    @NotBlank
    @Column(name = "presentation")
    private String componentsOrder; // change to int[] when implementation to PostgreSQL is clear
    
    // Database relation mappings
    @ManyToOne
    @JoinColumn(name = "fk_game_id")    // To be changed to match the created database
    private Game game;

    // getters and setters auto-generated
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComponentsOrder() {
        return componentsOrder;
    }

    public void setComponentsOrder(String componentsOrder) {
        this.componentsOrder = componentsOrder;
    }
    
    // equals and hashCode auto-generated
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.componentsOrder);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Presentation other = (Presentation) obj;
        if (!Objects.equals(this.componentsOrder, other.componentsOrder)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}