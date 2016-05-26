package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.StudentDAO;
import com.quasar.hibernateh2.dao.entity.Student;
import com.quasar.hibernateh2.dao.hiber_util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void addStudent(Student student) throws SQLException {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(student.getGender());
            session.save(student.getGroups());
            session.save(student.getBenefit());
            session.save(student.getBranch());
            if(student.getRole() != null) {
                session.save(student.getRole());
            }
            
            session.save(student);
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
    public void saveOnlyStudent(Student student) throws SQLException {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(student);
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
    public void updateStudent(Student stud) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(stud.getRole());
            session.update(stud);
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
    public Student getStudentById(Long id) throws SQLException {
        Session session = null;
        Student stud = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            stud = (Student) session.load(Student.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return stud;
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        Session session = null;
        List<Student> studs = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            studs = session.createCriteria(Student.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return studs;
    }

    @Override
    public void deleteStudent(Student stud) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(stud);
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
