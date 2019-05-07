/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_session_id")
    private Integer gameSessionID;
    
    @Column(name = "first_time")
    private boolean firstTime;
    
    @Column(name = "prev_knowledge")
    private boolean prevKnowledge;
    
    @Column(name = "start_timestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    //@JsonFormat(pattern = "yyyy-MM-dd, HH:mm:ss")
    private LocalDateTime startTimestamp;
    
    @Column(name = "end_timestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinTable(
            name="game_session_selection",
            joinColumns = @JoinColumn(name = "game_session_id"),
            inverseJoinColumns = 
                    {
                        @JoinColumn(name = "confidence"),
                        @JoinColumn(name = "presentation_id"),
                        @JoinColumn(name = "selected_node")
                    }
            
    )
    private Set<Selection> selections;
    
    public GameSession() {
        this.selections = new HashSet<Selection>();
    }
    
    @Override
    public String toString() {
        String endtime;
        if(endTimestamp == null){
            endtime = "ONGOING";
        } else {
            endtime = endTimestamp.toString();
        }
        return "GameSession - first time: " + this.firstTime + " start: " + startTimestamp.toString() + " end: " + endtime;
    }
    
    public Set<Selection> getSelections() {
        return this.selections;
    }

    public void setSelections(Set<Selection> selections) {
        this.selections = selections;
    }
    
    public void addSelection(Selection selection) {
        if(this.selections == null) {
            this.selections = new HashSet<Selection>();
        }
        this.selections.add(selection);
    }
    
    public Integer getGameSessionID() {
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
