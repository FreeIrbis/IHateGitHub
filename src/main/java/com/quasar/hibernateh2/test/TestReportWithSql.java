package com.quasar.hibernateh2.test;

import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.ExelModel;
import com.quasar.hibernateh2.util.exel.ExelType;
import com.quasar.hibernateh2.util.exel.ExelWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artur
 */
public class TestReportWithSql {
    // select * from "PUBLIC".STUDENT;
    public static void main(String[] args) {
        try {
            List list = Factory.getInstance().getSqlDAO().executeSelectSql("select * from \"PUBLIC\".STUDENT");
            List<ExelModel> studs = Factory.getInstance().getSqlDAO().executeSelectSql("select * from \"PUBLIC\".STUDENT");
            List<List<String>> listForReport = new ArrayList<>();
            for(ExelModel exModel : studs) {
                listForReport.add(exModel.convertToListStrings());
                System.out.println(exModel.convertToListStrings());
            }
            ExelWriter ew = new ExelWriter(ExelType.XLSX);
            try {
                ew.write(listForReport, "./student.xlsx", "student");
                System.out.println("xls");
                
            } catch (IOException ex) {
                Logger.getLogger(TestReportWithSql.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestReportWithSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.exit(0);
        }
        
         
    }
   
}
