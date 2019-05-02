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

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Integer selection_id;
    public Selection(SelectionIdentity selection_id) {
        this.selection_id = selection_id;
    }

    public Selection() {
        this.selection_id = new SelectionIdentity();
    }
    
    
    
    @EmbeddedId
    private SelectionIdentity selection_id;
    
    /*
    export class Selection {
	nodeId : number;
	confidence : number;
	presentationId : number;
    }
    */
    
//    SelectionIdentity
//    @Column(name = "confidence")
//    private Integer confidence;
//        
//    @Column(name = "selected_node")
//    private Integer nodeId;
//    
//    @Column(name = "presentation_id")
//    private Integer presentationId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "presentation_id", insertable = false, updatable = false)
    private Presentation presentation;
    
    public SelectionIdentity getSelectionID() {
        return selection_id;
    }    

    public void setSelection_id(SelectionIdentity selection_id) {
        this.selection_id = selection_id;
    }

//    public Integer getConfidence() {
//        return confidence;
//    }
//
    public void setConfidence(int confidence) {
        this.selection_id.setConfidence(confidence);
    }
//
//    public Integer getNodeId() {
//        return nodeId;
//    }
//
    public void setSelectedNode(int selectedNode) {
        this.selection_id.setSelectedNode(selectedNode);
    }
//
//    public Integer getPresentationId() {
//        return presentationId;
//    }
//
    public void setPresentationId(Integer presentationId) {
        this.selection_id.setPresentationId(presentationId);
    }
    
    @Override
    public String toString() {
        return "Selection - selected node: " + getSelectionID().getSelectedNode()+ " confidence: " + getSelectionID().getConfidence() + " presentation ID: " + getSelectionID().getPresentationId();
    }   
}