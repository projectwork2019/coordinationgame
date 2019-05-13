package com.projectwork.coordinationgame.dao;

import com.projectwork.coordinationgame.model.Presentation;
import com.projectwork.coordinationgame.service.HibernateUtil;
import java.util.Collections;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *This class is based on the convention of DAO classes with Hibernate used in many such projects.
 * 
 * @author mohamadhassan
 */
public class PresentationDAO extends GenericDAO<Presentation> {
//
//    private Session currentSession;
//    private Transaction currentTransaction;
//
//    //Default constructor used to instanciate an empty PresentationDAO object
//    public PresentationDAO() {
//    }

//    public Session openCurrentSession() {
//        currentSession = getSessionFactory().openSession();
//        currentTransaction = currentSession.beginTransaction();
//        return currentSession;
//    }
//    
//    public Session openCurrentSessionWithTransaction() {
//        currentSession = getSessionFactory().openSession();
//        currentTransaction = currentSession.beginTransaction();
//        return currentSession;
//    }
//
//    public void closeCurrentSession() {
//        currentSession.close();
//    }
//
//    public void closeCurrentSessionWithTransaction() {
//        currentTransaction.commit();
//        currentSession.close();
//    }
//
//    private static SessionFactory getSessionFactory() {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
//        return sessionFactory;
//    }
//
//    public Session getCurrentSession() {
//        return currentSession;
//    }
//
//    public void setCurrentSession(Session currentSession) {
//        this.currentSession = currentSession;
//    }
//
//    public Transaction getCurrentTransaction() {
//        return currentTransaction;
//    }
//
//    public void setCurrentTransaction(Transaction currentTransaction) {
//        this.currentTransaction = currentTransaction;
//    }
//
//    @Override
//    public void persist(Presentation entity) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            session.save(entity);
//            tx.commit();
//        }
//        catch (Exception e) {
//            if (tx!=null) tx.rollback();
//            throw e;
//        }
//        finally {
//            session.close();
//        }
//    }
//
//    @Override
//    public void update(Presentation entity) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            session.update(entity);
//            tx.commit();
//        }
//        catch (Exception e) {
//            if (tx!=null) tx.rollback();
//            throw e;
//        }
//        finally {
//            session.close();
//        }
////        getCurrentSession().update(entity);
//    }
//
//    @Override
//    public Presentation findById(Integer id) {
//        Presentation presentation = (Presentation) getCurrentSession().get(Presentation.class, id);
//        return presentation;
//    }
//
//    @Override
//    public void delete(Presentation entity) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            session.delete(entity);
//            tx.commit();
//        }
//        catch (Exception e) {
//            if (tx!=null) tx.rollback();
//            throw e;
//        }
//        finally {
//            session.close();
//        }
////        getCurrentSession().delete(entity);
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<Presentation> findAll() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
////        CriteriaQuery<Presentation> criteria = session.getCriteriaBuilder().createQuery(Presentation.class);
////        List<Presentation> presentations = (List<Presentation>) getCurrentSession().createQuery("from presentation").list();
////        criteria.select(criteria.from(Presentation.class));
//        Criteria criteria = session.createCriteria(Presentation.class);
//        criteria.createAlias("games", "g");
//        criteria.add(Restrictions.eq("g.enabled", true));
//        List<Presentation> presentations = (List<Presentation>) criteria.list(); //session.createQuery(criteria).getResultList();
//        return presentations;
//    }
//    
//    @Override
//    public List<Presentation> findAllShuffeled() {
//        List<Presentation> list = this.findAll();
//        Collections.shuffle(list);
//        return list;
//    }
//
//    @Override
//    public void deleteAll() {
//        List<Presentation> entityList = findAll();
//        for (Presentation entity : entityList) {
//            delete(entity);
//        }
//    }

}
