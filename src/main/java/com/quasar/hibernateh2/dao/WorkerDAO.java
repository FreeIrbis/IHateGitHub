package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Worker;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface WorkerDAO {
    
   public void addWorker(Worker student) throws SQLException;

    public void updateWorker(Worker student) throws SQLException;

    public Worker getWorkerById(Long id) throws SQLException;

    public List getAllWorkers() throws SQLException;

    public void deleteWorker(Worker student) throws SQLException; 
}
