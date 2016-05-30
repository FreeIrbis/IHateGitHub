package com.quasar.hibernateh2.controller;

import static com.quasar.hibernateh2.app.OneCheckBox.ChekedOneCheckBox;
import static com.quasar.hibernateh2.app.OneCheckBox.SelectOneCheckBox;
import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.Benefit;
import com.quasar.hibernateh2.dao.entity.Branch;
import com.quasar.hibernateh2.dao.entity.Department;
import com.quasar.hibernateh2.dao.entity.Gender;
import com.quasar.hibernateh2.dao.entity.Groups;
import com.quasar.hibernateh2.dao.entity.Position;
import com.quasar.hibernateh2.dao.entity.Worker;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
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

    boolean addOrNot = true;
    /*Все табы*/

    @FXML
    public Tab tabPos;
    @FXML
    public Tab tabGroup;
    @FXML
    public Tab tabDepartment;
    @FXML
    public Tab tabBranch;
    @FXML
    public Tab tabBenefit;
    @FXML
    public Tab tabWorker;


    /*Поля сотрудники на добавление*/
    @FXML
    public TextField textAddSurWorker;
    @FXML
    public TextField textAddNameWorker;
    @FXML
    public TextField textAddPatWorker;
    @FXML
    public DatePicker dataAddWorker;
    @FXML
    public CheckBox checkAddGenderMan;
    @FXML
    public CheckBox checkAddGenderWoman;
    @FXML
    public ComboBox depAddWorker;
    @FXML
    public ComboBox posAddWorker;
    @FXML
    public ComboBox benAddWorker;
    @FXML
    public Button btnAddWorker;
    @FXML
    public TableView tableWorker;
    @FXML
    public Label errorAddWorker;

    @FXML
    public TableColumn<Worker, String> SurWorkerColumn;
    @FXML
    public TableColumn<Worker, String> NameWorkerColumn;
    @FXML
    public TableColumn<Worker, String> PatWorkerColumn;
    @FXML
    public TableColumn<Worker, String> DateWorkerColumn;
    @FXML
    public TableColumn<Worker, String> PosWorkerColumn;
    @FXML
    public TableColumn<Worker, String> DepWorkerColumn;
    @FXML
    public TableColumn<Worker, String> BenWorkerColumn;
    @FXML
    public TableColumn<Worker, String> GenderWorkerColumn;

    /*Поля сотрудники на редактирование*/
    @FXML
    public TextField textUpdateSurWorker;
    @FXML
    public TextField textUpdateNameWorker;
    @FXML
    public TextField textUpdatePatWorker;
    @FXML
    public DatePicker dataUpdateWorker;
    @FXML
    public CheckBox checkUpdateGenderMan;
    @FXML
    public CheckBox checkUpdateGenderWoman;
    @FXML
    public ComboBox depUpdateWorker;
    @FXML
    public ComboBox posUpdateWorker;
    @FXML
    public ComboBox benUpdateWorker;
    @FXML
    public Button btnUpdateWorker;

    Worker worker = new Worker();
    private ObservableList<Worker> listWorker = FXCollections.observableArrayList();

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

    /*Поля групп на добавление*/
    private ObservableList<Groups> listGroup = FXCollections.observableArrayList();
    @FXML
    Label errorAddGroup;
    @FXML
    Label errorUpdateGroup;

    Groups group = new Groups();
    @FXML
    public TextField textAddNameGroup;
    @FXML
    public TextField textUpdateNameGroup;
    @FXML
    public Button btnAddGroup;
    @FXML
    public ComboBox comboGroup;
    @FXML
    public TableView<Groups> tableGroup;
    @FXML
    public TableColumn<Groups, String> NameGroupColumn;
    @FXML
    public Button btnUpdateGroup;
    @FXML
    public Button btnDeleteGroup;

    List<Groups> listGroups = null;
    List<String> listGroupsString = null;

    /*Поля отделений на добавление*/
    private ObservableList<Department> listDepartment = FXCollections.observableArrayList();
    @FXML
    Label errorAddDepartment;
    @FXML
    Label errorUpdateDepartment;

    Department department = new Department();
    @FXML
    public TextField textAddNameDepartment;
    @FXML
    public TextField textUpdateNameDepartment;
    @FXML
    public Button btnAddDepartment;
    @FXML
    public ComboBox comboDepartment;
    @FXML
    public TableView<Department> tableDepartment;
    @FXML
    public TableColumn<Department, String> NameDepartmentColumn;
    @FXML
    public Button btnUpdateDepartment;
    @FXML
    public Button btnDeleteDepartment;

    List<Department> listDepartments = null;
    List<String> listDepartmentsString = null;

    /*Поля Отделов на добавление*/
    private ObservableList<Branch> listBranch = FXCollections.observableArrayList();
    @FXML
    Label errorAddBranch;
    @FXML
    Label errorUpdateBranch;

    Branch branch = new Branch();
    @FXML
    public TextField textAddNameBranch;
    @FXML
    public TextField textUpdateNameBranch;
    @FXML
    public Button btnAddBranch;
    @FXML
    public ComboBox comboBranch;
    @FXML
    public TableView<Branch> tableBranch;
    @FXML
    public TableColumn<Branch, String> NameBranchColumn;
    @FXML
    public Button btnUpdateBranch;
    @FXML
    public Button btnDeleteBranch;

    List<Branch> listBranchs = null;
    List<String> listBranchsString = null;

    /*Поля Льгот на добавление*/
    private ObservableList<Benefit> listBenefit = FXCollections.observableArrayList();
    @FXML
    Label errorAddBenefit;
    @FXML
    Label errorUpdateBenefit;

    Benefit benefit = new Benefit();
    @FXML
    public TextField textAddNameBenefit;
    @FXML
    public TextField textUpdateNameBenefit;
    @FXML
    public Button btnAddBenefit;
    @FXML
    public ComboBox comboBenefit;
    @FXML
    public TableView<Benefit> tableBenefit;
    @FXML
    public TableColumn<Benefit, String> NameBenefitColumn;
    @FXML
    public Button btnUpdateBenefit;
    @FXML
    public Button btnDeleteBenefit;

    List<Benefit> listBenefits = null;
    List<String> listBenefitsString = null;

    @FXML
    private void CheckAddGenderWorkers(ActionEvent e) {
        ChekedOneCheckBox(checkAddGenderMan, checkAddGenderWoman);
    }

    @FXML
    private void CheckUpdateGenderWorkers(ActionEvent e) {
        ChekedOneCheckBox(checkUpdateGenderMan, checkUpdateGenderWoman);
    }

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

        //Группы
        NameGroupColumn.setCellValueFactory(new PropertyValueFactory<Groups, String>("name"));
        tabGroup.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableGroup.getItems().clear();
                try {
                    listGroup.addAll(Factory.getInstance().getGroupDAO().getAllGroups());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableGroup.setItems(listGroup);
            }
        });

        //Отделения
        NameDepartmentColumn.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
        tabDepartment.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableDepartment.getItems().clear();
                try {
                    listDepartment.addAll(Factory.getInstance().getDepartmentDAO().getAllDepartments());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableDepartment.setItems(listDepartment);
            }
        });

        //Отделы
        NameBranchColumn.setCellValueFactory(new PropertyValueFactory<Branch, String>("name"));
        tabBranch.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableBranch.getItems().clear();
                try {
                    listBranch.addAll(Factory.getInstance().getBranchDAO().getAllBranchs());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableBranch.setItems(listBranch);
            }
        });

        //Отделы
        NameBenefitColumn.setCellValueFactory(new PropertyValueFactory<Benefit, String>("name"));
        tabBenefit.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableBenefit.getItems().clear();
                try {
                    listBenefit.addAll(Factory.getInstance().getBenefitDAO().getAllBenefits());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableBenefit.setItems(listBenefit);
            }
        });

        //Работники
        SurWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("surname"));
        NameWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("name"));
        PatWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("patronymic"));
        DateWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("birthday"));
        PosWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("id_position"));
        DepWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("id_department"));
        BenWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("id_benefit"));
        GenderWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("id_gender"));
        tabWorker.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                try {
                    listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    listPositions = Factory.getInstance().getPositionDAO().getAllPositions();
                    listPositionsString = new ArrayList<>();
                    for (Position p : listPositions) {
                        System.out.println(p.getName());
                        listPositionsString.add(p.getName());
                    }
                    listDepartments = Factory.getInstance().getDepartmentDAO().getAllDepartments();
                    listDepartmentsString = new ArrayList<>();
                    for (Department p : listDepartments) {
                        System.out.println(p.getName());
                        listDepartmentsString.add(p.getName());
                    }
                    listBenefits = Factory.getInstance().getBenefitDAO().getAllBenefits();
                    listBenefitsString = new ArrayList<>();
                    for (Benefit p : listBenefits) {
                        System.out.println(p.getName());
                        listBenefitsString.add(p.getName());
                    }
                    tableWorker.setItems(listWorker);
                    benAddWorker.setItems(FXCollections.observableArrayList(listBenefitsString));
                    posAddWorker.setItems(FXCollections.observableArrayList(listPositionsString));
                    depAddWorker.setItems(FXCollections.observableArrayList(listDepartmentsString));
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        try {
            /*Инициализаия компонентов добавления работников*/
            listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
            tableWorker.setItems(listWorker);
            System.out.println(listWorker.toArray().toString());
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            listPositions = Factory.getInstance().getPositionDAO().getAllPositions();
            listPositionsString = new ArrayList<>();
            for (Position p : listPositions) {
                System.out.println(p.getName());
                listPositionsString.add(p.getName());
            }
            listDepartments = Factory.getInstance().getDepartmentDAO().getAllDepartments();
            listDepartmentsString = new ArrayList<>();
            for (Department p : listDepartments) {
                System.out.println(p.getName());
                listDepartmentsString.add(p.getName());
            }
            listBenefits = Factory.getInstance().getBenefitDAO().getAllBenefits();
            listBenefitsString = new ArrayList<>();
            for (Benefit p : listBenefits) {
                System.out.println(p.getName());
                listBenefitsString.add(p.getName());
            }
            benAddWorker.setItems(FXCollections.observableArrayList(listBenefitsString));
            posAddWorker.setItems(FXCollections.observableArrayList(listPositionsString));
            depAddWorker.setItems(FXCollections.observableArrayList(listDepartmentsString));
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

        /*Инициализаия компонентов ред.-уд. групп*/
        try {
            listGroups = Factory.getInstance().getGroupDAO().getAllGroups();
            listGroupsString = new ArrayList<>();
            for (Groups p : listGroups) {
                listGroupsString.add(p.getName());
            }
            comboGroup.setItems(FXCollections.observableArrayList(listGroupsString));
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Инициализаия компонентов ред.-уд. отделений*/
        try {
            listDepartments = Factory.getInstance().getDepartmentDAO().getAllDepartments();
            listDepartmentsString = new ArrayList<>();
            for (Department p : listDepartments) {
                listDepartmentsString.add(p.getName());
            }
            comboDepartment.setItems(FXCollections.observableArrayList(listDepartmentsString));
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Инициализаия компонентов ред.-уд. отделов*/
        try {
            listBranchs = Factory.getInstance().getBranchDAO().getAllBranchs();
            listBranchsString = new ArrayList<>();
            for (Branch p : listBranchs) {
                listBranchsString.add(p.getName());
            }
            comboBranch.setItems(FXCollections.observableArrayList(listBranchsString));
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Инициализаия компонентов ред.-уд. льгот*/
        try {
            listBenefits = Factory.getInstance().getBenefitDAO().getAllBenefits();
            listBenefitsString = new ArrayList<>();
            for (Benefit p : listBenefits) {
                listBenefitsString.add(p.getName());
            }
            comboBenefit.setItems(FXCollections.observableArrayList(listBenefitsString));
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
                position.setName(textAddNamePos.getText().trim());
                Factory.getInstance().getPositionDAO().addPosition(position);
                listPosition.clear();
                listPosition.addAll(Factory.getInstance().getPositionDAO().getAllPositions());
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

    /*Изменение должности через кнопку*/
    public void BtnUpdateGroup() throws SQLException {

        if (comboGroup.getValue() != null) {
            comboPos.setStyle("");
            if (textUpdateNameGroup.getText().length() > 4) {
                int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите изменить эту запись?", "Редактирование", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    textUpdateNameGroup.setStyle("");
                    errorUpdateGroup.setText("");
                    String name = comboGroup.getValue().toString();
                    String reName = textUpdateNameGroup.getText();
                    System.out.println(name);
                    listGroup.clear();
                    listGroupsString.clear();
                    listGroup.addAll(Factory.getInstance().getGroupDAO().getAllGroups());
                    for (Groups p : listGroup) {
                        listGroupsString.add(p.getName());
                    }
                    int number = listGroupsString.indexOf(name);
                    System.out.println(number);
                    Groups getGroup = listGroup.get(number);
                    System.out.println(getGroup.getName());
                    getGroup.setName(reName);
                    System.out.println(getGroup.getName());
                    Factory.getInstance().getGroupDAO().updateGroups(getGroup);
                    listGroup.clear();
                    listGroupsString.clear();
                    listGroup.addAll(Factory.getInstance().getGroupDAO().getAllGroups());
                    for (Groups p : listGroup) {
                        listGroupsString.add(p.getName());
                    }
                    textUpdateNameGroup.clear();
                    comboGroup.setItems(FXCollections.observableArrayList(listGroupsString));
                    tableGroup.setItems(listGroup);
                }
            } else {
                textUpdateNameGroup.setStyle("-fx-border-color: red;");
                errorUpdateGroup.setText("Некорректное название");
            }
        } else {
            comboGroup.setStyle("-fx-border-color: red;");

        }

    }

    /*Удаление должности через кнопку*/
    public void BtnDeleteGroup() throws SQLException {

        if (comboGroup.getValue() != null) {
            int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить эту запись?", "Удаление", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                listGroup.clear();
                listGroupsString.clear();
                listGroup.addAll(Factory.getInstance().getGroupDAO().getAllGroups());
                for (Groups p : listGroup) {
                    listGroupsString.add(p.getName());
                }
                String name = comboGroup.getValue().toString();
                int number = listGroupsString.indexOf(name);
                System.out.println(number);
                Groups getGroup = listGroup.get(number);
                System.out.println(getGroup.getName());
                Factory.getInstance().getGroupDAO().deleteGroups(getGroup);
                listGroup.clear();
                listGroupsString.clear();
                listGroup.addAll(Factory.getInstance().getGroupDAO().getAllGroups());
                for (Groups p : listGroup) {
                    listGroupsString.add(p.getName());
                }
                comboGroup.setItems(FXCollections.observableArrayList(listGroupsString));
                tableGroup.setItems(listGroup);
            }
        } else {
            comboGroup.setStyle("-fx-border-color: red;");
        }

    }

    /*Добавление должности через кнопку*/
    public void BtnAddGroup() throws SQLException {
        textAddNameGroup.setStyle("");
        errorAddGroup.setText("");
        if (textAddNameGroup.getText().trim().length() > 4) {
            List<String> listGroupsString = new ArrayList<>();
            //Создание листа названий должностей
            for (Groups p : listGroup) {
                listGroupsString.add(p.getName());
                System.out.println(p.getName());
            }
            //Поиск одинаковых записей
            for (Groups p : listGroup) {
                if (p.getName().equals(textAddNameGroup.getText())) {
                    addOrNot = false;
                }
            }
            if (addOrNot == false) {
                textAddNameGroup.setStyle("-fx-border-color: green;");
                errorAddGroup.setText("Запись уже существует");
            } else {
                group.setName(textAddNameGroup.getText().trim());
                Factory.getInstance().getGroupDAO().addGroups(group);
                listGroup.clear();
                listGroup.addAll(Factory.getInstance().getGroupDAO().getAllGroups());
                listGroupsString.add(group.getName());
                textAddNameGroup.clear();
                comboGroup.setItems(FXCollections.observableArrayList(listGroupsString));
                for (Groups p : listGroup) {
                    System.out.println(p.getName());
                }
                tableGroup.setItems(listGroup);

            }
            addOrNot = true;
        } else {
            textAddNameGroup.setStyle("-fx-border-color: red;");
            errorAddGroup.setText("Введите корректную должность");
        }
        addOrNot = true;
    }

    /*Изменение Отделения через кнопку*/
    public void BtnUpdateDepartment() throws SQLException {

        if (comboDepartment.getValue() != null) {
            comboDepartment.setStyle("");
            if (textUpdateNameDepartment.getText().length() > 4) {
                int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите изменить эту запись?", "Редактирование", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    textUpdateNameDepartment.setStyle("");
                    errorUpdateDepartment.setText("");
                    String name = comboDepartment.getValue().toString();
                    String reName = textUpdateNameDepartment.getText();
                    System.out.println(name);
                    listDepartment.clear();
                    listDepartmentsString.clear();
                    listDepartment.addAll(Factory.getInstance().getDepartmentDAO().getAllDepartments());
                    for (Department p : listDepartment) {
                        listDepartmentsString.add(p.getName());
                    }
                    int number = listDepartmentsString.indexOf(name);
                    System.out.println(number);
                    Department getDepartment = listDepartment.get(number);
                    System.out.println(getDepartment.getName());
                    getDepartment.setName(reName);
                    System.out.println(getDepartment.getName());
                    Factory.getInstance().getDepartmentDAO().updateDepartment(getDepartment);
                    listDepartment.clear();
                    listDepartmentsString.clear();
                    listDepartment.addAll(Factory.getInstance().getDepartmentDAO().getAllDepartments());
                    for (Department p : listDepartment) {
                        listDepartmentsString.add(p.getName());
                    }
                    textUpdateNameDepartment.clear();
                    comboDepartment.setItems(FXCollections.observableArrayList(listDepartmentsString));
                    tableDepartment.setItems(listDepartment);
                }
            } else {
                textUpdateNameDepartment.setStyle("-fx-border-color: red;");
                errorUpdateDepartment.setText("Некорректное название");
            }
        } else {
            comboDepartment.setStyle("-fx-border-color: red;");

        }

    }

    /*Удаление Отделения через кнопку*/
    public void BtnDeleteDepartment() throws SQLException {

        if (comboDepartment.getValue() != null) {
            int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить эту запись?", "Удаление", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                listDepartment.clear();
                listDepartmentsString.clear();
                listDepartment.addAll(Factory.getInstance().getDepartmentDAO().getAllDepartments());
                for (Department p : listDepartment) {
                    listDepartmentsString.add(p.getName());
                }
                String name = comboDepartment.getValue().toString();
                int number = listDepartmentsString.indexOf(name);
                System.out.println(number);
                Department getDepartment = listDepartment.get(number);
                System.out.println(getDepartment.getName());
                Factory.getInstance().getDepartmentDAO().deleteDepartment(getDepartment);
                listDepartment.clear();
                listDepartmentsString.clear();
                listDepartment.addAll(Factory.getInstance().getDepartmentDAO().getAllDepartments());
                for (Department p : listDepartment) {
                    listDepartmentsString.add(p.getName());
                }
                comboDepartment.setItems(FXCollections.observableArrayList(listDepartmentsString));
                tableDepartment.setItems(listDepartment);
            }
        } else {
            comboDepartment.setStyle("-fx-border-color: red;");
        }

    }

    /*Добавление Отделения через кнопку*/
    public void BtnAddDepartment() throws SQLException {
        textAddNameDepartment.setStyle("");
        errorAddDepartment.setText("");
        if (textAddNameDepartment.getText().trim().length() > 4) {
            List<String> listDepartmentsString = new ArrayList<>();
            //Создание листа названий должностей
            for (Department p : listDepartment) {
                listDepartmentsString.add(p.getName());
            }
            //Поиск одинаковых записей
            for (Department p : listDepartment) {
                if (p.getName().equals(textAddNameDepartment.getText().trim())) {
                    addOrNot = false;
                }
            }
            if (addOrNot == false) {
                textAddNameDepartment.setStyle("-fx-border-color: green;");
                errorAddDepartment.setText("Запись уже существует");
            } else {
                department.setName(textAddNameDepartment.getText().trim());
                Factory.getInstance().getDepartmentDAO().addDepartment(department);
                listDepartment.clear();
                listDepartment.addAll(Factory.getInstance().getDepartmentDAO().getAllDepartments());
                listDepartmentsString.add(department.getName());
                textAddNameDepartment.clear();
                comboDepartment.setItems(FXCollections.observableArrayList(listDepartmentsString));
                tableDepartment.setItems(listDepartment);
            }
            addOrNot = true;
        } else {
            textAddNameDepartment.setStyle("-fx-border-color: red;");
            errorAddDepartment.setText("Введите корректное отделение");
        }
        addOrNot = true;
    }

    /*Изменение Отделения через кнопку*/
    public void BtnUpdateBranch() throws SQLException {

        if (comboBranch.getValue() != null) {
            comboBranch.setStyle("");
            if (textUpdateNameBranch.getText().length() > 4) {
                int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите изменить эту запись?", "Редактирование", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    textUpdateNameBranch.setStyle("");
                    errorUpdateBranch.setText("");
                    String name = comboBranch.getValue().toString();
                    String reName = textUpdateNameBranch.getText();
                    System.out.println(name);
                    listBranch.clear();
                    listBranchsString.clear();
                    listBranch.addAll(Factory.getInstance().getBranchDAO().getAllBranchs());
                    for (Branch p : listBranch) {
                        listBranchsString.add(p.getName());
                    }
                    int number = listBranchsString.indexOf(name);
                    System.out.println(number);
                    Branch getBranch = listBranch.get(number);
                    System.out.println(getBranch.getName());
                    getBranch.setName(reName);
                    System.out.println(getBranch.getName());
                    Factory.getInstance().getBranchDAO().updateBranch(getBranch);
                    listBranch.clear();
                    listBranchsString.clear();
                    listBranch.addAll(Factory.getInstance().getBranchDAO().getAllBranchs());
                    for (Branch p : listBranch) {
                        listBranchsString.add(p.getName());
                    }
                    textUpdateNameBranch.clear();
                    comboBranch.setItems(FXCollections.observableArrayList(listBranchsString));
                    tableBranch.setItems(listBranch);
                }
            } else {
                textUpdateNameBranch.setStyle("-fx-border-color: red;");
                errorUpdateBranch.setText("Некорректное название");
            }
        } else {
            comboDepartment.setStyle("-fx-border-color: red;");

        }

    }

    /*Удаление Отделения через кнопку*/
    public void BtnDeleteBranch() throws SQLException {

        if (comboBranch.getValue() != null) {
            int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить эту запись?", "Удаление", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                listBranch.clear();
                listBranchsString.clear();
                listBranch.addAll(Factory.getInstance().getBranchDAO().getAllBranchs());
                for (Branch p : listBranch) {
                    listBranchsString.add(p.getName());
                }
                String name = comboBranch.getValue().toString();
                int number = listBranchsString.indexOf(name);
                System.out.println(number);
                Branch getBranch = listBranch.get(number);
                System.out.println(getBranch.getName());
                Factory.getInstance().getBranchDAO().deleteBranch(getBranch);
                listBranch.clear();
                listBranchsString.clear();
                listBranch.addAll(Factory.getInstance().getBranchDAO().getAllBranchs());
                for (Branch p : listBranch) {
                    listBranchsString.add(p.getName());
                }
                comboBranch.setItems(FXCollections.observableArrayList(listBranchsString));
                tableBranch.setItems(listBranch);
            }
        } else {
            comboBranch.setStyle("-fx-border-color: red;");
        }

    }

    /*Добавление Отделения через кнопку*/
    public void BtnAddBranch() throws SQLException {
        textAddNameBranch.setStyle("");
        errorAddBranch.setText("");
        if (textAddNameBranch.getText().trim().length() > 4) {
            List<String> listBranchsString = new ArrayList<>();
            //Создание листа названий должностей
            for (Branch p : listBranch) {
                listBranchsString.add(p.getName());
            }
            //Поиск одинаковых записей
            for (Branch p : listBranch) {
                if (p.getName().equals(textAddNameBranch.getText().trim())) {
                    addOrNot = false;
                }
            }

            if (addOrNot == false) {
                textAddNameBranch.setStyle("-fx-border-color: green;");
                errorAddBranch.setText("Запись уже существует");
            } else {
                branch.setName(textAddNameBranch.getText().trim());
                Factory.getInstance().getBranchDAO().addBranch(branch);
                listBranch.add(branch);
                listBranchsString.add(branch.getName());
                listBranch.clear();
                textAddNameBranch.clear();
                listBranch.addAll(Factory.getInstance().getBranchDAO().getAllBranchs());
                comboBranch.setItems(FXCollections.observableArrayList(listBranchsString));
                tableBranch.setItems(listBranch);
            }
            addOrNot = true;
        } else {
            textAddNameDepartment.setStyle("-fx-border-color: red;");
            errorAddDepartment.setText("Введите корректное отделение");
        }
        addOrNot = true;
    }

    /*Изменение Отделения через кнопку*/
    public void BtnUpdateBenefit() throws SQLException {

        if (comboBenefit.getValue() != null) {
            comboBenefit.setStyle("");
            if (textUpdateNameBenefit.getText().length() > 4) {
                int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите изменить эту запись?", "Редактирование", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    textUpdateNameBenefit.setStyle("");
                    errorUpdateBenefit.setText("");
                    String name = comboBenefit.getValue().toString();
                    String reName = textUpdateNameBenefit.getText();
                    System.out.println(name);
                    listBenefit.clear();
                    listBenefitsString.clear();
                    listBenefit.addAll(Factory.getInstance().getBenefitDAO().getAllBenefits());
                    for (Benefit p : listBenefit) {
                        listBenefitsString.add(p.getName());
                    }
                    int number = listBenefitsString.indexOf(name);
                    System.out.println(number);
                    Benefit getBenefit = listBenefit.get(number);
                    System.out.println(getBenefit.getName());
                    getBenefit.setName(reName);
                    System.out.println(getBenefit.getName());
                    Factory.getInstance().getBenefitDAO().updateBenefit(getBenefit);
                    listBenefit.clear();
                    listBenefitsString.clear();
                    listBenefit.addAll(Factory.getInstance().getBenefitDAO().getAllBenefits());
                    for (Benefit p : listBenefit) {
                        listBenefitsString.add(p.getName());
                    }
                    textUpdateNameBenefit.clear();
                    comboBenefit.setItems(FXCollections.observableArrayList(listBenefitsString));
                    tableBenefit.setItems(listBenefit);
                }
            } else {
                textUpdateNameBenefit.setStyle("-fx-border-color: red;");
                errorUpdateBenefit.setText("Некорректное название");
            }
        } else {
            comboBenefit.setStyle("-fx-border-color: red;");

        }

    }

    /*Удаление Отделения через кнопку*/
    public void BtnDeleteBenefit() throws SQLException {

        if (comboBenefit.getValue() != null) {
            int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить эту запись?", "Удаление", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                listBenefit.clear();
                listBenefitsString.clear();
                listBenefit.addAll(Factory.getInstance().getBenefitDAO().getAllBenefits());
                for (Benefit p : listBenefit) {
                    listBenefitsString.add(p.getName());
                }
                String name = comboBenefit.getValue().toString();
                int number = listBenefitsString.indexOf(name);
                System.out.println(number);
                Benefit getBenefit = listBenefit.get(number);
                System.out.println(getBenefit.getName());
                Factory.getInstance().getBenefitDAO().deleteBenefit(getBenefit);
                listBenefit.clear();
                listBenefitsString.clear();
                listBenefit.addAll(Factory.getInstance().getBenefitDAO().getAllBenefits());
                for (Benefit p : listBenefit) {
                    listBenefitsString.add(p.getName());
                }
                comboBenefit.setItems(FXCollections.observableArrayList(listBenefitsString));
                tableBenefit.setItems(listBenefit);
            }
        } else {
            comboBenefit.setStyle("-fx-border-color: red;");
        }

    }

    /*Добавление Отделения через кнопку*/
    public void BtnAddBenefit() throws SQLException {
        textAddNameBenefit.setStyle("");
        errorAddBenefit.setText("");
        if (textAddNameBenefit.getText().trim().length() > 4) {
            List<String> listBenefitsString = new ArrayList<>();
            //Создание листа названий должностей
            for (Benefit p : listBenefit) {
                listBenefitsString.add(p.getName());
            }
            //Поиск одинаковых записей
            for (Benefit p : listBenefit) {
                if (p.getName().equals(textAddNameBenefit.getText().trim())) {
                    addOrNot = false;
                }
            }
            if (addOrNot == false) {
                textAddNameBenefit.setStyle("-fx-border-color: green;");
                errorAddBenefit.setText("Запись уже существует");
            } else {
                benefit.setName(textAddNameBenefit.getText().trim());
                Factory.getInstance().getBenefitDAO().addBenefit(benefit);
                listBenefit.clear();
                listBenefit.addAll(Factory.getInstance().getBenefitDAO().getAllBenefits());
                listBenefitsString.add(benefit.getName());
                textAddNameBenefit.clear();
                comboBenefit.setItems(FXCollections.observableArrayList(listBenefitsString));
                tableBenefit.setItems(listBenefit);
            }
            addOrNot = true;
        } else {
            textAddNameBenefit.setStyle("-fx-border-color: red;");
            errorAddBenefit.setText("Введите корректное отделение");
        }
        addOrNot = true;

    }

    public int BtnSearchWorker() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableWorker.getSelectionModel();
        int number = selectionModel.getFocusedIndex();
        worker = listWorker.get(selectionModel.getFocusedIndex());
        textUpdateSurWorker.setText(worker.getSurname());
        textUpdateNameWorker.setText(worker.getName());
        textUpdatePatWorker.setText(worker.getPatronymic());
        //dataAddWorker.setValue(worker.getBirthday());
        depAddWorker.setValue(worker.getDepartment());
        posAddWorker.setValue(worker.getPosition());
        benAddWorker.setValue(worker.getBenefit());
        if (worker.getGender().getId() == 1L) {
            checkUpdateGenderMan.setSelected(true);
        } else {
            checkUpdateGenderWoman.setSelected(true);
        }
        return number;
    }

    public void SelectRowTableWorker() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableWorker.getSelectionModel();
        int number = selectionModel.getFocusedIndex();
        worker = listWorker.get(selectionModel.getFocusedIndex());
        textUpdateSurWorker.setText(worker.getSurname());
        textUpdateNameWorker.setText(worker.getName());
        textUpdatePatWorker.setText(worker.getPatronymic());
        LocalDate date = LocalDate.parse(worker.getBirthday().toString());
        dataUpdateWorker.setValue(date);
        depUpdateWorker.setValue(worker.getDepartment().getName());
        posUpdateWorker.setValue(worker.getPosition().getName());
        benUpdateWorker.setValue(worker.getBenefit().getName());
        checkUpdateGenderMan.setSelected(false);
        checkUpdateGenderWoman.setSelected(false);
        if (worker.getGender().getId() == 1L) {
            checkUpdateGenderMan.setSelected(true);
        } else {
            checkUpdateGenderWoman.setSelected(true);
        }
    }

    public void BtnUpdateWorker() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableWorker.getSelectionModel();
        worker = listWorker.get(selectionModel.getFocusedIndex());
        if (textUpdateSurWorker.getText().length() > 1) {
            worker.setSurname(textUpdateSurWorker.getText());
        }
        if (textUpdateNameWorker.getText().length() > 1) {
            worker.setSurname(textUpdateNameWorker.getText());
        }
        if (textUpdatePatWorker.getText().length() > 4) {
            worker.setSurname(textUpdatePatWorker.getText());
        }

    }

    public void BtnDeleteWorker(int number) throws SQLException {
        worker = listWorker.get(number);
        Factory.getInstance().getWorkerDAO().deleteWorker(worker);
        listWorker.clear();
        listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
        tableWorker.setItems(listWorker);
    }

    public void BtnDeleteWorker() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableWorker.getSelectionModel();
        worker = listWorker.get(selectionModel.getFocusedIndex());
        Factory.getInstance().getWorkerDAO().deleteWorker(worker);
        listWorker.clear();
        listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
        tableWorker.setItems(listWorker);
    }

    public void BtnAddWorker() throws SQLException {
        if (textAddSurWorker.getText().length() > 4
                && textAddNameWorker.getText().length() > 4
                && textAddPatWorker.getText().length() > 4
                && dataAddWorker.getValue().toString().length() > 4
                && depAddWorker.getValue() != null
                && posAddWorker.getValue() != null
                && benAddWorker.getValue() != null) {
            worker.setSurname(textAddSurWorker.getText());
            worker.setName(textAddNameWorker.getText());
            worker.setPatronymic(textAddPatWorker.getText());
            Gender gender = new Gender();
            gender = Factory.getInstance().getGenderDAO().getGenderById(SelectOneCheckBox(checkAddGenderMan, checkAddGenderWoman));
            worker.setGender(gender);
            worker.setBirthday(dataAddWorker.getValue().toString());
            int number = listDepartmentsString.indexOf(depAddWorker.getValue().toString());
            Department department = new Department();
            department = listDepartments.get(number);
            worker.setDepartment(department);
            number = listPositionsString.indexOf(posAddWorker.getValue().toString());
            position = listPositions.get(number);
            worker.setPosition(position);
            number = listBenefitsString.indexOf(benAddWorker.getValue().toString());
            Benefit benefit = new Benefit();
            benefit = listBenefits.get(number);
            worker.setBenefit(benefit);
            Factory.getInstance().getWorkerDAO().addWorker(worker);
            listWorker.clear();
            listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
            tableWorker.setItems(listWorker);
        } else {
            errorAddWorker.setText("Заполнены не все поля");
        }
    }

}
