package com.quasar.hibernateh2.controller;

import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        User user = new User();
        try {
            user=Factory.getInstance().getUserDAO().getUserById(1L);
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(user.getLoginUser()+"ЖООПАА"+user.getPassUser());
        
    }
    
}
