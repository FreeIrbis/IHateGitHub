package com.quasar.hibernateh2.dao;

import com.quasar.hibernateh2.dao.entity.Position;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public interface PositionDAO {

    public void addPosition(Position position) throws SQLException;

    public void updatePosition(Position position) throws SQLException;

    public Position getPositionById(Long id) throws SQLException;

    public List<Position> getAllPositions() throws SQLException;

    public void deletePosition(Position position) throws SQLException;
}
