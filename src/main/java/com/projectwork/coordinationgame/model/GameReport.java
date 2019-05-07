/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

/**
 *
 * @author Lephise
 */
public class GameReport {
  
  private Integer game_id;
  
  private Integer confidence;

  private Integer selected_node;

  private Integer presentation_id;

  private Integer frequency;

   public Integer getConfidence() {
       return confidence;
   }

   public void setConfidence(Integer confidence) {
       this.confidence = confidence;
   }

   public Integer getSelected_node() {
       return selected_node;
   }

   public void setSelected_node(Integer selected_node) {
       this.selected_node = selected_node;
   }

   public Integer getPresentation_id() {
       return presentation_id;
   }

   public void setPresentation_id(Integer presentation_id) {
       this.presentation_id = presentation_id;
   }

   public Integer getFrequency() {
       return frequency;
   }

   public void setFrequency(Integer frequency) {
       this.frequency = frequency;
   }
}
