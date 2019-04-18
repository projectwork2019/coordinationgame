package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.Presentation;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *This class is based on the convention of DAO classes with Hibernate used in many such projects.
 * 
 * @author mohamadhassan
 */
public class PresentationDAO implements DAOInterface<Presentation, Integer> {

    private Session currentSession;
    private Transaction currentTransaction;

    //Default constructor used to instanciate an empty PresentationDAO object
    public PresentationDAO() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(Presentation entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Presentation entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Presentation findById(Integer id) {
        Presentation presentation = (Presentation) getCurrentSession().get(Presentation.class, id);
        return presentation;
    }

    @Override
    public void delete(Presentation entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Presentation> findAll() {
        List<Presentation> presentations = (List<Presentation>) getCurrentSession().createQuery("from presentation").list();
        return presentations;
    }

    @Override
    public void deleteAll() {
        List<Presentation> entityList = findAll();
        for (Presentation entity : entityList) {
            delete(entity);
        }
    }

}
