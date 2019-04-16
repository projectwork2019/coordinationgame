/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
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
    @Column(name = "game_session_id")
    private Integer id;
    
    @Column(name = "first_time")
    private boolean firstTime;
    
    @Column(name = "prev_knowledge")
    private boolean prevKnowledge;
    
    @Column(name = "start_timestamp")
    private LocalDateTime startTimestamp;
    
    @Column(name = "end_timestamp")
    private LocalDateTime endTimestamp;
    
    /*
    CREATE TABLE project_work.game_session (
    game_session_id SERIAL,
    player_comment VARCHAR(500),
    first_time BOOLEAN NOT NULL,
    prev_knowledge BOOLEAN NOT NULL,
    start_timestamp TIMESTAMP NOT NULL,
    end_timestamp TIMESTAMP NOT NULL,
    PRIMARY KEY(game_session_id),
    UNIQUE (game_session_id));
    */
    
    // Definition for many-to-many join table between GameSession and Selection
    @ManyToMany
    @JoinTable(
            name="game_session_selection",
            joinColumns = @JoinColumn("game_session_id"),
            inverseJoinColumns = @JoinColumn("selection_id")
    )
    private Set<Selection> selections;
    
    
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