/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Role;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface RoleDAO {
    
     public Role getUserById(Long id) throws SQLException;
     
     public void addRole(Role role) throws SQLException;
     
      public List getAllRoles() throws SQLException;
}
