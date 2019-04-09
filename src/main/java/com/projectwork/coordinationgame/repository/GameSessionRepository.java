/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.repository;

import com.projectwork.coordinationgame.model.GameSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
// import org.springframework.web.bind.annotation.CrossOrigin;
/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */
@Repository
public interface GameSessionRepository extends CrudRepository<GameSession, Integer> {
    
}
