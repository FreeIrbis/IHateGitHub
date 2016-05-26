package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.WorkersChild;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface WorkersChildDAO {
    
    public void addWorkersChild(WorkersChild proforg) throws SQLException;

    public void updateWorkersChild(WorkersChild proforg) throws SQLException;

    public WorkersChild getWorkersChildById(Long id) throws SQLException;

    public List getAllWorkersChilden() throws SQLException;

    public void deleteWorkersChild(WorkersChild student) throws SQLException;
    
}
