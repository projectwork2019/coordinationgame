/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.Category;
import com.projectwork.coordinationgame.model.Presentation;
import com.projectwork.coordinationgame.model.PresentationReport;
import com.projectwork.coordinationgame.service.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author mohamadhassan
 */
public class PresentationReportDAO {
    private Session currentSession;
    private Transaction currentTransaction;

    //Default constructor used to instanciate an empty GameDAO object
    public PresentationReportDAO() {
    }

    public List<PresentationReport> findByPresentationId(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(
	"SELECT * FROM get_report_presentation(:id)")
	.addEntity(PresentationReport.class)
	.setParameter("id", id);			
        return query.list();
    }

}