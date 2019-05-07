/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.controllers;

import com.projectwork.coordinationgame.dao.PresentationReportDAO;
import com.projectwork.coordinationgame.model.Game;
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
    
    @GetMapping("/api/presentations/{id}/report")
    public List<PresentationReport> getGames(@PathVariable String id) {
        // Fetch the game from repository
        return presentationReportDao.findByPresentationId(Integer.parseInt(id));
    }
    
}
