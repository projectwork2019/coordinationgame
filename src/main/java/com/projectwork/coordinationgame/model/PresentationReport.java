package com.projectwork.coordinationgame.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
public class PresentationReport {
   
   @EmbeddedId
   private SelectionIdentity selection_id;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name ="presentation_id", insertable = false, updatable = false, nullable=false)
   private Presentation presentation;

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
   
   private Integer frequency;

    public SelectionIdentity getSelection_id() {
        return selection_id;
    }

    public void setSelection_id(SelectionIdentity selection_id) {
        this.selection_id = selection_id;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}