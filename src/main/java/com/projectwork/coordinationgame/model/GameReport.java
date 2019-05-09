/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Lephise
 */
@Entity
public class GameReport {
  
  @EmbeddedId
   private SelectionIdentity selection_id;
    
  private Integer game_id;
  
  @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name ="presentation_id", insertable = false, updatable = false, nullable=false)
   private Presentation presentation;
//  private Integer confidence;
//
//  private Integer selected_node;
//
//  private Integer presentation_id;

  private Integer frequency;

    public SelectionIdentity getSelection_id() {
        return selection_id;
    }

    public void setSelection_id(SelectionIdentity selection_id) {
        this.selection_id = selection_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

   

   public Integer getFrequency() {
       return frequency;
   }

   public void setFrequency(Integer frequency) {
       this.frequency = frequency;
   }
}
