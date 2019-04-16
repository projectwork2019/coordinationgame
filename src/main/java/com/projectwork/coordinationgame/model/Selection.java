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
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */
@Entity 
@Table(name = "selection")
public class Selection implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer selection_id;
    
    /*
    export class Selection {
	nodeId : number;
	confidence : number;
	presentationId : number;
    }
    */
    @Column(name = "confidence")
    private Integer confidence;
    
    @Column(name = "freuency")
    private Integer frequency;
    
    @Column(name = "selected_id")
    private Integer nodeId;
    
    @Column(name = "presentation_id")
    private Integer presentationId;
    
    public Integer getSelection_id() {
        return selection_id;
    }

    public void setSelection_id(Integer selection_id) {
        this.selection_id = selection_id;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getPresentation_id() {
        return presentationId;
    }

    public void setPresentation_id(int presentationId) {
        this.presentationId = presentationId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.selection_id);
        hash = 11 * hash + this.confidence;
        hash = 11 * hash + this.frequency;
        hash = 11 * hash + this.nodeId;
        hash = 11 * hash + this.presentationId;
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
        final Selection other = (Selection) obj;
        if (this.confidence != other.confidence) {
            return false;
        }
        if (this.frequency != other.frequency) {
            return false;
        }
        if (this.nodeId != other.nodeId) {
            return false;
        }
        if (this.presentationId != other.presentationId) {
            return false;
        }
        if (!Objects.equals(this.selection_id, other.selection_id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Selection - selected node: " + getNodeId() + " confidence: " + getConfidence();
    }   
}
