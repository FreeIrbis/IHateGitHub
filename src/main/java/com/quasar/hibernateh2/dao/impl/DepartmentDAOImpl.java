package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.DepartmentDAO;
import com.quasar.hibernateh2.dao.entity.Branch;
import com.quasar.hibernateh2.dao.entity.Department;
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
public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public void addDepartment(Department department) throws SQLException {
    Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }}

    @Override
    public void updateDepartment(Department department) throws SQLException {
    Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }}

    @Override
    public Department getDepartmentById(Long id) throws SQLException {
    Session session = null;
        Department department = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            department = (Department) session.load(Department.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return department;}

    @Override
    public List getAllDepartments() throws SQLException {
    Session session = null;
        List<Department> departments = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            departments = session.createCriteria(Department.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return departments;}

    @Override
    public void deleteDepartment(Department department) throws SQLException {
    Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(department);
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
