/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.GameReport;
import com.projectwork.coordinationgame.model.PresentationReport;
import com.projectwork.coordinationgame.service.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Lephise
 */
public class GameReportDAO {
    
    public GameReportDAO(){
        
    }
    
    public List<GameReport> findByGameId(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(
	"SELECT * FROM project_work.get_report_game(:id)")
	.addEntity(GameReport.class)
	.setParameter("id", id);			
        return query.list();
    }
}