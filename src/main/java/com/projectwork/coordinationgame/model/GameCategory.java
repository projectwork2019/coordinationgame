/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author mohamadhassan
 */
@Entity(name = "GameCategory")
@Table(name = "game_category")
public class GameCategory {
 
    @EmbeddedId
    private GameCategoryID id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("gameID")
    private Game game;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("categoryID")
    private Category category;
 
    private GameCategory() {}
 
    public GameCategory(Game game, Category category) {
        this.game = game;
        this.category = category;
        this.id = new GameCategoryID(game.getGameID(), category.getCategoryID());
    }
 
    //Getters and setters omitted for brevity
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        GameCategory that = (GameCategory) o;
        return Objects.equals(game, that.game) &&
               Objects.equals(category, that.category);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(game, category);
    }
}
