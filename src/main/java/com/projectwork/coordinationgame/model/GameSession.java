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
}
