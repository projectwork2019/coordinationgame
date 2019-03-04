package com.projectwork.coordinationgame;

import com.projectwork.coordinationgame.model.Game;
import com.projectwork.coordinationgame.repository.GameRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoordinationgameApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoordinationgameApplication.class, args);
    }

    @Bean
    ApplicationRunner init(GameRepository repository) {
        return args -> {
            String game1String = "{ 'components': [ { 'componentId': '1', 'nodes': [ { 'nodeId': '1', 'alignment': 'LEFT', 'position': '0' }, { 'nodeId': '2', 'alignment': 'RIGHT', 'position': '0' } ], 'edges': [ { 'edgeId': '1', 'leftNode': '1', 'rightNode': '2' } ] } }";
            String game2String = "{ 'components': [ { 'componentId': '1', 'nodes': [ { 'nodeId': '1', 'alignment': 'LEFT', 'position': '0' }, { 'nodeId': '2', 'alignment': 'RIGHT', 'position': '0' } ], 'edges': [ { 'edgeId': '1', 'leftNode': '1', 'rightNode': '2' } ] } }";

            Game game1 = new Game();
            game1.setId(1L);
            game1.setGameDataObject(game1String);

            Game game2 = new Game();
            game2.setId(2L);
            game2.setGameDataObject(game2String);
        };
    }
}