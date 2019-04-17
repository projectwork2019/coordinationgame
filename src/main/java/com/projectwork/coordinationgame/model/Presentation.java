/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */

@Entity
@Table(name = "presentation")
public class Presentation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "presentation_id")
    private Integer presentationId;

    @Column(name = "component_order")
    private String componentOrder;
    
    @Column(name = "mirror")
    private boolean mirror;
    
    @Column(name = "game_id")
    private Integer gameId;
    
    @OneToMany(mappedBy = "presentation", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Selection> selections;
    
    public Presentation() {
        this.selections = new HashSet<>();
    }

    @Override
    public String toString() {
        return "ID: " + presentationId + " componentOrder: " + componentOrder + " mirror: " + mirror + " gameId: " + gameId;
    }

    public Integer getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(Integer presentationId) {
        this.presentationId = presentationId;
    }
    
    public String getComponentOrder() {
        return componentOrder;
    }

    public void setComponentOrder(String componentOrder) {
        this.componentOrder = componentOrder;
    }

    public boolean isMirror() {
        return mirror;
    }

    public void setMirror(boolean mirror) {
        this.mirror = mirror;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.presentationId;
        hash = 89 * hash + Objects.hashCode(this.componentOrder);
        hash = 89 * hash + (this.mirror ? 1 : 0);
        hash = 89 * hash + this.gameId;
        hash = 89 * hash + Objects.hashCode(this.selections);
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
        if (this.presentationId != other.presentationId) {
            return false;
        }
        if (this.mirror != other.mirror) {
            return false;
        }
        if (this.gameId != other.gameId) {
            return false;
        }

        if (!Objects.equals(this.componentOrder, other.componentOrder)) {
            return false;
        }
        if (!Objects.equals(this.selections, other.selections)) {
            return false;
        }
        return true;
    }
    
    
}