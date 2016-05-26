package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.impl.GenderDAOImpl;
import com.quasar.hibernateh2.dao.impl.PositionDAOImpl;
import com.quasar.hibernateh2.dao.impl.SqlImpl;
import com.quasar.hibernateh2.dao.impl.StudentDAOImpl;
import com.quasar.hibernateh2.dao.impl.WorkerDAOImpl;

public class Factory {

    private static StudentDAO studentDAO = null;
    private static WorkerDAO workerDAO = null;
    private static PositionDAO positionDAO = null;
    private static GenderDAO genderDAO = null;
    private static Factory instance = null;
    private static SqlImpl sqlDAO = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public StudentDAO getStudentDAO() {
        if (studentDAO == null) {
            studentDAO = new StudentDAOImpl();
        }
        return studentDAO;
    }

    public WorkerDAO getWorkerDAO() {
        if (workerDAO == null) {
            workerDAO = new WorkerDAOImpl();
        }
        return workerDAO;
    }

    public PositionDAO getPositionDAO() {
        if (positionDAO == null) {
            positionDAO = new PositionDAOImpl();
        }
        return positionDAO;
    }
    
    public GenderDAO getGenderDAO() {
        if (genderDAO == null) {
            genderDAO = new GenderDAOImpl();
        }
        return genderDAO;
    }
    
    public SqlImpl getSqlDAO() {
        if (sqlDAO == null) {
            sqlDAO = new SqlImpl();
        }
        return sqlDAO;
    }
    
}
