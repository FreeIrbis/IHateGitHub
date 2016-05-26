package com.quasar.hibernateh2.dao;

import java.sql.SQLException;
import java.util.List;
import com.quasar.hibernateh2.dao.entity.Student;

public interface StudentDAO {

    public void addStudent(Student student) throws SQLException;
    
    public void saveOnlyStudent(Student student) throws SQLException;

    public void updateStudent(Student student) throws SQLException;

    public Student getStudentById(Long id) throws SQLException;

    public List getAllStudents() throws SQLException;

    public void deleteStudent(Student student) throws SQLException;
}
