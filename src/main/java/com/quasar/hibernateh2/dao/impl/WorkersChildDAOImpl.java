package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.WorkersChildDAO;
import com.quasar.hibernateh2.dao.entity.WorkersChild;
import com.quasar.hibernateh2.dao.hiber_util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Irbis
 */
public class WorkersChildDAOImpl implements WorkersChildDAO {

    @Override
    public void addWorkersChild(WorkersChild ws) throws SQLException {
    Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(ws);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }    
    }

    @Override
    public void updateWorkersChild(WorkersChild ws) throws SQLException {
     Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(ws);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public WorkersChild getWorkersChildById(Long id) throws SQLException {
     Session session = null;
        WorkersChild ws = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            ws = (WorkersChild) session.get(WorkersChild.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ws;
    }

    @Override
    public List getAllWorkersChilden() throws SQLException {
    Session session = null;
        List<WorkersChild> ws = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            ws = session.createCriteria(WorkersChild.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ws;
    }

    @Override
    public void deleteWorkersChild(WorkersChild ws) throws SQLException {
    Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ws);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }}
    
}
