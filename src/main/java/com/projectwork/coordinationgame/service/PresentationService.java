/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.service;

import com.projectwork.coordinationgame.dao.PresentationDAO;
import com.projectwork.coordinationgame.model.Presentation;
import java.util.List;

/**
 *
 * @author mohamadhassan
 */
public class PresentationService {
    private static PresentationDAO presentationDAO;
    
    public PresentationService() {
        presentationDAO = new PresentationDAO();
    }
 
    public void persist(Presentation entity) {
        presentationDAO.openCurrentSessionWithTransaction();
        presentationDAO.persist(entity);
        presentationDAO.closeCurrentSessionWithTransaction();
    }
 
    public void update(Presentation entity) {
        presentationDAO.openCurrentSessionWithTransaction();
        presentationDAO.update(entity);
        presentationDAO.closeCurrentSessionWithTransaction();
    }
 
    public Presentation findById(Integer id) {
        presentationDAO.openCurrentSession();
        Presentation presentation = presentationDAO.findById(id);
        presentationDAO.closeCurrentSession();
        return presentation;
    }
 
    public void delete(Integer id) {
        presentationDAO.openCurrentSessionWithTransaction();
        Presentation presentation = presentationDAO.findById(id);
        presentationDAO.delete(presentation);
        presentationDAO.closeCurrentSessionWithTransaction();
    }
 
    public List<Presentation> findAll() {
        presentationDAO.openCurrentSession();
        List<Presentation> presentationss = presentationDAO.findAll();
        presentationDAO.closeCurrentSession();
        return presentationss;
    }
 
    public void deleteAll() {
        presentationDAO.openCurrentSessionWithTransaction();
        presentationDAO.deleteAll();
        presentationDAO.closeCurrentSessionWithTransaction();
    }
 
    public PresentationDAO bookDao() {
        return presentationDAO;
    }
}
