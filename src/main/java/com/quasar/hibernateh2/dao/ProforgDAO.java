package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Proforg;
import com.quasar.hibernateh2.dao.entity.Student;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface ProforgDAO {
    
    public void addProforg(Proforg proforg) throws SQLException;

    public void updateProforg(Proforg proforg) throws SQLException;

    public Proforg getProforgById(Long id) throws SQLException;

    public List getAllProforgs() throws SQLException;

    public void deleteProforg(Student student) throws SQLException;
}
