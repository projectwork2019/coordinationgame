package com.projectwork.coordinationgame.repository;

import com.projectwork.coordinationgame.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author antti
 */

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}