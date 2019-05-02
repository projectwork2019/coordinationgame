/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Lephise
 */
@Embeddable
public class SelectionIdentity implements Serializable {

    private Integer confidence;
 
    @Column(name = "selected_node")
    private Integer selectedNode;
 
    @Column(name = "presentation_id")
    private Integer presentationId;
    
    public SelectionIdentity() {
    }
 
    public SelectionIdentity(Integer confidence, Integer selectedNode, Integer presentationId) {
        this.confidence = confidence;
        this.selectedNode = selectedNode;
        this.presentationId = presentationId;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public Integer getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(Integer selectedNode) {
        this.selectedNode = selectedNode;
    }

    public Integer getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(Integer presentationId) {
        this.presentationId = presentationId;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SelectionIdentity)) return false;
        SelectionIdentity that = (SelectionIdentity) o;
        return Objects.equals(getConfidence(), that.getConfidence()) &&
                Objects.equals(getPresentationId(), that.getPresentationId()) &&
                Objects.equals(getSelectedNode(), that.getSelectedNode());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getConfidence(), getPresentationId(), getSelectedNode());
    }
}

