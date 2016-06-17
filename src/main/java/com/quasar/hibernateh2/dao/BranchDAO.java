package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Branch;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface BranchDAO {
    
    public void addBranch(Branch proforg) throws SQLException;

    public void updateBranch(Branch proforg) throws SQLException;

    public Branch getBranchById(Long id) throws SQLException;

    public List<Branch> getAllBranchs() throws SQLException;

    public void deleteBranch(Branch student) throws SQLException;
}
