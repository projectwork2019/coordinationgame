/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */

@Entity
public class Presentation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "presentation_id")
    private int presentationId;
    
    /*
    CREATE TABLE project_work.presentation (
    presentation_id SERIAL,
    component_order INTEGER[] NOT NULL,
    mirror BOOLEAN NOT NULL,
    game_id SERIAL,
    PRIMARY KEY(presentation_id),
    FOREIGN KEY (game_id) REFERENCES game);
    */
       
    @Column(name = "presentation_name")
    private String presentationName;
    
    @Column(name = "component_order")
    private Integer[] componentOrder;
    
    @Column(name = "mirror")
    private boolean mirror;
    
    @Column(name = "gameId")
    private int gameId;

       
    @OneToMany(mappedBy="presentation_id", cascade = CascadeType.ALL)
    private final Set<Selection> selections;
    
    public Presentation() {
        this.selections = new HashSet<>();
    }

    @Override
    public String toString() {
        return "ID: " + presentationId + " name: " + presentationName + " componentOrder: " + componentOrder + " mirror: " + mirror + " gameId: " + gameId;
    }
    public int getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(int presentationId) {
        this.presentationId = presentationId;
    }

    public String getPresentationName() {
        return presentationName;
    }

    public void setPresentationName(String presentationName) {
        this.presentationName = presentationName;
    }

    public Integer[] getComponentOrder() {
        return componentOrder;
    }

    public void setComponentOrder(Integer[] componentOrder) {
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
        hash = 89 * hash + Objects.hashCode(this.presentationName);
        hash = 89 * hash + Arrays.deepHashCode(this.componentOrder);
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
        if (!Objects.equals(this.presentationName, other.presentationName)) {
            return false;
        }
        if (!Arrays.deepEquals(this.componentOrder, other.componentOrder)) {
            return false;
        }
        if (!Objects.equals(this.selections, other.selections)) {
            return false;
        }
        return true;
    }
    
    
}