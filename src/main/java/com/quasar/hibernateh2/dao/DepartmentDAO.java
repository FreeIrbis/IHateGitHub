package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Department;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface DepartmentDAO {
    
     public void addDepartment(Department proforg) throws SQLException;

    public void updateDepartment(Department proforg) throws SQLException;

    public Department getDepartmentById(Long id) throws SQLException;

    public List getAllDepartments() throws SQLException;

    public void deleteDepartment(Department student) throws SQLException;
}
