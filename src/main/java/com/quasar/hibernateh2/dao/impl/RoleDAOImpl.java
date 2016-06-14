/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.RoleDAO;
import com.quasar.hibernateh2.dao.entity.Groups;
import com.quasar.hibernateh2.dao.entity.Role;
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
public class RoleDAOImpl implements RoleDAO {

    @Override
    public Role getUserById(Long id) throws SQLException {
    Session session = null;
        Role role = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            role = (Role) session.load(Role.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return role;}

    @Override
    public void addRole(Role role) throws SQLException {
     Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }}

    @Override
    public List getAllRoles() throws SQLException {
     Session session = null;
        List<Role> groups = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            groups = session.createCriteria(Role.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return groups;}
    
    
    
   
}
