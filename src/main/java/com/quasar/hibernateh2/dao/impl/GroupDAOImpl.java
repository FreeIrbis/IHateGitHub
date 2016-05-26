package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.GroupDAO;
import com.quasar.hibernateh2.dao.entity.Groups;
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
public class GroupDAOImpl implements GroupDAO {

    @Override
    public void addGroups(Groups group) throws SQLException {
    Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(group);
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
    public void updateGroups(Groups group) throws SQLException {
    Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(group);
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
    public Groups getGroupsById(Long id) throws SQLException {
     Session session = null;
        Groups group = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            group = (Groups) session.load(Groups.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return group;
    }

    @Override
    public List getAllGroups() throws SQLException {
    Session session = null;
        List<Groups> groups = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            groups = session.createCriteria(Groups.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return groups;
    }

    @Override
    public void deleteGroups(Groups group) throws SQLException {
    Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(group);
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
