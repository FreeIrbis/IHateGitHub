package com.quasar.hibernateh2.test;

import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.Child;
import com.quasar.hibernateh2.dao.entity.Gender;
import com.quasar.hibernateh2.dao.entity.Worker;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artur
 */
public class TestManyToMany {
    public static void main(String[] args) {
        try {
                    Worker w1 = new Worker("Black Black");
       Worker w2 = new Worker("White White");

       Factory.getInstance().getWorkerDAO().addWorker(w1);
      Factory.getInstance().getWorkerDAO().addWorker(w2);
            List<Worker> workers = Factory.getInstance().getWorkerDAO().getAllWorkers();
//        Gender m = new Gender("м", 1L);
//        Gender g = new Gender("Ж", 2L);
//        Child child = new Child("Катя");
//        child.setGender(g);
//        Child child2 = new Child("Женя");
//        child2.setGender(m);
//        Factory.getInstance().getChildDAO().addChild(child);
//        Factory.getInstance().getChildDAO().addChild(child2);
            List<Child> children = Factory.getInstance().getChildDAO().getAllChildren();
            for(Worker w : workers) {
                for(Child c : children) {
                    w.getChildren().add(c);
                }
                Factory.getInstance().getWorkerDAO().updateWorker(w);
            }
            workers = Factory.getInstance().getWorkerDAO().getAllWorkers();
            for(Worker w : workers) {
                System.out.println("имя родителя = " + w.getName());
                for(Child cc : w.getChildren()) {
                    System.out.println("имя ребенка = " + cc.getName());
                }
                System.out.println("_________________________________________");
            }
           
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(TestManyToMany.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.exit(0);
        }
    }
}
