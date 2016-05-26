package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.BenefitDAO;
import com.quasar.hibernateh2.dao.entity.Benefit;
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
public class BenefitDAOImpl implements BenefitDAO {

    @Override
    public void addBenefit(Benefit benefit) throws SQLException {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(benefit);
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
    public void updateBenefit(Benefit benefit) throws SQLException {
         Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(benefit);
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
    public Benefit getBenefitById(Long id) throws SQLException {
      Session session = null;
        Benefit benefit = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            benefit = (Benefit) session.load(Benefit.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return benefit;
    }

    @Override
    public List getAllBenefits() throws SQLException {
     Session session = null;
        List<Benefit> benefits = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            benefits = session.createCriteria(Benefit.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return benefits;
    }

    @Override
    public void deleteBenefit(Benefit benefit) throws SQLException {
     Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(benefit);
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
    
