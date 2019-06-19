/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.controllers;

import com.projectwork.coordinationgame.dao.GameReportDAO;
import com.projectwork.coordinationgame.dao.PresentationReportDAO;
import com.projectwork.coordinationgame.model.Game;
import com.projectwork.coordinationgame.model.GameReport;
import com.projectwork.coordinationgame.model.PresentationReport;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lephise
 */
@RestController
public class ReportController {
    
    private PresentationReportDAO presentationReportDao = new PresentationReportDAO();
    private GameReportDAO gameReportDao = new GameReportDAO();
    
    
    /**
     * Rest endpoint (GET): /api/presentations/{id}/report
     * Get report for a specified presentation
     * @return List<PresentationReport>
     */ 
    @GetMapping("/api/presentations/{id}/report")
    public List<PresentationReport> getPresentationReport(@PathVariable String id) {
        // Fetch the game from repository
        return presentationReportDao.findByPresentationId(Integer.parseInt(id));
    }
    
    /**
     *Rest endpoint (GET): /api/games{id}/report
     *Get report for a speficic game
     * @return List<GameReport> 
     */ 
    @GetMapping("/api/games/{id}/report")
    public List<GameReport> getGameReport(@PathVariable String id) {
        // Fetch the game from repository
        return gameReportDao.findByGameId(Integer.parseInt(id));
    }
    
}
