/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.util.List;

/**
 *
 * 
 * 
 * 
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */
public class GameSessionWrapper {
    private GameSession gameSession;
    private List<Selection> selections;
    
    public GameSession getGameSession() {
        return this.gameSession;
    }
    
    public List<Selection> getSelections() {
        return this.selections;
    }
}
