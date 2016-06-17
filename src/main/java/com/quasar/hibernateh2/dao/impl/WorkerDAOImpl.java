package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.WorkerDAO;
import com.quasar.hibernateh2.dao.entity.User;
import com.quasar.hibernateh2.dao.entity.Worker;
import com.quasar.hibernateh2.dao.hiber_util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Irbis
 */
public class WorkerDAOImpl implements WorkerDAO {

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
        }
    }

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
            worker = (Worker) session.get(Worker.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return worker;
    }

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
        return workers;
    }

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

    @Override
    public List searchAllWorkers(String name, String surname, String patronymic, String birthday, Long gender, Long department, Long benefit, Long position, Long branch) throws SQLException {
        Session session = null;
        List<Worker> workers = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Worker.class);
            criteria.setFetchMode("gender", FetchMode.SELECT);
            if(name != null) {
                criteria.add(Restrictions.like("name", name + "%"));
            }
            if(surname != null) {
                criteria.add(Restrictions.like("surname", surname + "%"));
            }
            if(patronymic != null) {
                criteria.add(Restrictions.like("patronymic", patronymic + "%"));
            }
            if(birthday != null) {
                criteria.add(Restrictions.like("birthday", "%" + birthday + "%"));
            }
            if(gender != null) {
                Criteria genderCriteria = criteria.createCriteria("gender");
                genderCriteria.add(Restrictions.eq("id", gender));
                System.out.println("gender.toString() = " + gender.toString());
            }
//            if(department != null) {
//                criteria.add(Restrictions.eq("department", department));
//            }
//            if(benefit != null) {
//                criteria.add(Restrictions.eq("benefit", benefit));
//            }
//            if(position != null) {
//                criteria.add(Restrictions.eq("position", position));
//            }
//            if(branch != null) {
//                criteria.add(Restrictions.eq("branch", branch));
//            }
            
//            Criteria criteria = session.createCriteria(Worker.class);
//            if(name != null) {
//                criteria.add(Restrictions.like("name", name + "%"));
//            }
//            if(surname != null) {
//                criteria.add(Restrictions.like("surname", surname + "%"));
//            }
//            if(patronymic != null) {
//                criteria.add(Restrictions.like("patronymic", patronymic + "%"));
//            }
//            if(birthday != null) {
//                criteria.add(Restrictions.like("birthday", "%" + birthday + "%"));
//            }
//            if(gender != null) {
//                criteria.add(Restrictions.eq("gender", gender));
//            }
//            if(department != null) {
//                criteria.add(Restrictions.eq("department", department));
//            }
//            if(benefit != null) {
//                criteria.add(Restrictions.eq("benefit", benefit));
//            }
//            if(position != null) {
//                criteria.add(Restrictions.eq("position", position));
//            }
//            if(branch != null) {
//                criteria.add(Restrictions.eq("branch", branch));
//            }
            workers = criteria.list();
            System.out.println("отдали " + gender.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return workers;
    }
}
