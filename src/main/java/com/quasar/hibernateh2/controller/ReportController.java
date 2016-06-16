package com.quasar.hibernateh2.controller;

import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.ExelModel;
import com.quasar.hibernateh2.util.exel.ExelType;
import com.quasar.hibernateh2.util.exel.ExelWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Irbis
 */
public class ReportController extends AbstractController implements Initializable {

    @FXML
    ComboBox comboReport;
    @FXML
    Button btnGetReport;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> reports = FXCollections.observableArrayList();
        reports.add("студенты");
        reports.add("сотрудники");
        reports.add("дети сотрудников");
        comboReport.setItems(reports);
    }

    public void getReport() throws SQLException {
        if (comboReport.getValue().toString() == "студенты") {
            List<ExelModel> studs = Factory.getInstance().getStudentDAO().getAllStudents();
            List<List<String>> listForReport = new ArrayList<>();
            for (ExelModel exModel : studs) {
                listForReport.add(exModel.convertToListStrings());
                System.out.println(exModel.convertToListStrings());
            }
            ExelWriter ew = new ExelWriter(ExelType.XLSX);
            try {
                ew.write(listForReport, "./student.xlsx", "student");
                System.out.println("xls");

            } catch (IOException ex) {
                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (comboReport.getValue().toString() == "сотрудники") {
            List<ExelModel> works = Factory.getInstance().getWorkerDAO().getAllWorkers();
            List<List<String>> listForReport = new ArrayList<>();
            for (ExelModel exModel : works) {
                listForReport.add(exModel.convertToListStrings());
                System.out.println(exModel.convertToListStrings());
            }
            ExelWriter ew = new ExelWriter(ExelType.XLSX);
            try {
                ew.write(listForReport, "./workers.xlsx", "worker");
                System.out.println("xls");

            } catch (IOException ex) {
                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
//        if (comboReport.getValue().toString() == "дети сотрудников") {
//            List<ExelModel> childs = Factory.getInstance().getChildDAO().getAllChildren();
//            List<List<String>> listForReport = new ArrayList<>();
//            for (ExelModel exModel : childs) {
//                listForReport.add(exModel.convertToListStrings());
//                System.out.println(exModel.convertToListStrings());
//            }
//            ExelWriter ew = new ExelWriter(ExelType.XLSX);
//            try {
//                ew.write(listForReport, "./workerschild.xlsx", "children");
//                System.out.println("xls");
//
//            } catch (IOException ex) {
//                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
}
