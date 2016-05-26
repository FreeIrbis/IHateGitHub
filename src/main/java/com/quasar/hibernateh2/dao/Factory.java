package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Benefit;
import com.quasar.hibernateh2.dao.impl.BenefitDAOImpl;
import com.quasar.hibernateh2.dao.impl.BranchDAOImpl;
import com.quasar.hibernateh2.dao.impl.DepartmentDAOImpl;
import com.quasar.hibernateh2.dao.impl.GenderDAOImpl;
import com.quasar.hibernateh2.dao.impl.GroupDAOImpl;
import com.quasar.hibernateh2.dao.impl.PositionDAOImpl;
import com.quasar.hibernateh2.dao.impl.SqlImpl;
import com.quasar.hibernateh2.dao.impl.StudentDAOImpl;
import com.quasar.hibernateh2.dao.impl.WorkerDAOImpl;

public class Factory {

    private static StudentDAO studentDAO = null;
    private static WorkerDAO workerDAO = null;
    private static PositionDAO positionDAO = null;
    private static GenderDAO genderDAO = null;
    private static GroupDAO groupDAO = null;
    private static BenefitDAO benefitDAO = null;
    private static BranchDAO branchDAO = null;
    private static DepartmentDAO departmentDAO = null;
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

    public GroupDAO getGroupDAO() {
        if (groupDAO == null) {
            groupDAO = new GroupDAOImpl();
        }
        return groupDAO;
    }

    public SqlImpl getSqlDAO() {
        if (sqlDAO == null) {
            sqlDAO = new SqlImpl();
        }
        return sqlDAO;
    }

    public DepartmentDAO getDepartmentDAO() {
        if (departmentDAO == null) {
            departmentDAO = new DepartmentDAOImpl();
        }
        return departmentDAO;
    }

    public BranchDAO getBranchDAO() {

        if (branchDAO == null) {
            branchDAO = new BranchDAOImpl();
        }
        return branchDAO;
    }

    public BenefitDAO getBenefitDAO() {
        if (benefitDAO == null) {
            benefitDAO = new BenefitDAOImpl();
        }
        return benefitDAO;

    }

}
