package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Child;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface ChildDAO {
    public void addChild(Child student) throws SQLException;

    public void updateChild(Child student) throws SQLException;

    public Child getChildById(Long id) throws SQLException;

    public List getAllChildren() throws SQLException;

    public void deleteChildren(Child student) throws SQLException;
    
}
