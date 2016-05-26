package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Groups;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface GroupDAO {
    
    public void addGroups(Groups proforg) throws SQLException;

    public void updateGroups(Groups proforg) throws SQLException;

    public Groups getGroupsById(Long id) throws SQLException;

    public List getAllGroups() throws SQLException;

    public void deleteGroups(Groups student) throws SQLException;
}
