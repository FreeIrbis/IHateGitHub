package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Benefit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface BenefitDAO {
    
    public void addBenefit(Benefit proforg) throws SQLException;

    public void updateBenefit(Benefit proforg) throws SQLException;

    public Benefit getBenefitById(Long id) throws SQLException;

    public List getAllBenefits() throws SQLException;

    public void deleteBenefit(Benefit student) throws SQLException;
}
