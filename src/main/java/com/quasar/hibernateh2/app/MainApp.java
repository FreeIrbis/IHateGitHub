package com.quasar.hibernateh2.app;

import com.quasar.hibernateh2.controller.GeneralController;
import com.quasar.hibernateh2.controller.LoginController;
import com.quasar.hibernateh2.dao.hiber_util.HibernateUtil;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Irbis
 */
public class MainApp extends Application {

    private static final String TITLE = "Main programm";
    private Stage stage;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            stage = primaryStage;
            stage.setTitle("Dtpa Prof");
            // установка иконки
            Image ix = new Image("/icon/lock.png");
            stage.getIcons().add(ix);
            // stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            // stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            gotoLogin();
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    try {
                        stop();
                    } catch (Exception ex) {
                        Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("/fxml/Login.fxml", 600, 420);
            login.setApp(this);
            Scene scene = stage.getScene();
            scene.getStylesheets().add("/styles/Login.css");

//        stage.setTitle("JavaFX and Maven");
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
            // запрет изменения размера окна
            stage.setResizable(false);
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gotoGeneral() {
        try {
            GeneralController login = (GeneralController) replaceSceneContent("/fxml/General.fxml", 1000, 600);
            login.setApp(this);
            Scene scene = stage.getScene();
            scene.getStylesheets().add("/styles/General.css");
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Initializable replaceSceneContent(String fxml, int width, int height) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, width, height);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    public boolean userLogging(String userId, String password) {
        if (Authenticator.validate(userId, password)) {
            // loggedUser = User.of(userId);
            gotoGeneral();
            return true;
        } else {
            return false;
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void stop() {
        System.out.println("Stage is closing");
        HibernateUtil.shutdown();
        System.exit(0);
    }

}
