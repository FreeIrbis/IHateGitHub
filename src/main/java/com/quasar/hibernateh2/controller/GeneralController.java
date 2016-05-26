package com.quasar.hibernateh2.controller;

import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.Position;
import com.quasar.hibernateh2.dao.entity.Worker;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Irbis
 */
public class GeneralController extends AbstractController implements Initializable {
    /*Все табы*/

    @FXML
    public Tab tabPos;
    /*Поля сотрудники на добавление*/
    @FXML
    public ListView<String> profPeople = new ListView();
    @FXML
    public ListView<String> date = new ListView();
    @FXML
    public ListView<String> reportDate = new ListView();
    @FXML
    public ListView<String> settingApp = new ListView();
    @FXML
    public TextField surWorker;
    @FXML
    public TextField nameWorker;
    @FXML
    public TextField patWorker;
    @FXML
    public ComboBox depWorker;
    @FXML
    public ComboBox posWorker;
    @FXML
    public ComboBox benWorker;
    @FXML
    public Button addWorker;
    @FXML
    public TableView tableWorker;

    /*Поля должностей на добавление*/
    private ObservableList<Position> listPosition = FXCollections.observableArrayList();
    @FXML
    Label errorAddPos;
    @FXML
    Label errorUpdatePos;

    Position position = new Position();
    @FXML
    public TextField textAddNamePos;
    @FXML
    public TextField textUpdatePos;
    @FXML
    public Button btnAddPos;
    @FXML
    public ComboBox comboPos;
    @FXML
    public TableView<Position> tablePosition;
    @FXML
    public TableColumn<Position, String> NamePositionColumn;
    @FXML
    public Button btnRedPos;
    @FXML
    public Button btnDelPos;

