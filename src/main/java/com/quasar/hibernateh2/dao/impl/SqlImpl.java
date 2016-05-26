
package com.quasar.hibernateh2.dao.impl;

import com.quasar.hibernateh2.dao.SqlDAO;
import com.quasar.hibernateh2.dao.entity.ExelModel;
import com.quasar.hibernateh2.dao.hiber_util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author artur
 */
public class SqlImpl implements SqlDAO{

    @Override
    public List<ExelModel> executeSelectSql(String sql) throws SQLException {
        List<ExelModel> list = null;
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            list = session.createSQLQuery(sql).list();
            // sess.createSQLQuery("SELECT * FROM CATS").addEntity(Cat.class);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }
    
}
