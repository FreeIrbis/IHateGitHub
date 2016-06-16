package com.quasar.hibernateh2.controller;

import com.quasar.hibernateh2.app.MainApp;
import static com.quasar.hibernateh2.app.OneCheckBox.ChekedOneCheckBox;
import static com.quasar.hibernateh2.app.OneCheckBox.SelectOneCheckBox;
import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.Benefit;
import com.quasar.hibernateh2.dao.entity.Branch;
import com.quasar.hibernateh2.dao.entity.Child;
import com.quasar.hibernateh2.dao.entity.Department;
import com.quasar.hibernateh2.dao.entity.ExelModel;
import com.quasar.hibernateh2.dao.entity.Gender;
import com.quasar.hibernateh2.dao.entity.Groups;
import com.quasar.hibernateh2.dao.entity.Position;
import com.quasar.hibernateh2.dao.entity.Role;
import com.quasar.hibernateh2.dao.entity.Student;
import com.quasar.hibernateh2.dao.entity.Worker;
import com.quasar.hibernateh2.dao.entity.WorkersChild;
import com.quasar.hibernateh2.util.exel.ExelType;
import com.quasar.hibernateh2.util.exel.ExelWriter;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Menu;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    @FXML
    public Tab tabStudent;
    @FXML
    public Tab tabChild;


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
    public ComboBox<Department> depAddWorker;
    @FXML
    public ComboBox<Position> posAddWorker;
    @FXML
    public ComboBox<Branch> branchAddWorker;
    @FXML
    public ComboBox<Benefit> benAddWorker;
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
    public TableColumn<Worker, Long> DepWorkerColumn;
    @FXML
    public TableColumn<Worker, Long> BenWorkerColumn;
    @FXML
    public TableColumn<Worker, Long> BranchWorkerColumn;
    @FXML
    public TableColumn<Worker, Long> GenderWorkerColumn;

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
    public ComboBox<Branch> branchUpdateWorker;
    @FXML
    public ComboBox<Department> depUpdateWorker;
    @FXML
    public ComboBox<Position> posUpdateWorker;
    @FXML
    public ComboBox<Benefit> benUpdateWorker;
    @FXML
    public Button btnUpdateWorker;

    Worker worker = new Worker();
    private ObservableList<Worker> listWorker = FXCollections.observableArrayList();
    private ObservableList<Worker> listSearchWorker = FXCollections.observableArrayList();
    List<String> listWorkersString = null;

    /*Поля студентов на добавление*/
    @FXML
    public TextField textAddSurStudent;
    @FXML
    public TextField textAddNameStudent;
    @FXML
    public TextField textAddPatStudent;
    @FXML
    public DatePicker dataAddStudent;
    @FXML
    public CheckBox checkAddGenderManStudent;
    @FXML
    public CheckBox checkAddGenderWomanStudent;
    @FXML
    public TextField textAddPhoneStudent;
    @FXML
    public TextField textAddEmailStudent;
    @FXML
    public ComboBox<Groups> groupAddStudent;
    @FXML
    public ComboBox<Department> depAddStudent;
    @FXML
    public ComboBox<Role> roleAddStudent;
    @FXML
    public ComboBox<Benefit> benAddStudent;
    @FXML
    public Button btnAddStudent;
    @FXML
    public TableView tableStudent;
    @FXML
    public Label errorAddStudent;

    List<Role> listRoles = null;

    @FXML
    public TableColumn<Student, String> SurStudentColumn;
    @FXML
    public TableColumn<Student, Long> RoleStudentColumn;
    @FXML
    public TableColumn<Student, String> NameStudentColumn;
    @FXML
    public TableColumn<Student, String> PatStudentColumn;
    @FXML
    public TableColumn<Student, String> DateStudentColumn;
    @FXML
    public TableColumn<Student, Long> GroupStudentColumn;
    @FXML
    public TableColumn<Student, Long> DepStudentColumn;
    @FXML
    public TableColumn<Student, Long> BenStudentColumn;
    @FXML
    public TableColumn<Student, Long> GenderStudentColumn;
    @FXML
    public TableColumn<Student, String> PhoneStudentColumn;
    @FXML
    public TableColumn<Student, String> EmailStudentColumn;

    /*Поля детей на добавления*/
    @FXML
    public CheckBox checkAddGenderChildMan;
    @FXML
    public CheckBox checkAddGenderChildWoman;
    @FXML
    public TextField textAddSurChild;
    @FXML
    public TextField textAddNameChild;
    @FXML
    public TextField textAddPatChild;
    @FXML
    public TextField textAddSurWorkChild;
    @FXML
    public TextField textAddNameWorkChild;
    @FXML
    public TextField textAddPatWorkChild;
    @FXML
    public DatePicker dataAddChild;
    @FXML
    public Button btnAddChild;
    @FXML
    public TableView tableChild;

    Child child = new Child();
    WorkersChild workersChild = new WorkersChild();
    private ObservableList<Child> listChild = FXCollections.observableArrayList();
    private ObservableList<WorkersChild> listWorkersChild = FXCollections.observableArrayList();
    private ObservableList<WorkersChild> listSearchWorkersChild = FXCollections.observableArrayList();
    List<String> listWorkersChildString = null;

    @FXML
    public TableColumn<Child, String> SurChildColumn;
    @FXML
    public TableColumn<Child, String> NameChildColumn;
    @FXML
    public TableColumn<Child, String> PatChildColumn;
    @FXML
    public TableColumn<Child, Long> GenderChildColumn;
    @FXML
    public TableColumn<Child, String> DateChildColumn;
    @FXML
    public TableColumn<Worker, String> SurWorkChildColumn;
    @FXML
    public TableColumn<Worker, String> NameWorkChildColumn;
    @FXML
    public TableColumn<Worker, String> PatWorkChildColumn;

    /*Поля детей на редактирование*/
    @FXML
    public CheckBox checkUpdateGenderChildMan;
    @FXML
    public CheckBox checkUpdateGenderChildWoman;
    @FXML
    public TextField textUpdateSurChild;
    @FXML
    public TextField textUpdateNameChild;
    @FXML
    public TextField textUpdatePatChild;
    @FXML
    public TextField textUpdateSurWorkChild;
    @FXML
    public TextField textUpdateNameWorkChild;
    @FXML
    public TextField textUpdatePatWorkChild;
    @FXML
    public DatePicker dataUpdateChild;
    @FXML
    public Button btnUpdateChild;
    @FXML
    public Button btnSearchChild;
    @FXML
    public Button btnDeleteChild;

    /*Поля студентов на редактирование*/
    @FXML
    public TextField textUpdateSurStudent;
    @FXML
    public TextField textUpdateNameStudent;
    @FXML
    public TextField textUpdatePatStudent;
    @FXML
    public DatePicker dataUpdateStudent;
    @FXML
    public CheckBox checkUpdateGenderManStudent;
    @FXML
    public CheckBox checkUpdateGenderWomanStudent;
    @FXML
    public TextField textUpdatePhoneStudent;
    @FXML
    public TextField textUpdateEmailStudent;
    @FXML
    public ComboBox<Department> depUpdateStudent;
    @FXML
    public ComboBox<Role> roleUpdateStudent;
    @FXML
    public ComboBox<Groups> groupUpdateStudent;
    @FXML
    public ComboBox<Benefit> benUpdateStudent;
    @FXML
    public Button btnUpdateStudent;
    @FXML
    public Button btnSearchStudent;
    @FXML
    public Button btnDeleteStudent;

    Student student = new Student();
    private ObservableList<Student> listStudent = FXCollections.observableArrayList();
    private ObservableList<Student> listSearchStudent = FXCollections.observableArrayList();
    List<String> listStudentsString = null;
    List<Student> listStudents = null;

    /*Поля должностей на добавление*/
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
    public ComboBox<Position> comboPos;
    @FXML
    public TableView<Position> tablePosition;
    @FXML
    public TableColumn<Position, String> NamePositionColumn;
    @FXML
    public Button btnRedPos;
    @FXML
    public Button btnDelPos;

    List<Position> listPositions = null;

    /*Поля групп на добавление*/
    @FXML
    Label errorAddGroup;
    @FXML
    Label errorUpdateGroup;

    @FXML
    public TextField textAddNameGroup;
    @FXML
    public TextField textUpdateNameGroup;
    @FXML
    public Button btnAddGroup;
    @FXML
    public ComboBox<Groups> comboGroup;
    @FXML
    public TableView<Groups> tableGroup;
    @FXML
    public TableColumn<Groups, String> NameGroupColumn;
    @FXML
    public Button btnUpdateGroup;
    @FXML
    public Button btnDeleteGroup;

    List<Groups> listGroups = null;

    /*Поля отделений на добавление*/
    @FXML
    Label errorAddDepartment;
    @FXML
    Label errorUpdateDepartment;

    @FXML
    public TextField textAddNameDepartment;
    @FXML
    public TextField textUpdateNameDepartment;
    @FXML
    public Button btnAddDepartment;
    @FXML
    public ComboBox<Department> comboDepartment;
    @FXML
    public TableView<Department> tableDepartment;
    @FXML
    public TableColumn<Department, String> NameDepartmentColumn;
    @FXML
    public Button btnUpdateDepartment;
    @FXML
    public Button btnDeleteDepartment;

    List<Department> listDepartments = null;

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
    @FXML
    Label errorAddBenefit;
    @FXML
    Label errorUpdateBenefit;

    @FXML
    public TextField textAddNameBenefit;

    @FXML
    public TextField textUpdateNameBenefit;

    @FXML
    public Button btnAddBenefit;

    @FXML
    public ComboBox<Benefit> comboBenefit;

    @FXML
    public TableView<Benefit> tableBenefit;

    @FXML
    public TableColumn<Benefit, String> NameBenefitColumn;

    @FXML
    public Button btnUpdateBenefit;

    @FXML
    public Button btnDeleteBenefit;

    List<Benefit> listBenefits = null;
    
    public void getReportWorkers() throws SQLException{
    List<ExelModel> report = null;
    report.addAll((List<Worker>)listWorker);
            List<List<String>> listForReport = new ArrayList<>();
            for (ExelModel exModel : report) {
                listForReport.add(exModel.convertToListStrings());
                System.out.println(exModel.convertToListStrings());
            }
            ExelWriter ew = new ExelWriter(ExelType.XLSX);
            try {
                ew.write(listForReport, "./worler.xlsx", "worker");
                System.out.println("xls");

            } catch (IOException ex) {
                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
            }}

    private static final Toolkit kit = Toolkit.getDefaultToolkit();
    private static final Dimension screenSize = kit.getScreenSize();

    private static int lx;
    private static int ly;

    public void openSet(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Settings.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Настройки");
        stage.setScene(new Scene(root1));
        Scene scene = stage.getScene();
        scene.getStylesheets().add("/styles/Login.css");
        stage.setResizable(false);
        // установка иконки
        Image ix = new Image("/icon/lock.png");
        stage.getIcons().add(ix);
        stage.centerOnScreen();

        lx = screenSize.width;
        ly = screenSize.height;

        double x = lx / 2 - 600 / 2;
        double y = ly / 2 - 400 / 2;

        stage.setX(x);
        stage.setY(y);

        stage.show();
    }

    public void openRep(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Report.fxml"));
        Parent root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Отчёт");
        stage.setScene(new Scene(root2));
        Scene scene = stage.getScene();
        scene.getStylesheets().add("/styles/Login.css");
        stage.setResizable(false);
        // установка иконки
        Image ix = new Image("/icon/lock.png");
        stage.getIcons().add(ix);
        stage.centerOnScreen();

        lx = screenSize.width;
        ly = screenSize.height;

        double x = lx / 2 - 600 / 2;
        double y = ly / 2 - 400 / 2;

        stage.setX(x);
        stage.setY(y);

        stage.show();
    }

    @FXML
    private void CheckAddGenderWorkers(ActionEvent e) {
        ChekedOneCheckBox(checkAddGenderMan, checkAddGenderWoman);
    }

    @FXML
    private void CheckAddGenderChild(ActionEvent e) {
        ChekedOneCheckBox(checkAddGenderChildMan, checkAddGenderChildWoman);
    }

    @FXML
    private void CheckUpdateGenderChild(ActionEvent e) {
        ChekedOneCheckBox(checkUpdateGenderChildMan, checkUpdateGenderChildWoman);
    }

    @FXML
    private void CheckAddGenderStudents(ActionEvent e) {
        ChekedOneCheckBox(checkAddGenderManStudent, checkAddGenderWomanStudent);
    }

    @FXML
    private void CheckUpdateGenderStudents(ActionEvent e) {
        ChekedOneCheckBox(checkUpdateGenderManStudent, checkUpdateGenderWomanStudent);
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
                    listPositions.clear();
                    listPositions.addAll(Factory.getInstance().getPositionDAO().getAllPositions());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tablePosition.setItems(FXCollections.observableArrayList(listPositions));
            }
        });

        //Группы
        NameGroupColumn.setCellValueFactory(new PropertyValueFactory<Groups, String>("name"));
        tabGroup.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableGroup.getItems().clear();
                try {
                    listGroups.clear();
                    listGroups.addAll(Factory.getInstance().getGroupDAO().getAllGroups());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableGroup.setItems(FXCollections.observableArrayList(listGroups));
            }
        });

        //Отделения
        NameDepartmentColumn.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
        tabDepartment.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableDepartment.getItems().clear();
                try {
                    listDepartments.clear();
                    listDepartments.addAll(Factory.getInstance().getDepartmentDAO().getAllDepartments());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableDepartment.setItems(FXCollections.observableArrayList(listDepartments));
            }
        });

        //Отделы
        NameBranchColumn.setCellValueFactory(new PropertyValueFactory<Branch, String>("name"));
        tabBranch.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableBranch.getItems().clear();
                try {
                    listBranch.clear();
                    listBranch.addAll(Factory.getInstance().getBranchDAO().getAllBranchs());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableBranch.setItems(listBranch);
            }
        });

        //Льготы
        NameBenefitColumn.setCellValueFactory(new PropertyValueFactory<Benefit, String>("name"));
        tabBenefit.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableBenefit.getItems().clear();
                try {
                    listBenefits.clear();
                    listBenefits.addAll(Factory.getInstance().getBenefitDAO().getAllBenefits());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableBenefit.setItems(FXCollections.observableArrayList(listBenefits));
            }
        });

        //Студенты
        SurStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
        NameStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        PatStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("patronymic"));
        DateStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("birthday"));
        PhoneStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
        EmailStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        GroupStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, Long>("group"));
        DepStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, Long>("department"));
        BenStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, Long>("benefit"));
        GenderStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, Long>("gender"));
        RoleStudentColumn.setCellValueFactory(new PropertyValueFactory<Student, Long>("role"));

        tabStudent.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableStudent.getItems().clear();
                try {
                    listStudent.addAll(Factory.getInstance().getStudentDAO().getAllStudents());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    listRoles = Factory.getInstance().getRoleDAO().getAllRoles();
                    listDepartments = Factory.getInstance().getDepartmentDAO().getAllDepartments();
                    listBenefits = Factory.getInstance().getBenefitDAO().getAllBenefits();
                    listGroups = Factory.getInstance().getGroupDAO().getAllGroups();

                    roleAddStudent.setItems(FXCollections.observableArrayList(listRoles));
                    benAddStudent.setItems(FXCollections.observableArrayList(listBenefits));

                    roleAddStudent.setCellFactory((comboBox) -> {
                        return new ListCell<Role>() {
                            @Override
                            protected void updateItem(Role item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.getTitle());
                                }
                            }
                        };
                    });
                    benAddStudent.setCellFactory((comboBox) -> {
                        return new ListCell<Benefit>() {
                            @Override
                            protected void updateItem(Benefit item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.getName());
                                }
                            }
                        };
                    });

                    groupAddStudent.setItems(FXCollections.observableArrayList(listGroups));
                    depAddStudent.setItems(FXCollections.observableArrayList(listDepartments));
                    roleUpdateStudent.setItems(FXCollections.observableArrayList(listRoles));
                    roleUpdateStudent.setCellFactory((comboBox) -> {
                        return new ListCell<Role>() {
                            @Override
                            protected void updateItem(Role item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.getTitle());
                                }
                            }
                        };
                    });
                    benUpdateStudent.setItems(FXCollections.observableArrayList(listBenefits));
                    benUpdateStudent.setCellFactory((comboBox) -> {
                        return new ListCell<Benefit>() {
                            @Override
                            protected void updateItem(Benefit item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.getName());
                                }
                            }
                        };
                    });

                    groupUpdateStudent.setItems(FXCollections.observableArrayList(listGroups));
                    depUpdateStudent.setItems(FXCollections.observableArrayList(listDepartments));
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableStudent.setItems(listStudent);
            }
        });

        try {
            listBranch.addAll(Factory.getInstance().getBranchDAO().getAllBranchs());
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Работники
        SurWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("surname"));
        NameWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("name"));
        PatWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("patronymic"));
        DateWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("birthday"));
        PosWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("position"));
        DepWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, Long>("department"));
        BranchWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, Long>("branch"));
        BenWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, Long>("benefit"));
        GenderWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, Long>("gender"));
        tabWorker.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableWorker.getItems().clear();
                try {
                    listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    listPositions = Factory.getInstance().getPositionDAO().getAllPositions();
                    posAddWorker.setItems(FXCollections.observableArrayList(listPositions));
                    posAddWorker.setCellFactory((comboBox) -> {
                        return new ListCell<Position>() {
                            @Override
                            protected void updateItem(Position item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.getName());
                                }
                            }
                        };
                    });
                    listBranchs.clear();
                    listBranchs = Factory.getInstance().getBranchDAO().getAllBranchs();
                    branchAddWorker.setItems(FXCollections.observableArrayList(listBranchs));
                    branchAddWorker.setCellFactory((comboBox) -> {
                        return new ListCell<Branch>() {
                            @Override
                            protected void updateItem(Branch item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.getName());
                                }
                            }
                        };
                    });

                    listDepartments = Factory.getInstance().getDepartmentDAO().getAllDepartments();
                    listBenefits = Factory.getInstance().getBenefitDAO().getAllBenefits();
                    benAddWorker.setItems(FXCollections.observableArrayList(listBenefits));
                    benAddWorker.setCellFactory((comboBox) -> {
                        return new ListCell<Benefit>() {
                            @Override
                            protected void updateItem(Benefit item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.getName());
                                }
                            }
                        };
                    });

                    depAddWorker.setItems(FXCollections.observableArrayList(listDepartments));
                    branchUpdateWorker.setItems(FXCollections.observableArrayList(listBranchs));
                    branchUpdateWorker.setCellFactory((comboBox) -> {
                        return new ListCell<Branch>() {
                            @Override
                            protected void updateItem(Branch item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.getName());
                                }
                            }
                        };
                    });
                    posUpdateWorker.setItems(FXCollections.observableArrayList(listPositions));
                    posUpdateWorker.setCellFactory((comboBox) -> {
                        return new ListCell<Position>() {
                            @Override
                            protected void updateItem(Position item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.getName());
                                }
                            }
                        };
                    });

                    benUpdateWorker.setItems(FXCollections.observableArrayList(listBenefits));
                    benUpdateWorker.setCellFactory((comboBox) -> {
                        return new ListCell<Benefit>() {
                            @Override
                            protected void updateItem(Benefit item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item == null || empty) {
                                    setText(null);
                                } else {
                                    setText(item.getName());
                                }
                            }
                        };
                    });
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableWorker.setItems(listWorker);
            }
        });

        //Дети
        SurChildColumn.setCellValueFactory(new PropertyValueFactory<Child, String>("surname"));
        NameChildColumn.setCellValueFactory(new PropertyValueFactory<Child, String>("name"));
        PatChildColumn.setCellValueFactory(new PropertyValueFactory<Child, String>("patronymic"));
        DateChildColumn.setCellValueFactory(new PropertyValueFactory<Child, String>("birthday"));
        GenderChildColumn.setCellValueFactory(new PropertyValueFactory<Child, Long>("gender"));
        tabChild.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                tableChild.getItems().clear();
                try {
                    listWorkersChild.addAll(Factory.getInstance().getWorkersChildDAO().getAllWorkersChilden());
                    listChild.addAll(Factory.getInstance().getChildDAO().getAllChildren());
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }

                tableChild.setItems(listChild);
            }
        });

        try {
            /*Инициализаия компонентов добавления работников*/
            listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableWorker.setItems(listWorker);
        System.out.println(listWorker.toArray().toString());

        try {
            listPositions = Factory.getInstance().getPositionDAO().getAllPositions();
            listDepartments = Factory.getInstance().getDepartmentDAO().getAllDepartments();
            listBenefits = Factory.getInstance().getBenefitDAO().getAllBenefits();
            benAddWorker.setItems(FXCollections.observableArrayList(listBenefits));
            benAddWorker.setCellFactory((comboBox) -> {
                return new ListCell<Benefit>() {
                    @Override
                    protected void updateItem(Benefit item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            });

            posAddWorker.setItems(FXCollections.observableArrayList(listPositions));
            posAddWorker.setCellFactory((comboBox) -> {
                return new ListCell<Position>() {
                    @Override
                    protected void updateItem(Position item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            });

            branchUpdateWorker.setItems(FXCollections.observableArrayList(listBranch));
            branchUpdateWorker.setCellFactory((comboBox) -> {
                return new ListCell<Branch>() {
                    @Override
                    protected void updateItem(Branch item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            });

            branchAddWorker.setItems(FXCollections.observableArrayList(listBranch));
            branchUpdateWorker.setCellFactory((comboBox) -> {
                return new ListCell<Branch>() {
                    @Override
                    protected void updateItem(Branch item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            });
            depAddWorker.setItems(FXCollections.observableArrayList(listDepartments));
            benUpdateWorker.setItems(FXCollections.observableArrayList(listBenefits));
            benUpdateWorker.setCellFactory((comboBox) -> {
                return new ListCell<Benefit>() {
                    @Override
                    protected void updateItem(Benefit item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            });

            posUpdateWorker.setItems(FXCollections.observableArrayList(listPositions));
            posUpdateWorker.setCellFactory((comboBox) -> {
                return new ListCell<Position>() {
                    @Override
                    protected void updateItem(Position item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            });

            depUpdateWorker.setItems(FXCollections.observableArrayList(listDepartments));

        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Инициализаия компонентов ред.-уд. должностей*/
        try {
            listPositions = Factory.getInstance().getPositionDAO().getAllPositions();
            comboPos.setItems(FXCollections.observableArrayList(listPositions));
            comboPos.setCellFactory((comboBox) -> {
                return new ListCell<Position>() {
                    @Override
                    protected void updateItem(Position item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            });
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Инициализаия компонентов ред.-уд. групп*/
        try {
            listGroups = Factory.getInstance().getGroupDAO().getAllGroups();

            comboGroup.setItems(FXCollections.observableArrayList(listGroups));
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Инициализаия компонентов ред.-уд. отделений*/
        try {
            listDepartments = Factory.getInstance().getDepartmentDAO().getAllDepartments();
            comboDepartment.setItems(FXCollections.observableArrayList(listDepartments));
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
            comboBenefit.setItems(FXCollections.observableArrayList(listBenefits));
            comboBenefit.setCellFactory((comboBox) -> {
                return new ListCell<Benefit>() {
                    @Override
                    protected void updateItem(Benefit item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            });
        } catch (SQLException ex) {
            Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*Редактирование должности через кнопку*/
    public void BtnUpdatePosition() throws SQLException {

        if (comboPos.getValue() != null) {
            comboPos.setStyle("");
            if (textUpdatePos.getText().length() > 4) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Редактирование");
                alert.setContentText("Вы действительно хотите редактировать запись?");
                alert.setHeaderText("Подтверждение операции");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    textUpdatePos.setStyle("");
                    errorUpdatePos.setText("");

                    Position selectedPosition = comboPos.getSelectionModel().getSelectedItem();

                    int index = comboPos.getSelectionModel().getSelectedIndex();
                    System.out.println("comboPos.getSelectionModel().getSelectedIndex(); = " + index);

                    // обновление имени должности
                    String reName = textUpdatePos.getText();
                    selectedPosition.setName(reName);

                    // обновление должности в БД
                    Factory.getInstance().getPositionDAO().updatePosition(selectedPosition);

                    // очистка списка должностей
                    listPositions.clear();
                    listPositions.addAll(Factory.getInstance().getPositionDAO().getAllPositions());

                    textUpdatePos.clear();

                    // установка нового списка должностей в комбобокс
                    comboPos.setItems(FXCollections.observableArrayList(listPositions));
                    tablePosition.setItems(FXCollections.observableArrayList(listPositions));
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
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Удаление");
            alert.setContentText("Вы действительно хотите удалить запись?");
            alert.setHeaderText("Подтверждение операции");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Position selectedPosition = comboPos.getSelectionModel().getSelectedItem();
                // Удаление должности
                Factory.getInstance().getPositionDAO().deletePosition(selectedPosition);

                // Обновление списка должностей
                listPositions.clear();
                listPositions.addAll(Factory.getInstance().getPositionDAO().getAllPositions());

                // Установка обновленного списка должностей
                comboPos.setItems(FXCollections.observableArrayList(listPositions));
                tablePosition.setItems(FXCollections.observableArrayList(listPositions));
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
            boolean addOrNot = true;
            //Поиск одинаковых записей
            for (Position p : listPositions) {
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
                listPositions.clear();
                listPositions.addAll(Factory.getInstance().getPositionDAO().getAllPositions());

                textAddNamePos.clear();
                comboPos.setItems(FXCollections.observableArrayList(listPositions));
                tablePosition.setItems(FXCollections.observableArrayList(listPositions));
            }
        } else {
            textAddNamePos.setStyle("-fx-border-color: red;");
            errorAddPos.setText("Введите корректную должность");
        }
    }

    /*Изменение должности через кнопку*/
    public void BtnUpdateGroup() throws SQLException {

        if (comboGroup.getValue() != null) {
            comboPos.setStyle("");
            if (textUpdateNameGroup.getText().length() > 4) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Редактирование");
                alert.setContentText("Вы действительно хотите редактировать запись?");
                alert.setHeaderText("Подтверждение операции");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    textUpdateNameGroup.setStyle("");
                    errorUpdateGroup.setText("");

                    Groups slectedGroups = comboGroup.getSelectionModel().getSelectedItem();
                    String reName = textUpdateNameGroup.getText();

                    slectedGroups.setName(reName);

                    Factory.getInstance().getGroupDAO().updateGroups(slectedGroups);

                    listGroups.clear();
                    listGroups.addAll(Factory.getInstance().getGroupDAO().getAllGroups());

                    textUpdateNameGroup.clear();
                    comboGroup.setItems(FXCollections.observableArrayList(listGroups));
                    tableGroup.setItems(FXCollections.observableArrayList(listGroups));
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
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Удаление");
            alert.setContentText("Вы действительно хотите удалить запись?");
            alert.setHeaderText("Подтверждение операции");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Groups slectedGroups = comboGroup.getSelectionModel().getSelectedItem();

                Factory.getInstance().getGroupDAO().deleteGroups(slectedGroups);

                listGroups.clear();
                listGroups.addAll(Factory.getInstance().getGroupDAO().getAllGroups());

                comboGroup.setItems(FXCollections.observableArrayList(listGroups));
                tableGroup.setItems(FXCollections.observableArrayList(listGroups));
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
            //Поиск одинаковых записей
            boolean addOrNot = true;
            for (Groups p : listGroups) {
                if (p.getName().equals(textAddNameGroup.getText().trim())) {
                    addOrNot = false;
                }
            }
            if (addOrNot == false) {
                textAddNameGroup.setStyle("-fx-border-color: green;");
                errorAddGroup.setText("Запись уже существует");
            } else {
                Groups groups = new Groups(textAddNameGroup.getText().trim());
                Factory.getInstance().getGroupDAO().addGroups(groups);

                listGroups.clear();
                listGroups.addAll(Factory.getInstance().getGroupDAO().getAllGroups());

                textAddNameGroup.clear();
                comboGroup.setItems(FXCollections.observableArrayList(listGroups));
                tableGroup.setItems(FXCollections.observableArrayList(listGroups));
            }
        } else {
            textAddNameGroup.setStyle("-fx-border-color: red;");
            errorAddGroup.setText("Введите корректную должность");
        }
    }

    /*Изменение Отделения через кнопку*/
    public void BtnUpdateDepartment() throws SQLException {

        if (comboDepartment.getValue() != null) {
            comboDepartment.setStyle("");
            if (textUpdateNameDepartment.getText().length() > 4) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Редактирование");
                alert.setContentText("Вы действительно хотите редактировать запись?");
                alert.setHeaderText("Подтверждение операции");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    textUpdateNameDepartment.setStyle("");
                    errorUpdateDepartment.setText("");
                    Department selectedDepartment = comboDepartment.getSelectionModel().getSelectedItem();
                    String reName = textUpdateNameDepartment.getText();
                    selectedDepartment.setName(reName);

                    Factory.getInstance().getDepartmentDAO().updateDepartment(selectedDepartment);

                    listDepartments.clear();
                    listDepartments.addAll(Factory.getInstance().getDepartmentDAO().getAllDepartments());

                    textUpdateNameDepartment.clear();
                    comboDepartment.setItems(FXCollections.observableArrayList(listDepartments));
                    tableDepartment.setItems(FXCollections.observableArrayList(listDepartments));
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
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Удаление");
            alert.setContentText("Вы действительно хотите удалить запись?");
            alert.setHeaderText("Подтверждение операции");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Department selectedDepartment = comboDepartment.getSelectionModel().getSelectedItem();

                Factory.getInstance().getDepartmentDAO().deleteDepartment(selectedDepartment);

                listDepartments.clear();
                listDepartments.addAll(Factory.getInstance().getDepartmentDAO().getAllDepartments());

                comboDepartment.setItems(FXCollections.observableArrayList(listDepartments));
                tableDepartment.setItems(FXCollections.observableArrayList(listDepartments));
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
            boolean addOrNot = true;
            //Поиск одинаковых записей
            for (Department p : listDepartments) {
                if (p.getName().equals(textAddNameDepartment.getText().trim())) {
                    addOrNot = false;
                }
            }
            if (addOrNot == false) {
                textAddNameDepartment.setStyle("-fx-border-color: green;");
                errorAddDepartment.setText("Запись уже существует");
            } else {
                Department newDepartment = new Department(textAddNameDepartment.getText().trim());
                Factory.getInstance().getDepartmentDAO().addDepartment(newDepartment);

                listDepartments.clear();
                listDepartments.addAll(Factory.getInstance().getDepartmentDAO().getAllDepartments());

                textAddNameDepartment.clear();
                comboDepartment.setItems(FXCollections.observableArrayList(listDepartments));
                tableDepartment.setItems(FXCollections.observableArrayList(listDepartments));
            }
        } else {
            textAddNameDepartment.setStyle("-fx-border-color: red;");
            errorAddDepartment.setText("Введите корректное отделение");
        }
    }

    /*Изменение Отделения через кнопку*/
    public void BtnUpdateBranch() throws SQLException {

        if (comboBranch.getValue() != null) {
            comboBranch.setStyle("");
            if (textUpdateNameBranch.getText().length() > 4) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Редактирование");
                alert.setContentText("Вы действительно хотите редактировать запись?");
                alert.setHeaderText("Подтверждение операции");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
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
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Удаление");
            alert.setContentText("Вы действительно хотите удалить запись?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

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
            boolean addOrNot = true;
            //Поиск одинаковых записей
            if (listBranch.size() > 0) {
                for (Branch p : listBranch) {
                    if (p.getName().equals(textAddNameBranch.getText().trim())) {
                        addOrNot = false;
                    }
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
        } else {
            textAddNameDepartment.setStyle("-fx-border-color: red;");
            errorAddDepartment.setText("Введите корректное отделение");
        }
    }

    /*Изменение Отделения через кнопку*/
    public void BtnUpdateBenefit() throws SQLException {

        if (comboBenefit.getValue() != null) {
            comboBenefit.setStyle("");
            if (textUpdateNameBenefit.getText().length() > 4) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Редактирование");
                alert.setContentText("Вы действительно хотите изменить запись?");
                alert.setHeaderText("Подтверждение операции");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    textUpdateNameBenefit.setStyle("");
                    errorUpdateBenefit.setText("");
                    Benefit selectionBenefit = comboBenefit.getSelectionModel().getSelectedItem();
                    String reName = textUpdateNameBenefit.getText();
                    selectionBenefit.setName(reName);

                    Factory.getInstance().getBenefitDAO().updateBenefit(selectionBenefit);

                    listBenefits.clear();
                    listBenefits.addAll(Factory.getInstance().getBenefitDAO().getAllBenefits());

                    textUpdateNameBenefit.clear();
                    comboBenefit.setItems(FXCollections.observableArrayList(listBenefits));
                    tableBenefit.setItems(FXCollections.observableArrayList(listBenefits));
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

        if (comboBenefit.getSelectionModel().getSelectedItem() != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Удаление");
            alert.setContentText("Вы действительно хотите удалить запись?");
            alert.setHeaderText("Подтверждение операции");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Benefit selectionBenefit = comboBenefit.getSelectionModel().getSelectedItem();

                Factory.getInstance().getBenefitDAO().deleteBenefit(selectionBenefit);

                listBenefits.clear();
                listBenefits.addAll(Factory.getInstance().getBenefitDAO().getAllBenefits());

                comboBenefit.setItems(FXCollections.observableArrayList(listBenefits));
                tableBenefit.setItems(FXCollections.observableArrayList(listBenefits));
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
            boolean addOrNot = true;
            //Поиск одинаковых записей
            for (Benefit p : listBenefits) {
                if (p.getName().equals(textAddNameBenefit.getText().trim())) {
                    addOrNot = false;
                }
            }
            if (addOrNot == false) {
                textAddNameBenefit.setStyle("-fx-border-color: green;");
                errorAddBenefit.setText("Запись уже существует");
            } else {

                Benefit newBenefit = new Benefit(textAddNameBenefit.getText().trim());
                Factory.getInstance().getBenefitDAO().addBenefit(newBenefit);
                listBenefits.clear();
                listBenefits.addAll(Factory.getInstance().getBenefitDAO().getAllBenefits());

                textAddNameBenefit.clear();
                comboBenefit.setItems(FXCollections.observableArrayList(listBenefits));
                tableBenefit.setItems(FXCollections.observableArrayList(listBenefits));
            }
        } else {
            textAddNameBenefit.setStyle("-fx-border-color: red;");
            errorAddBenefit.setText("Введите корректное отделение");
        }
    }

    public void BtnSearchWorker() throws SQLException {
        listWorker.clear();
        listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
        tableWorker.setItems(listWorker);
        for (int index = 0; index < listWorker.size(); index++) {
            worker = listWorker.get(index);
            System.out.println(listWorker.get(index).convertToListStrings());
        }
        boolean searchBool = true;
        Worker searchWorker = new Worker();
        if (textUpdateSurWorker.getText().length() > 1) {
            searchWorker.setSurname(textUpdateSurWorker.getText());
        }
        if (textUpdateNameWorker.getText().length() > 1) {
            searchWorker.setName(textUpdateNameWorker.getText());
        }
        if (textUpdatePatWorker.getText().length() > 4) {
            searchWorker.setPatronymic(textUpdatePatWorker.getText());
        }
        if (depUpdateWorker.getValue() != null) {
            Department department = depUpdateWorker.getSelectionModel().getSelectedItem();
            searchWorker.setDepartment(department);
        }
        if (benUpdateWorker.getValue() != null) {
            Benefit benefit = benUpdateWorker.getSelectionModel().getSelectedItem();
            searchWorker.setBenefit(benefit);
        }
        if (posUpdateWorker.getValue() != null) {
            Position selectedPosition = posUpdateWorker.getSelectionModel().getSelectedItem();
            searchWorker.setPosition(selectedPosition);
        }
        if (dataUpdateWorker.getValue() != null) {
            searchWorker.setBirthday(dataUpdateWorker.getValue().toString());
        }
        if (SelectOneCheckBox(checkUpdateGenderMan, checkUpdateGenderWoman) != null) {
            Gender gender = new Gender();
            gender.setId(SelectOneCheckBox(checkUpdateGenderMan, checkUpdateGenderWoman));
            searchWorker.setGender(gender);
        }
        if (listWorker.size()==0) {
            worker = listWorker.get(0);
            System.out.println(listWorker.get(0).convertToListStrings());

            if (searchWorker.getSurname() != null && searchBool == true) {
                if (searchWorker.getSurname().toString().equals(worker.getSurname().toString())) {

                } else {
                    searchBool = false;
                }
            } else {
            }
            if (searchWorker.getName() != null && searchBool == true) {
                if (worker.getName().toString().equals(searchWorker.getName().toString())) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchWorker.getPatronymic() != null && searchBool == true) {
                if (worker.getPatronymic().toString().equals(searchWorker.getPatronymic().toString())) {
                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchWorker.getBirthday() != null && searchBool == true) {
                if (worker.getBirthday().toString().equals(searchWorker.getBirthday().toString())) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchWorker.getBenefit() != null && searchBool == true) {
                if (worker.getBenefit().toString().equals(searchWorker.getBenefit().toString())) {
                    searchBool = false;
                } else {

                }
            } else {

            }
            if (searchWorker.getDepartment() != null && searchBool == true) {
                if (worker.getDepartment().toString().equals(searchWorker.getDepartment().toString())) {

                } else {
                    searchBool = false;
                }
            } else {

            }

            if (searchWorker.getPosition() != null && searchBool == true) {
                if (worker.getPosition().toString().equals(searchWorker.getPosition().toString())) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchWorker.getGender() != null && searchBool == true) {
                if (worker.getGender() == searchWorker.getGender()) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchBool == true) {
                listSearchWorker.add(worker);
            } else {
                searchBool = true;
            }

        } else {
            for (int index = 1; index < listWorker.size(); index++) {
                worker = listWorker.get(index);
                System.out.println(listWorker.get(index).convertToListStrings());

                if (searchWorker.getSurname() != null && searchBool == true) {
                    if (searchWorker.getSurname().toString().equals(worker.getSurname().toString())) {

                    } else {
                        searchBool = false;
                    }
                } else {
                }
                if (searchWorker.getName() != null && searchBool == true) {
                    if (worker.getName().toString().equals(searchWorker.getName().toString())) {

                    } else {
                        searchBool = false;
                    }
                } else {

                }
                if (searchWorker.getPatronymic() != null && searchBool == true) {
                    if (worker.getPatronymic().toString().equals(searchWorker.getPatronymic().toString())) {
                    } else {
                        searchBool = false;
                    }
                } else {

                }
                if (searchWorker.getBirthday() != null && searchBool == true) {
                    if (worker.getBirthday().toString().equals(searchWorker.getBirthday().toString())) {

                    } else {
                        searchBool = false;
                    }
                } else {

                }
                if (searchWorker.getBenefit() != null && searchBool == true) {
                    if (worker.getBenefit().toString().equals(searchWorker.getBenefit().toString())) {
                        searchBool = false;
                    } else {

                    }
                } else {

                }
                if (searchWorker.getDepartment() != null && searchBool == true) {
                    if (worker.getDepartment().toString().equals(searchWorker.getDepartment().toString())) {

                    } else {
                        searchBool = false;
                    }
                } else {

                }

                if (searchWorker.getPosition() != null && searchBool == true) {
                    if (worker.getPosition().toString().equals(searchWorker.getPosition().toString())) {

                    } else {
                        searchBool = false;
                    }
                } else {

                }
                if (searchWorker.getGender() != null && searchBool == true) {
                    if (worker.getGender() == searchWorker.getGender()) {

                    } else {
                        searchBool = false;
                    }
                } else {

                }
                if (searchBool == true) {
                    listSearchWorker.add(worker);
                } else {
                    searchBool = true;
                }
                if (listWorker.size() == 1) {
                    break;
                }

            }

        }
        listWorker = listSearchWorker;
        tableWorker.getItems().clear();
        tableWorker.setItems(listWorker);
        checkUpdateGenderMan.setSelected(false);
        checkUpdateGenderWoman.setSelected(false);
        textUpdateSurWorker.clear();
        textUpdateNameWorker.clear();
        textUpdatePatWorker.clear();
        dataUpdateWorker.setValue(null);
        depUpdateWorker.setValue(null);
        posUpdateWorker.setValue(null);
        benUpdateWorker.setValue(null);
        for (int index = 0; index < listWorker.size(); index++) {
            worker = listWorker.get(index);
            System.out.println(listWorker.get(index).convertToListStrings());
        }
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
        depUpdateWorker.setValue(worker.getDepartment());
        posUpdateWorker.setValue(worker.getPosition());
        benUpdateWorker.setValue(worker.getBenefit());
        branchUpdateWorker.setValue(worker.getBranch());
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
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Редактирование");
        alert.setContentText("Вы действительно хотите редактировать запись?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            if (textUpdateSurWorker.getText().trim().length() > 1) {
                worker.setSurname(textUpdateSurWorker.getText().trim());
            }
            if (textUpdateNameWorker.getText().trim().length() > 1) {
                worker.setName(textUpdateNameWorker.getText().trim());
            }
            if (textUpdatePatWorker.getText().trim().length() > 4) {
                worker.setPatronymic(textUpdatePatWorker.getText().trim());
            }
            if (depUpdateWorker.getValue().toString() != worker.getDepartment().getName()) {
                Department department = depUpdateWorker.getSelectionModel().getSelectedItem();
                worker.setDepartment(department);
            }

            Benefit benefit = benUpdateWorker.getSelectionModel().getSelectedItem();
            worker.setBenefit(benefit);

            if (posUpdateWorker.getValue().toString() != worker.getPosition().getName()) {
                Position position = posUpdateWorker.getSelectionModel().getSelectedItem();
                worker.setPosition(position);
            }
            if (branchUpdateWorker.getValue().toString() != worker.getBranch().getName()) {
                Branch branch = branchUpdateWorker.getSelectionModel().getSelectedItem();
                worker.setBranch(branch);
            }
            if (dataUpdateWorker.getValue().toString() != worker.getBirthday().toString() && dataUpdateWorker.getValue() != null) {
                worker.setBirthday(dataUpdateWorker.getValue().toString().trim());
            }
            Gender gender = new Gender();
            gender.setId(SelectOneCheckBox(checkUpdateGenderMan, checkUpdateGenderWoman));
            worker.setGender(gender);
            Factory.getInstance().getWorkerDAO().updateWorker(worker);
            worker = null;
            textUpdateSurWorker.setText(null);
            textUpdateNameWorker.setText(null);
            textUpdatePatWorker.setText(null);
            dataUpdateWorker.setValue(null);
            checkUpdateGenderMan.setSelected(false);
            checkUpdateGenderWoman.setSelected(false);
            depUpdateWorker.setValue(null);
            posUpdateWorker.setValue(null);
            benUpdateWorker.setValue(null);
            branchUpdateWorker.setValue(null);

            listWorker.clear();
            tableWorker.getItems().clear();
            listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
            tableWorker.setItems(listWorker);
        } else {
        }
    }

    public void BtnDeleteWorker() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableWorker.getSelectionModel();
        worker = listWorker.get(selectionModel.getFocusedIndex());
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Удаление");
        alert.setContentText("Вы действительно хотите удалить запись?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Factory.getInstance().getWorkerDAO().deleteWorker(worker);
            listWorker.clear();
            listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
            tableWorker.setItems(listWorker);
            textUpdateSurWorker.setText(null);
            textUpdateNameWorker.setText(null);
            textUpdatePatWorker.setText(null);
            dataUpdateWorker.setValue(null);
            checkUpdateGenderMan.setSelected(false);
            checkUpdateGenderWoman.setSelected(false);
            depUpdateWorker.setValue(null);
            posUpdateWorker.setValue(null);
            benUpdateWorker.setValue(null);
            branchUpdateWorker.setValue(null);
        }
    }

    public void BtnAddWorker() throws SQLException {
        if (textAddSurWorker.getText().trim().length() > 2
                && textAddNameWorker.getText().trim().length() > 1
                && textAddPatWorker.getText().trim().length() > 4
                && dataAddWorker.getValue().toString().trim().length() > 4
                && depAddWorker.getValue() != null
                && posAddWorker.getValue() != null
                && branchAddWorker.getValue() != null) {
            worker.setSurname(textAddSurWorker.getText().trim());
            worker.setName(textAddNameWorker.getText().trim());
            worker.setPatronymic(textAddPatWorker.getText().trim());
            Gender gender = new Gender();
            gender = Factory.getInstance().getGenderDAO().getGenderById(SelectOneCheckBox(checkAddGenderMan, checkAddGenderWoman));
            worker.setGender(gender);
            worker.setBirthday(dataAddWorker.getValue().toString());
            Department department = depAddWorker.getSelectionModel().getSelectedItem();
            worker.setDepartment(department);
            if (branchAddWorker.getSelectionModel().getSelectedItem() != null) {
                Branch branch = branchAddWorker.getSelectionModel().getSelectedItem();
                worker.setBranch(branch);
            }
            position = posAddWorker.getSelectionModel().getSelectedItem();
            worker.setPosition(position);
            Benefit benefit = benAddWorker.getSelectionModel().getSelectedItem();
            worker.setBenefit(benefit);
            Factory.getInstance().getWorkerDAO().addWorker(worker);
            listWorker.clear();
            listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
            tableWorker.setItems(listWorker);
            textAddSurWorker.setText(null);
            textAddNameWorker.setText(null);
            textAddPatWorker.setText(null);
            dataAddWorker.setValue(null);
            checkAddGenderMan.setSelected(false);
            checkAddGenderWoman.setSelected(false);
            depAddWorker.setValue(null);
            posAddWorker.setValue(null);
            benAddWorker.setValue(null);
            branchAddWorker.setValue(null);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setHeaderText(null);
            alert.setContentText("Заполнены не все поля");

            alert.showAndWait();
        }
    }

    public int BtnSearchStudent() throws SQLException {
        boolean searchBool = true;
        Student searchStudent = new Student();
        if (textUpdateSurStudent.getText().trim().length() > 1) {
            searchStudent.setSurname(textUpdateSurStudent.getText().trim());
        }
        if (textUpdateNameStudent.getText().trim().length() > 1) {
            searchStudent.setName(textUpdateNameStudent.getText().trim());
        }
        if (textUpdatePatStudent.getText().trim().length() > 4) {
            searchStudent.setPatronymic(textUpdatePatStudent.getText().trim());
        }
        if (depUpdateStudent.getValue() != null) {
            Department department = depUpdateStudent.getSelectionModel().getSelectedItem();
            searchStudent.setDepartment(department);
        }
        if (benUpdateStudent.getValue() != null) {
            Benefit benefit = benUpdateStudent.getSelectionModel().getSelectedItem();
            searchStudent.setBenefit(benefit);
        }
        if (groupUpdateStudent.getValue() != null) {
            Groups group = groupUpdateStudent.getSelectionModel().getSelectedItem();
            searchStudent.setGroup(group);
        }
        if (dataUpdateStudent.getValue() != null) {
            searchStudent.setBirthday(dataUpdateStudent.getValue().toString().trim());
        }
        if (SelectOneCheckBox(checkUpdateGenderManStudent, checkUpdateGenderWomanStudent) != null) {
            Gender gender = new Gender();
            gender.setId(SelectOneCheckBox(checkUpdateGenderManStudent, checkUpdateGenderWomanStudent));
            searchStudent.setGender(gender);
        }

        for (int index = 0; index < listStudent.size(); index++) {
            student = listStudent.get(index);

            if (searchStudent.getSurname() != null && searchBool == true) {
                if (searchStudent.getSurname().equals(student.getSurname())) {

                } else {
                    searchBool = false;
                }
            } else {
            }
            if (searchStudent.getName() != null && searchBool == true) {
                if (searchStudent.getName().equals(student.getName())) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchStudent.getPatronymic() != null && searchBool == true) {
                if (student.getPatronymic().equals(searchStudent.getPatronymic())) {
                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchStudent.getBirthday() != null && searchBool == true) {
                if (student.getBirthday().equals(searchStudent.getBirthday())) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchStudent.getBenefit() != null && searchBool == true) {
                if (student.getBenefit().toString().equals(searchStudent.getBenefit().toString())) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchStudent.getGroup() != null && searchBool == true) {
                if (student.getGroup().toString().equals(searchStudent.getGroup().toString())) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchStudent.getDepartment() != null && searchBool == true) {
                if (student.getDepartment().toString().equals(searchStudent.getDepartment().toString())) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchStudent.getGender() != null && searchBool == true) {
                if (student.getGender() == searchStudent.getGender()) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchBool == true) {
                listSearchStudent.add(student);
            } else {
                searchBool = true;
            }
        }
        tableStudent.getItems().clear();
        tableStudent.setItems(listSearchStudent);

        return 5;
    }

    public void SelectRowTableStudent() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableStudent.getSelectionModel();
        int number = selectionModel.getFocusedIndex();
        student = listStudent.get(selectionModel.getFocusedIndex());
        textUpdateSurStudent.setText(student.getSurname());
        textUpdateNameStudent.setText(student.getName());
        textUpdatePatStudent.setText(student.getPatronymic());
        textUpdatePhoneStudent.setText(student.getPhone());
        textUpdateEmailStudent.setText(student.getEmail());
        LocalDate date = LocalDate.parse(student.getBirthday());
        dataUpdateStudent.setValue(date);
        depUpdateStudent.setValue(student.getDepartment());
        groupUpdateStudent.setValue(student.getGroup());
        benUpdateStudent.setValue(student.getBenefit());
        roleUpdateStudent.setValue(student.getRole());
        checkUpdateGenderManStudent.setSelected(false);
        checkUpdateGenderWomanStudent.setSelected(false);
        if (student.getGender().getId() == 1L) {
            checkUpdateGenderManStudent.setSelected(true);
        } else {
            checkUpdateGenderWomanStudent.setSelected(true);
        }
    }

    public void BtnUpdateStudent() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableStudent.getSelectionModel();
        student = listStudent.get(selectionModel.getFocusedIndex());
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Редактирование");
        alert.setContentText("Вы действительно хотите редактировать запись?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            if (textUpdateSurStudent.getText().trim().length() > 1) {
                student.setSurname(textUpdateSurStudent.getText().trim());
            }
            if (textUpdateNameStudent.getText().trim().length() > 1) {
                student.setName(textUpdateNameStudent.getText().trim());
            }
            if (textUpdatePatStudent.getText().trim().length() > 4) {
                student.setPatronymic(textUpdatePatStudent.getText().trim());
            }

            if (textUpdatePhoneStudent.getText().trim().length() > 1) {
                student.setPhone(textUpdatePhoneStudent.getText().trim());
            }
            if (textUpdateEmailStudent.getText().trim().length() > 4) {
                student.setEmail(textUpdateEmailStudent.getText().trim());
            }
            if (depUpdateStudent.getValue().toString() != student.getDepartment().getName()) {
                Department department = depUpdateStudent.getSelectionModel().getSelectedItem();
                student.setDepartment(department);
            }
            if (roleUpdateStudent.getValue().toString() != student.getRole().getTitle()) {
                Role role = roleUpdateStudent.getSelectionModel().getSelectedItem();
                student.setRole(role);
            }
            if (benUpdateStudent.getValue().toString() != student.getBenefit().getName()) {
                Benefit benefit = benUpdateStudent.getSelectionModel().getSelectedItem();
                worker.setBenefit(benefit);
            }
            if (groupUpdateStudent.getValue().toString() != student.getGroup().getName()) {
                Groups group = groupUpdateStudent.getSelectionModel().getSelectedItem();
                student.setGroup(group);
            }

            if (dataUpdateStudent.getValue().toString() != student.getBirthday().toString() && dataUpdateStudent.getValue() != null) {
                student.setBirthday(dataUpdateStudent.getValue().toString().trim());
            }

            if (textUpdatePhoneStudent.getText().trim().length() > 1) {
                student.setPhone(textUpdatePhoneStudent.getText().trim());
            }
            if (textUpdateEmailStudent.getText().trim().length() > 1) {
                student.setEmail(textUpdateEmailStudent.getText().trim());
            }
            Gender gender = new Gender();
            gender.setId(SelectOneCheckBox(checkUpdateGenderManStudent, checkUpdateGenderWomanStudent));
            student.setGender(gender);
            Factory.getInstance().getStudentDAO().updateStudent(student);

            textUpdateSurStudent.setText(null);
            textUpdateNameStudent.setText(null);
            textUpdatePatStudent.setText(null);
            dataUpdateStudent.setValue(null);
            checkUpdateGenderManStudent.setSelected(false);
            checkUpdateGenderWomanStudent.setSelected(false);
            depUpdateStudent.setValue(null);
            groupUpdateStudent.setValue(null);
            roleUpdateStudent.setValue(null);
            benUpdateStudent.setValue(null);
            textUpdatePhoneStudent.setText(null);
            textUpdateEmailStudent.setText(null);

            listStudent.clear();
            tableStudent.getItems().clear();
            listStudent.addAll(Factory.getInstance().getStudentDAO().getAllStudents());
            tableStudent.setItems(listStudent);
        }
    }

    public void BtnDeleteStudent() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableStudent.getSelectionModel();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Удаление");
        alert.setContentText("Вы действительно хотите удалить запись?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            student = listStudent.get(selectionModel.getFocusedIndex());
            Factory.getInstance().getStudentDAO().deleteStudent(student);
            listStudent.clear();
            listStudent.addAll(Factory.getInstance().getStudentDAO().getAllStudents());
            tableStudent.setItems(listStudent);
        }
    }

    public void BtnAddStudent() throws SQLException {
        if (textAddSurStudent.getText().trim().length() > 2
                && textAddNameStudent.getText().trim().length() > 1
                && textAddPatStudent.getText().trim().length() > 2
                && dataAddStudent.getValue() != null
                && depAddStudent.getValue() != null
                && groupAddStudent.getValue() != null
                && benAddStudent.getValue() != null
                && roleAddStudent.getValue() != null) {
            student.setSurname(textAddSurStudent.getText().trim());
            student.setName(textAddNameStudent.getText().trim());
            student.setPatronymic(textAddPatStudent.getText().trim());
            student.setPhone(textAddPhoneStudent.getText().trim());
            student.setEmail(textAddEmailStudent.getText().trim());
            Gender gender = new Gender();
            gender = Factory.getInstance().getGenderDAO().getGenderById(SelectOneCheckBox(checkAddGenderManStudent, checkAddGenderWomanStudent));
            student.setGender(gender);
            student.setBirthday(dataAddStudent.getValue().toString().trim());

            Department department = depAddStudent.getSelectionModel().getSelectedItem();

            student.setDepartment(department);

            Role role = roleAddStudent.getSelectionModel().getSelectedItem();

            student.setRole(role);
            Groups group = groupAddStudent.getSelectionModel().getSelectedItem();
            student.setGroup(group);

            Benefit benefit = benAddStudent.getSelectionModel().getSelectedItem();
            student.setBenefit(benefit);
            Factory.getInstance().getStudentDAO().saveOnlyStudent(student);
            listStudent.clear();
            listStudent.addAll(Factory.getInstance().getStudentDAO().getAllStudents());
            tableStudent.setItems(listStudent);
            textAddSurStudent.setText(null);
            textAddNameStudent.setText(null);
            textAddPatStudent.setText(null);
            dataAddStudent.setValue(null);
            checkAddGenderManStudent.setSelected(false);
            checkAddGenderWomanStudent.setSelected(false);
            depAddStudent.setValue(null);
            groupAddStudent.setValue(null);
            roleAddStudent.setValue(null);
            benAddStudent.setValue(null);
            textAddPhoneStudent.setText(null);
            textAddEmailStudent.setText(null);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setHeaderText(null);
            alert.setContentText("Заполнены не все поля");

            alert.showAndWait();

        }
    }

    public void SelectRowTableChild() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableChild.getSelectionModel();
        int number = selectionModel.getFocusedIndex();
        child = listChild.get(number);
        textUpdateSurChild.setText(child.getSurname());
        textUpdateNameChild.setText(child.getName());
        textUpdatePatChild.setText(child.getPatronymic());
        LocalDate date = LocalDate.parse(child.getBirthday());
        dataUpdateChild.setValue(date);
        checkUpdateGenderChildMan.setSelected(false);
        checkUpdateGenderChildWoman.setSelected(false);
        if (child.getGender().getId() == 1L) {
            checkUpdateGenderChildMan.setSelected(true);
        } else {
            checkUpdateGenderChildWoman.setSelected(true);
        }
    }

    public void BtnAddChild() throws SQLException {
        if (textAddSurChild.getText().trim().length() > 2
                && textAddNameChild.getText().trim().length() > 1
                && textAddPatChild.getText().trim().length() > 2
                && dataAddChild.getValue().toString().trim().length() > 4
                && textAddNameWorkChild.getText().trim().length() > 1
                && textAddPatWorkChild.getText().trim().length() > 1
                && textAddSurWorkChild.getText().trim().length() > 1) {
            child.setSurname(textAddSurChild.getText().trim());
            child.setName(textAddNameChild.getText().trim());
            child.setPatronymic(textAddPatChild.getText().trim());
            Gender gender = new Gender();
            gender = Factory.getInstance().getGenderDAO().getGenderById(SelectOneCheckBox(checkAddGenderChildMan, checkAddGenderChildWoman));
            child.setGender(gender);
            child.setBirthday(dataAddChild.getValue().toString().trim());
            Factory.getInstance().getChildDAO().addChild(child);
            Worker searchWorker = new Worker();
            searchWorker.setName(textAddNameWorkChild.getText().trim());
            searchWorker.setSurname(textAddSurWorkChild.getText().trim());
            searchWorker.setPatronymic(textAddPatWorkChild.getText().trim());
            System.out.println("По пизде 1");
            if (listWorker.size() == 1) {
                worker = listWorker.get(0);
                if (worker.getName().equals(searchWorker.getName())
                        && worker.getSurname().equals(searchWorker.getSurname())
                        && worker.getPatronymic().equals(searchWorker.getPatronymic())) {
                    worker.getChildren().add(child);
                    Factory.getInstance().getWorkerDAO().updateWorker(worker);
                } else if (listWorker.size() > 1) {
                    for (int i = 0; i < listWorker.size(); i++) {
                        System.out.println("Цикл номер " + i);
                        worker = listWorker.get(i);
                        if (worker.getName().equals(searchWorker.getName())
                                && worker.getSurname().equals(searchWorker.getSurname())
                                && worker.getPatronymic().equals(searchWorker.getPatronymic())) {
                            worker.getChildren().add(child);
                            Factory.getInstance().getWorkerDAO().updateWorker(worker);
                        }
                    }
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Предупреждение");
                    alert.setHeaderText(null);
                    alert.setContentText("Такого родителя не существует");

                    alert.showAndWait();
                }
            }
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setHeaderText(null);
            alert.setContentText("Заполнены не все поля");

            alert.showAndWait();
        }
        listChild.clear();
        tableChild.getItems().clear();
        listChild.addAll(Factory.getInstance().getChildDAO().getAllChildren());
        tableChild.setItems(listChild);
    }

    public void BtnDeleteChild() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableChild.getSelectionModel();
        child = listChild.get(selectionModel.getFocusedIndex());
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Удаление");
        alert.setContentText("Вы действительно хотите удалить запись?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Factory.getInstance().getChildDAO().deleteChildren(child);
            listChild.clear();
            tableChild.getItems().clear();
            listChild.addAll(Factory.getInstance().getChildDAO().getAllChildren());
            tableChild.setItems(listChild);
        }
    }

    public void BtnSearchChild() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableChild.getSelectionModel();
        child = listChild.get(selectionModel.getFocusedIndex());
        if (textUpdateSurChild.getText().trim().length() > 1) {
            student.setSurname(textUpdateSurChild.getText().trim());
        }
        if (textUpdateNameChild.getText().trim().length() > 1) {
            student.setName(textUpdateNameChild.getText().trim());
        }
        if (textUpdatePatChild.getText().trim().length() > 4) {
            child.setPatronymic(textUpdatePatChild.getText().trim());
        }

        if (dataUpdateChild.getValue().toString() != child.getBirthday().toString() && dataUpdateChild.getValue() != null) {
            child.setBirthday(dataUpdateChild.getValue().toString().trim());
        }
        Gender gender = new Gender();
        gender.setId(SelectOneCheckBox(checkUpdateGenderChildMan, checkUpdateGenderChildWoman));
        child.setGender(gender);
        /* System.out.println("SUR:" + worker.getSurname() + "PAT:"
         + worker.getPatronymic() + "NAM:" + worker.getName() + "DR:"
         + worker.getBirthday() + "BEN:" + worker.getBenefit()
         + "DEP:" + worker.getDepartment() + "GEN:" + worker.getGender());*/
        Factory.getInstance().getChildDAO().updateChild(child);

        textUpdateSurChild.setText(null);
        textUpdateNameChild.setText(null);
        textUpdatePatChild.setText(null);
        dataUpdateChild.setValue(null);
        checkUpdateGenderChildMan.setSelected(false);
        checkUpdateGenderChildWoman.setSelected(false);

        listChild.clear();
        tableChild.getItems().clear();
        listChild.addAll(Factory.getInstance().getChildDAO().getAllChildren());
        tableChild.setItems(listChild);
    }

    public void BtnUpdateChild() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableChild.getSelectionModel();
        child = listChild.get(selectionModel.getFocusedIndex());
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Редактирование");
        alert.setContentText("Вы действительно хотите редактировать запись?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            if (textUpdateSurChild.getText().trim().length() > 1) {
                child.setSurname(textUpdateSurChild.getText().trim());
            }
            if (textUpdateNameChild.getText().trim().length() > 1) {
                child.setName(textUpdateNameChild.getText().trim());
            }
            if (textUpdatePatChild.getText().trim().length() > 4) {
                child.setPatronymic(textUpdatePatChild.getText().trim());
            }
            if (dataUpdateChild.getValue().toString() != child.getBirthday().toString() && dataUpdateChild.getValue() != null) {
                child.setBirthday(dataUpdateChild.getValue().toString().trim());
            }
            Gender gender = new Gender();
            gender = Factory.getInstance().getGenderDAO().getGenderById(SelectOneCheckBox(checkUpdateGenderChildMan, checkUpdateGenderChildWoman));
            child.setGender(gender);
            Factory.getInstance().getChildDAO().updateChild(child);
            workersChild.setId_child(child.getId());
            Worker searchWorker = new Worker();
            if (textUpdateSurWorkChild.getText().trim().length() > 1
                    && textUpdateNameWorkChild.getText().trim().length() > 1
                    && textUpdatePatWorkChild.getText().trim().length() > 4) {
                searchWorker.setSurname(textUpdateSurWorkChild.getText().trim());
                searchWorker.setName(textUpdateNameWorkChild.getText().trim());
                searchWorker.setPatronymic(textUpdatePatWorkChild.getText().trim());
            }
            if (listWorker.size() == 1) {
                worker = listWorker.get(0);
                if (worker.getName().equals(searchWorker.getName())
                        && worker.getSurname().equals(searchWorker.getSurname())
                        && worker.getPatronymic().equals(searchWorker.getPatronymic())) {
                    workersChild.setId_worker(worker.getId());
                    Factory.getInstance().getWorkersChildDAO().updateWorkersChild(workersChild);
                } else if (listWorker.size() > 1) {
                    for (int i = 0; i < listWorker.size(); i++) {
                        System.out.println("Цикл номер " + i);
                        worker = listWorker.get(i);
                        if (worker.getName().equals(searchWorker.getName())
                                && worker.getSurname().equals(searchWorker.getSurname())
                                && worker.getPatronymic().equals(searchWorker.getPatronymic())) {
                            workersChild.setId_child(worker.getId());
                        }
                        Factory.getInstance().getWorkersChildDAO().updateWorkersChild(workersChild);
                    }
                } else {
                    Alert newAlert = new Alert(AlertType.INFORMATION);
                    newAlert.setTitle("Предупреждение");
                    newAlert.setHeaderText(null);
                    newAlert.setContentText("Такого родителя не существует");

                    newAlert.showAndWait();
                }
            }
        }
    }
}
