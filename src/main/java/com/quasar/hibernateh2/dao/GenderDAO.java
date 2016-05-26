package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Gender;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface GenderDAO {
    
    public void addGender (Gender gender) throws SQLException;
 
    public Gender getGenderById(Long id) throws SQLException;

    public List<Gender> getAllGender() throws SQLException;

    public void deleteWorkersChild(Gender gender) throws SQLException;
    
}
