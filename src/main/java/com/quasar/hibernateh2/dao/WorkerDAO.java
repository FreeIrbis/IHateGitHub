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
    
    public List searchAllWorkers(String name, String surname, String patronymic, String birthday, Long gender, Long department, Long benefit, Long position, Long branch) throws SQLException;

    public void deleteWorker(Worker student) throws SQLException; 
}
