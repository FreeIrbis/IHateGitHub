package com.quasar.hibernateh2.test;

import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.Benefit;
import com.quasar.hibernateh2.dao.entity.Branch;
import com.quasar.hibernateh2.dao.entity.Gender;
import com.quasar.hibernateh2.dao.entity.Groups;
import com.quasar.hibernateh2.dao.entity.Role;
import com.quasar.hibernateh2.dao.entity.Student;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MainStudent {
    
    public static void main(String[] args) throws SQLException, ParseException {

        Student s1 = new Student();
//
        Role r1 = new Role();
        r1.setTitle("sdf dsfs");
        Gender gender = new Gender("мv", 1L);
        Groups group = new Groups();
        group.setName("A1");
        Benefit benefit = new Benefit();
        benefit.setName("Starosta");
        Branch branch = new Branch();
        branch.setName("Potok");
//        Role r2 = new Role();
//        r2.setTitle("sdf sdfs");

        s1.setName("Ivan");
        s1.setPatronymic("Ivanovish");
        s1.setSurname("Ivanov");
        s1.setAge(21l);
        //System.out.println(new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(test[9]).getTime()));
        
        s1.setBirthday(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-20").getTime()));/*"20-02-2016"*/
        s1.setGender(gender);
        s1.setGroups(group);
        s1.setBenefit(benefit);
        s1.setBranch(branch);
        //s1.setRole(r1);
//        s2.setName("Petrova Alisa");
//        s2.setAge(24l);
//        s2.setBirthday("20-02-2016");
//        s2.setRole(r2);
                
        Factory.getInstance().getStudentDAO().addStudent(s1);
        
        //Factory.getInstance().getStudentDAO().addStudent(s2);    
        
          
        
        List<Student> studs = Factory.getInstance().getStudentDAO().getAllStudents();
        System.out.println("========All students=========");
        for(Student s : studs) {
                System.out.println("Name of students : " + 
                        s.getName() + ", age : " + 
                        s.getAge() +",  id : " + 
                        s.getId() + ", role : " + 
                        s.getRole() + ", date : " + 
                s.getBirthday());
                System.out.println("=============================");              
        }
        System.exit(0);
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