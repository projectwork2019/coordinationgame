/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Type;
/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */
@Entity
@Table(name = "game_session")
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private boolean firstTime;
    private boolean prevKnowledge;
    private LocalDateTime startTimestamp;
    private LocalDateTime endTimestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }

    public boolean isPrevKnowledge() {
        return prevKnowledge;
    }

    public void setPrevKnowledge(boolean prevKnowledge) {
        this.prevKnowledge = prevKnowledge;
    }

    public LocalDateTime getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(LocalDateTime startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public LocalDateTime getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(LocalDateTime endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + (this.firstTime ? 1 : 0);
        hash = 71 * hash + (this.prevKnowledge ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.startTimestamp);
        hash = 71 * hash + Objects.hashCode(this.endTimestamp);
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
        final GameSession other = (GameSession) obj;
        if (this.firstTime != other.firstTime) {
            return false;
        }
        if (this.prevKnowledge != other.prevKnowledge) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.startTimestamp, other.startTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.endTimestamp, other.endTimestamp)) {
            return false;
        }
        return true;
    }
    
    
    
}
