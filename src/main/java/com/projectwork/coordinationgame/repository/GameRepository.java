package com.projectwork.coordinationgame.repository;

import com.projectwork.coordinationgame.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
// import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author antti
 */

@Repository
// @CrossOrigin(origins = "http://localhost:4200")
public interface GameRepository extends CrudRepository<Game, Integer> {
}