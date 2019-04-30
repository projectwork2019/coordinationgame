/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 *
 * @author mohamadhassan
 */
@Embeddable
public class GameSessionSelectionID implements Serializable{
    @Column(name = "game_session _id")
    private Integer gameSessionID;
    @Column(name = "selection_id")
    private Integer selectionID;
    
    public GameSessionSelectionID(){
        
    }

    public GameSessionSelectionID(Integer gameSessionID, Integer selectionID) {
        this.gameSessionID = gameSessionID;
        this.selectionID = selectionID;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        GameSessionSelectionID that = (GameSessionSelectionID) o;
        return Objects.equals(gameSessionID, that.gameSessionID) &&
               Objects.equals(selectionID, that.selectionID);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(gameSessionID, selectionID);
    }
}
