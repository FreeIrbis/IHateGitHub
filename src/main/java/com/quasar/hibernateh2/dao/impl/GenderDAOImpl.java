package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.GenderDAO;
import com.quasar.hibernateh2.dao.entity.Gender;
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
public class GenderDAOImpl implements GenderDAO {

    @Override
    public void addGender(Gender gender) throws SQLException {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(gender);
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
    public Gender getGenderById(Long id) throws SQLException {
     Session session = null;
        Gender gender = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            gender = (Gender) session.load(Gender.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return gender;}

    @Override
    public List<Gender> getAllGender() throws SQLException {
        Session session = null;
        List<Gender> genders = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            genders = session.createCriteria(Gender.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return genders;
    }

    @Override
    public void deleteGender(Gender gender) throws SQLException {
    Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(gender);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }}

}
