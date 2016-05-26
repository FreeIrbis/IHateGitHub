package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.ChildDAO;
import com.quasar.hibernateh2.dao.entity.Child;
import com.quasar.hibernateh2.dao.entity.Student;
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
public class ChildDAOImpl implements ChildDAO {

    @Override
    public void addChild(Child child) throws SQLException {
    Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(child.getGender());
            session.save(child);
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
    public void updateChild(Child child) throws SQLException {
    Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(child);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }}

    @Override
    public Child getChildById(Long id) throws SQLException {
    Session session = null;
        Child child = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            child = (Child) session.load(Child.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return child;}

    @Override
    public List getAllChildren() throws SQLException {
    Session session = null;
        List<Child> childs = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            childs = session.createCriteria(Child.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return childs;}

    @Override
    public void deleteChildren(Child child) throws SQLException {
    Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(child);
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