    private ObservableList<Position> listPositionsAfterDelete = FXCollections.observableArrayList();
    List<Position> listPositions = null;
    List<String> listPositionsString = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*Заполнение таблиц*/
        //Должности
        NamePositionColumn.setCellValueFactory(new PropertyValueFactory<Position, String>("name"));
        tabPos.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tablePosition.getItems().clear();
                try {
                    listPosition.addAll(Factory.getInstance().getPositionDAO().getAllPositions());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tablePosition.setItems(listPosition);
            }
        });

        ObservableList<String> itemsP = FXCollections.observableArrayList(
                "Сотрудники", "Студенты", "Профорги", "Дети сотрудников");
        profPeople.setItems(itemsP);

        ObservableList<String> itemsD = FXCollections.observableArrayList(
                "Группы", "Должности", "Отделы", "Отделения", "Льготы");
        date.setItems(itemsD);

        ObservableList<String> itemsR = FXCollections.observableArrayList(
                "1", "2", "3", "4");
        reportDate.setItems(itemsR);

        ObservableList<String> itemsS = FXCollections.observableArrayList(
                "Настройки данных", "Аккаунт");
        settingApp.setItems(itemsS);

        /*Инициализаия компонентов добавления работников*/
        try {
            listPositions = Factory.getInstance().getPositionDAO().getAllPositions();
            listPositionsString = new ArrayList<>();
            for (Position p : listPositions) {
                System.out.println(p.getName());
                listPositionsString.add(p.getName());
            }
            posWorker.setItems(FXCollections.observableArrayList(listPositionsString));
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Инициализаия компонентов ред.-уд. должностей*/
        try {
            listPositions = Factory.getInstance().getPositionDAO().getAllPositions();
            listPositionsString = new ArrayList<>();
            for (Position p : listPositions) {
                listPositionsString.add(p.getName());
            }
            comboPos.setItems(FXCollections.observableArrayList(listPositionsString));
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*Редактирование должности через кнопку*/
    public void BtnUpdatePosition() throws SQLException {

        if (comboPos.getValue() != null) {
            comboPos.setStyle("");
            if (textUpdatePos.getText().length() > 4) {
                int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите изменить эту запись?", "Редактирование", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    textUpdatePos.setStyle("");
                    errorUpdatePos.setText("");
                    String name = comboPos.getValue().toString();
                    String reName = textUpdatePos.getText();
                    System.out.println(name);
                    listPosition.clear();
                    listPositionsString.clear();
                    listPosition.addAll(Factory.getInstance().getPositionDAO().getAllPositions());
                    for (Position p : listPosition) {
                        listPositionsString.add(p.getName());
                    }
                    int number = listPositionsString.indexOf(name);
                    System.out.println(number);
                    Position getPos = listPosition.get(number);
                    System.out.println(getPos.getName());
                    getPos.setName(reName);
                    System.out.println(getPos.getName());
                    Factory.getInstance().getPositionDAO().updatePosition(getPos);
                    listPosition.clear();
                    listPositionsString.clear();
                    listPosition.addAll(Factory.getInstance().getPositionDAO().getAllPositions());
                    for (Position p : listPosition) {
                        listPositionsString.add(p.getName());
                    }
                    textUpdatePos.clear();
                    comboPos.setItems(FXCollections.observableArrayList(listPositionsString));
                    tablePosition.setItems(listPosition);
                }
            } else {
                textUpdatePos.setStyle("-fx-border-color: red;");
                errorUpdatePos.setText("Некорректное название");
            }
        } else {
            comboPos.setStyle("-fx-border-color: red;");

        }

    }

    /*Удаление должности через кнопку*/
    public void BtnDeletePosition() throws SQLException {

        if (comboPos.getValue() != null) {
            int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить эту запись?", "Удаление", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                listPosition.clear();
                listPositionsString.clear();
                listPosition.addAll(Factory.getInstance().getPositionDAO().getAllPositions());
                for (Position p : listPosition) {
                    listPositionsString.add(p.getName());
                }
                String name = comboPos.getValue().toString();
                int number = listPositionsString.indexOf(name);
                System.out.println(number);
                Position getPos = listPosition.get(number);
                System.out.println(getPos.getName());
                Factory.getInstance().getPositionDAO().deletePosition(getPos);
                listPosition.clear();
                listPositionsString.clear();
                listPosition.addAll(Factory.getInstance().getPositionDAO().getAllPositions());
                for (Position p : listPosition) {
                    listPositionsString.add(p.getName());
                }
                comboPos.setItems(FXCollections.observableArrayList(listPositionsString));
                tablePosition.setItems(listPosition);
            }
        } else {
            comboPos.setStyle("-fx-border-color: red;");
        }

    }

    /*Добавление должности через кнопку*/
    public void BtnAddPos() throws SQLException {
        textAddNamePos.setStyle("");
        errorAddPos.setText("");
        if (textAddNamePos.getText().length() > 4) {
            position.setName(textAddNamePos.getText().trim());
            List<String> listPositionsString = new ArrayList<>();
            //Создание листа названий должностей
            for (Position p : listPosition) {
                listPositionsString.add(p.getName());
            }
            boolean addOrNot = true;
            //Поиск одинаковых записей
            for (Position p : listPosition) {
                if (p.getName().equals(textAddNamePos.getText())) {
                    addOrNot = false;
                }
            }
            if (addOrNot == false) {
                textAddNamePos.setStyle("-fx-border-color: green;");
                errorAddPos.setText("Запись уже существует");
            } else {
                Factory.getInstance().getPositionDAO().addPosition(position);
                listPosition.add(position);
                listPositionsString.add(position.getName());
                textAddNamePos.clear();
                comboPos.setItems(FXCollections.observableArrayList(listPositionsString));
                tablePosition.setItems(listPosition);
            }
        } else {
            textAddNamePos.setStyle("-fx-border-color: red;");
            errorAddPos.setText("Введите корректную должность");
        }
        boolean addOrNot = true;
    }

    public void BtnAddWorker() throws SQLException {
        Worker w1 = new Worker();
        w1.setName("Black Black");
        w1.setAge(11l);
        Factory.getInstance().getWorkerDAO().addWorker(w1);
        List<Worker> workers = Factory.getInstance().getWorkerDAO().getAllWorkers();
        for (Worker w : workers) {
            System.out.println("Name of workers : "
                    + w.getName() + ", age : "
                    + w.getAge() + ",  id : "
                    + w.getId());
            System.out.println("=============================");
        }
    }

}
