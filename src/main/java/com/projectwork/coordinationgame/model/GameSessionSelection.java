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
@Entity(name = "GameSessionSelection")
@Table(name = "game_session_selection")
public class GameSessionSelection {
 
    @EmbeddedId
    private GameSessionSelectionID id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("gameSessionID")
    private GameSession gameSession;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("selectionID")
    private Selection selection;
 
    private GameSessionSelection() {}
 
    public GameSessionSelection(GameSession gameSession, Selection selection) {
        this.gameSession = gameSession;
        this.selection = selection;
        this.id = new GameSessionSelectionID(gameSession.getGameSessionID(), selection.getSelectionID());
    }
 
    //Getters and setters omitted for brevity
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        GameSessionSelection that = (GameSessionSelection) o;
        return Objects.equals(gameSession, that.gameSession) &&
               Objects.equals(selection, that.selection);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(gameSession, selection);
    }
}
