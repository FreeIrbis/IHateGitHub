package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.WorkerDAO;
import com.quasar.hibernateh2.dao.entity.Worker;
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
public class WorkerDAOImpl implements WorkerDAO{

    @Override
    public void addWorker(Worker worker) throws SQLException {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(worker);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }    }

    @Override
    public void updateWorker(Worker worker) throws SQLException {
         Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(worker);
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
    public Worker getWorkerById(Long id) throws SQLException {
         Session session = null;
        Worker worker = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            worker = (Worker) session.load(Worker.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return worker;}

    @Override
    public List<Worker> getAllWorkers() throws SQLException {
        Session session = null;
        List<Worker> workers = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            workers = session.createCriteria(Worker.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return workers; }

    @Override
    public void deleteWorker(Worker worker) throws SQLException {
       Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(worker);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
