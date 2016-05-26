package com.quasar.hibernateh2.test;

import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.Position;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public class MainPosition {
      
    public static void main(String[] args) throws SQLException {
        Position position = new Position();
        position.setName("Преподаватель");
        System.out.println(position);
        Factory.getInstance().getPositionDAO().addPosition(position);
        List<Position> positions = Factory.getInstance().getPositionDAO().getAllPositions();
        System.out.println("========All workers=========");
        for(Position w : positions) {
                System.out.println("Name of workers : " + 
                        w.getName() + ", age : "+ 
                        w.getId()); 
                System.out.println("=============================");              
        }
        System.exit(0);
    }
    
}
