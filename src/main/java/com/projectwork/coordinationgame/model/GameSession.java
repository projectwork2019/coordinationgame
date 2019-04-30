/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */
@Entity
@Table(name = "game_session")
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "game_session_id")
    private Integer gameSessionID;
    
    @Column(name = "first_time")
    private boolean firstTime;
    
    @Column(name = "prev_knowledge")
    private boolean prevKnowledge;
    
    @Column(name = "start_timestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTimestamp;
    
    @Column(name = "end_timestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name="game_session_selection",
            joinColumns = @JoinColumn(name = "game_session_id"),
            inverseJoinColumns = @JoinColumn(name = "selection_id")
    )
    private final List<Selection> selections;
    
    public GameSession() {
        this.selections = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "GameSession - first time: " + this.firstTime + " start: " + startTimestamp.toString() + " end: " + endTimestamp.toString();
    }
    
    public List<Selection> getSelections() {
        return this.selections;
    }
    
    public void addSelection(Selection selection) {
        this.selections.add(selection);
    }
    
    public Integer getId() {
        return gameSessionID;
        
    }

    public void setId(Integer id) {
        this.gameSessionID = id;
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