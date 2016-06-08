package com.quasar.hibernateh2.dao.hiber_util;

import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.*;
import java.io.File;
import java.sql.SQLException;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            boolean initFromXML = true;
            boolean dbExists = new File("./test.mv.db").exists();

            Configuration configuration = new Configuration();

            if (initFromXML) {
                initFromXml(configuration);
            } else {
                initFromJava(configuration);
            }
            System.out.println("______________________________________");
            System.out.println(configuration.getProperties());
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            serviceRegistry = builder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            //sessionFactory = new Configuration().configure().buildSessionFactory(null);
            if (!dbExists) {
                initDb();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

    private static void initFromXml(Configuration configuration) {
        System.out.println("Настройка из xml");
        configuration.configure();
        //При вызове метода configure() без параметров, настройки беруться из файла nibernate.cfg.xml
        // new Configuration().addResource("hibernate.cfg.xml").configure();
        // configuration.configure(".\\src\\main\\resources\\hibernate.cfg.xml");
    }

    private static void initFromJava(Configuration configuration) {
        System.out.println("Настройка из java");
        // we can set mapping file or class with annotation
        // addClass(Employee1.class) will look for resource
        // com/journaldev/hibernate/model/Employee1.hbm.xml (not good)
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:h2:./test");
        prop.setProperty("hibernate.connection.username", "");
        prop.setProperty("hibernate.connection.password", "");
        prop.setProperty("hibernate.default_schema", "PUBLIC");
        // SQL dialect
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        // Drop and re-create the database schema on startup
        prop.setProperty("hbm2ddl.auto", "update"); // update create
        // JDBC connection pool (use the built-in)
        prop.setProperty("connection.pool_size", "1");
        // Disable the second-level cache
        prop.setProperty("cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider");
        // Echo all executed SQL to stdout
        prop.setProperty("show_sql", "true");
        prop.setProperty("hibernate.format_sql", "true");

        configuration
            .addProperties(prop)
            .addAnnotatedClass(Benefit.class)
            .addAnnotatedClass(Branch.class)
            .addAnnotatedClass(Child.class)
            .addAnnotatedClass(Department.class)
            .addAnnotatedClass(Gender.class)
            .addAnnotatedClass(Groups.class)
            .addAnnotatedClass(Position.class)
            .addAnnotatedClass(Role.class)
            .addAnnotatedClass(Student.class)
            .addAnnotatedClass(Worker.class)
            .addAnnotatedClass(WorkersChild.class);
    }

    private static void initDb() {
        try {
            Factory.getInstance().getGenderDAO().addGender(new Gender("м"));
            Factory.getInstance().getGenderDAO().addGender(new Gender("ж"));
            
            Factory.getInstance().getPositionDAO().addPosition(new Position("Учитель"));
            Factory.getInstance().getPositionDAO().addPosition(new Position("Ректор"));
            Factory.getInstance().getPositionDAO().addPosition(new Position("Сотрудник"));
            Factory.getInstance().getPositionDAO().addPosition(new Position("Прочее"));
            
            Factory.getInstance().getGroupDAO().addGroups(new Groups("АТР"));
            Factory.getInstance().getGroupDAO().addGroups(new Groups("АД"));
            Factory.getInstance().getGroupDAO().addGroups(new Groups("ЭМО"));
            
            Factory.getInstance().getDepartmentDAO().addDepartment(new Department("Факультет Дороги"));
            Factory.getInstance().getDepartmentDAO().addDepartment(new Department("Факультет Транспорт"));
        
            Factory.getInstance().getBenefitDAO().addBenefit(new Benefit("Инвалиды"));
            Factory.getInstance().getBenefitDAO().addBenefit(new Benefit("Сироты"));
            Factory.getInstance().getBenefitDAO().addBenefit(new Benefit("Прочее"));
            
            Factory.getInstance().getBranchDAO().addBranch(new Branch("123"));
            Factory.getInstance().getBranchDAO().addBranch(new Branch("456"));
        } catch (SQLException ex) {
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
