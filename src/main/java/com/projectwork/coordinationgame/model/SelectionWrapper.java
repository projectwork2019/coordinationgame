/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.util.List;

/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */
public class SelectionWrapper {
    
    private List<Selection> selections;
    
    public List<Selection> getSelections() {
        return selections;
    }
    
    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }
}
