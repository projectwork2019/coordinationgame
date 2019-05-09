/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.util.Objects;

/**
 *
 * @author mohamadhassan
 */
public class Component {
    
    private Integer componentID;
    private String componentJSON;

    public Integer getComponentID() {
        return componentID;
    }

    public String getComponentJSON() {
        return componentJSON;
    }

    public void setComponentID(Integer componentID) {
        this.componentID = componentID;
    }

    public void setComponentJSON(String componentJSON) {
        this.componentJSON = componentJSON;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.componentID);
        hash = 83 * hash + Objects.hashCode(this.componentJSON);
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
        final Component other = (Component) obj;
        if (!Objects.equals(this.componentJSON, other.componentJSON)) {
            return false;
        }
        if (!Objects.equals(this.componentID, other.componentID)) {
            return false;
        }
        return true;
    }
    
    
    
}
