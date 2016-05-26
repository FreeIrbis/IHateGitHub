package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.PositionDAO;
import com.quasar.hibernateh2.dao.entity.Position;
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
public class PositionDAOImpl implements PositionDAO {

    @Override
    public void addPosition(Position position) throws SQLException {
    Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(position);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }}

    @Override
    public void updatePosition(Position position) throws SQLException {
    Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(position);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }}

    @Override
    public Position getPositionById(Long id) throws SQLException {
    Session session = null;
        Position position = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            position = (Position) session.load(Position.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return position;}

    @Override
    public List<Position> getAllPositions() throws SQLException {
    Session session = null;
        List<Position> positions = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            positions = session.createCriteria(Position.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return positions;}

    @Override
    public void deletePosition(Position position) throws SQLException {
    Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(position);
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
