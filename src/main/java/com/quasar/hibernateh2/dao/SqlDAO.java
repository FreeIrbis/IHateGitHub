package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.ExelModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface SqlDAO {
    
    public List<ExelModel> executeSelectSql(String sql) throws SQLException;

}
