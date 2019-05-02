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
public class GameCategoryID implements Serializable{
    @Column(name = "game_session_id")
    private Integer gameID;
    @Column(name = "category_id")
    private Integer categoryID;
    
    public GameCategoryID(){
        
    }

    public GameCategoryID(Integer gameID, Integer categoryID) {
        this.gameID = gameID;
        this.categoryID = categoryID;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        GameCategoryID that = (GameCategoryID) o;
        return Objects.equals(gameID, that.gameID) &&
               Objects.equals(categoryID, that.categoryID);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(gameID, categoryID);
    }
}
