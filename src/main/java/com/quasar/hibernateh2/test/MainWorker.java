package com.quasar.hibernateh2.test;

import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.Worker;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Irbis
 */
public class MainWorker {

    public static void main(String[] args) throws SQLException {

        Worker w1 = new Worker();
        Worker w2 = new Worker();

        w1.setName("Black Black");
        w2.setName("White White");

        Factory.getInstance().getWorkerDAO().addWorker(w1);
        Factory.getInstance().getWorkerDAO().addWorker(w2);
        List<Worker> workers = Factory.getInstance().getWorkerDAO().getAllWorkers();
        System.out.println("========All workers=========");
        for (Worker w : workers) {
            System.out.println("Name of workers : "
                + w.getName() + ",  id : "
                + w.getId() + ", role : ");
            System.out.println("=============================");
        }
//        studs.stream().map((s) -> {
//            System.out.println("��� �������� : " +
//                s.getName() + ", ������� : " +
//                s.getAge() +",  id : " +
//                s.getId() + ", role : " +
//                s.getRole());
//            return s;
//        }).forEach((_item) -> {       
//            System.out.println("=============================");
//        });
    }
}
