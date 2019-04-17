/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.repository;

import com.projectwork.coordinationgame.model.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */
@Repository
public interface PresentationRepository extends CrudRepository<Presentation, Integer> {
    
}
