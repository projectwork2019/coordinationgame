/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.util.Arrays;
import javax.persistence.*;

/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */

@Entity
public class Presentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int presentation_id;
    
    private int[] component_order;
    private boolean mirror;
    private int game_id;

    public int getPresentation_id() {
        return presentation_id;
    }

    public void setPresentation_id(int presentation_id) {
        this.presentation_id = presentation_id;
    }

    public int[] getComponent_order() {
        return component_order;
    }

    public void setComponent_order(int[] component_order) {
        this.component_order = component_order;
    }

    public boolean isMirror() {
        return mirror;
    }

    public void setMirror(boolean mirror) {
        this.mirror = mirror;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.presentation_id;
        hash = 17 * hash + Arrays.hashCode(this.component_order);
        hash = 17 * hash + (this.mirror ? 1 : 0);
        hash = 17 * hash + this.game_id;
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
        if (this.presentation_id != other.presentation_id) {
            return false;
        }
        if (this.mirror != other.mirror) {
            return false;
        }
        if (this.game_id != other.game_id) {
            return false;
        }
        if (!Arrays.equals(this.component_order, other.component_order)) {
            return false;
        }
        return true;
    }
}