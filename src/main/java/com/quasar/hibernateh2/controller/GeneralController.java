package com.quasar.hibernateh2.controller;

import static com.quasar.hibernateh2.app.OneCheckBox.ChekedOneCheckBox;
import static com.quasar.hibernateh2.app.OneCheckBox.SelectOneCheckBox;
import com.quasar.hibernateh2.dao.Factory;
import com.quasar.hibernateh2.dao.entity.Benefit;
import com.quasar.hibernateh2.dao.entity.Branch;
import com.quasar.hibernateh2.dao.entity.Child;
import com.quasar.hibernateh2.dao.entity.Department;
import com.quasar.hibernateh2.dao.entity.Gender;
import com.quasar.hibernateh2.dao.entity.Groups;
import com.quasar.hibernateh2.dao.entity.Position;
import com.quasar.hibernateh2.dao.entity.Student;
import com.quasar.hibernateh2.dao.entity.Worker;
import com.quasar.hibernateh2.dao.entity.WorkersChild;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
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
    public ComboBox depAddWorker;
    @FXML
    public ComboBox<Position> posAddWorker;
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
    public ComboBox depUpdateWorker;
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
    public ComboBox roleAddStudent;
    @FXML
    public ComboBox depAddStudent;
    @FXML
    public ComboBox<Benefit> benAddStudent;
    @FXML
    public Button btnAddStudent;
    @FXML
    public TableView tableStudent;
    @FXML
    public Label errorAddStudent;

    @FXML
    public TableColumn<Student, String> SurStudentColumn;
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
    public ComboBox depUpdateStudent;
    @FXML
    public ComboBox roleUpdateStudent;
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

    Groups group = new Groups();
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
                    listDepartment.clear();
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
                    listDepartments = Factory.getInstance().getDepartmentDAO().getAllDepartments();
                    listDepartmentsString = new ArrayList<>();
                    for (Department p : listDepartments) {
                        System.out.println(p.getName());
                        listDepartmentsString.add(p.getName());
                    }
                    listBenefits = Factory.getInstance().getBenefitDAO().getAllBenefits();

                    listGroups = Factory.getInstance().getGroupDAO().getAllGroups();

                    benAddStudent.setItems(FXCollections.observableArrayList(listBenefits));
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
                    depAddStudent.setItems(FXCollections.observableArrayList(listDepartmentsString));

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
                    depUpdateStudent.setItems(FXCollections.observableArrayList(listDepartmentsString));
                } catch (SQLException ex) {
                    Logger.getLogger(GeneralController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableStudent.setItems(listStudent);
            }
        });

        //Работники
        SurWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("surname"));
        NameWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("name"));
        PatWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("patronymic"));
        DateWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("birthday"));
        PosWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("position"));
        DepWorkerColumn.setCellValueFactory(new PropertyValueFactory<Worker, Long>("department"));
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

                    listDepartments = Factory.getInstance().getDepartmentDAO().getAllDepartments();
                    listDepartmentsString = new ArrayList<>();
                    for (Department p : listDepartments) {
                        System.out.println(p.getName());
                        listDepartmentsString.add(p.getName());
                    }
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

                    depAddWorker.setItems(FXCollections.observableArrayList(listDepartmentsString));

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
            listDepartmentsString = new ArrayList<>();
            for (Department p : listDepartments) {
                System.out.println(p.getName());
                listDepartmentsString.add(p.getName());
            }
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

            depAddWorker.setItems(FXCollections.observableArrayList(listDepartmentsString));
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

            depUpdateWorker.setItems(FXCollections.observableArrayList(listDepartmentsString));

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
                int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите изменить эту запись?", "Редактирование", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
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
            int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить эту запись?", "Удаление", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
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
            boolean addOrNot1 = true;
            //Поиск одинаковых записей
            for (Position p : listPositions) {
                if (p.getName().equals(textAddNamePos.getText())) {
                    addOrNot1 = false;
                }
            }
            if (addOrNot1 == false) {
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
                int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите изменить эту запись?", "Редактирование", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
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
            int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить эту запись?", "Удаление", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
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

        if (comboBenefit.getValue() != null) {
            int reply = JOptionPane.showConfirmDialog(null, "Вы действительно хотите удалить эту запись?", "Удаление", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
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
            boolean addOrNot1 = true;
            //Поиск одинаковых записей
            for (Benefit p : listBenefits) {
                if (p.getName().equals(textAddNameBenefit.getText().trim())) {
                    addOrNot1 = false;
                }
            }
            if (addOrNot1 == false) {
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

    public Long BtnSearchWorker() throws SQLException {
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
            Department department = new Department();
            department = listDepartments.get(listDepartmentsString.indexOf(depUpdateWorker.getValue()));
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

        for (int index = 0; index < listWorker.size(); index++) {
            worker = listWorker.get(index);
            System.out.println(listWorker.get(index).convertToListStrings());
            System.out.println("Тупой, сука!");

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
            if (listWorker.size() == 0) {
                break;
            }

        }

        listWorker = listSearchWorker;
        tableWorker.getItems().clear();
        tableWorker.setItems(listSearchWorker);
        checkUpdateGenderMan.setSelected(false);
        checkUpdateGenderWoman.setSelected(false);
        textUpdateSurWorker.setText("");
        textUpdateNameWorker.setText("");
        textUpdatePatWorker.setText("");
        dataUpdateWorker.setValue(null);
        depUpdateWorker.setValue(null);
        posUpdateWorker.setValue(null);
        benUpdateWorker.setValue(null);
        return worker.getId();
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
        depUpdateWorker.setValue(listDepartments.get(listDepartmentsString.indexOf(worker.getDepartment().getName())).getName());
        posUpdateWorker.setValue(worker.getPosition());
        benUpdateWorker.setValue(worker.getBenefit());
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
            Department department = new Department();
            department = listDepartments.get(listDepartmentsString.indexOf(depUpdateWorker.getValue()));
            worker.setDepartment(department);
        }
        if (benUpdateWorker.getValue().toString() != worker.getBenefit().getName()) {
            Benefit benefit = benUpdateWorker.getSelectionModel().getSelectedItem();
            worker.setBenefit(benefit);
        }
        if (posUpdateWorker.getValue().toString() != worker.getPosition().getName()) {
            Position position = posUpdateWorker.getSelectionModel().getSelectedItem();
            worker.setPosition(position);
        }
        if (dataUpdateWorker.getValue().toString() != worker.getBirthday().toString() && dataUpdateWorker.getValue() != null) {
            worker.setBirthday(dataUpdateWorker.getValue().toString().trim());
        }
        Gender gender = new Gender();
        gender.setId(SelectOneCheckBox(checkUpdateGenderMan, checkUpdateGenderWoman));
        worker.setGender(gender);
        System.out.println("SUR:" + worker.getSurname() + "PAT:"
            + worker.getPatronymic() + "NAM:" + worker.getName() + "DR:"
            + worker.getBirthday() + "BEN:" + worker.getBenefit()
            + "DEP:" + worker.getDepartment() + "GEN:" + worker.getGender());
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

        listWorker.clear();
        tableWorker.getItems().clear();
        listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
        tableWorker.setItems(listWorker);
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
        if (textAddSurWorker.getText().trim().length() > 4
            && textAddNameWorker.getText().trim().length() > 4
            && textAddPatWorker.getText().trim().length() > 4
            && dataAddWorker.getValue().toString().trim().length() > 4
            && depAddWorker.getValue() != null
            && posAddWorker.getValue() != null
            && benAddWorker.getValue() != null) {
            worker.setSurname(textAddSurWorker.getText().trim());
            worker.setName(textAddNameWorker.getText().trim());
            worker.setPatronymic(textAddPatWorker.getText().trim());
            Gender gender = new Gender();
            gender = Factory.getInstance().getGenderDAO().getGenderById(SelectOneCheckBox(checkAddGenderMan, checkAddGenderWoman));
            worker.setGender(gender);
            worker.setBirthday(dataAddWorker.getValue().toString());
            int number = listDepartmentsString.indexOf(depAddWorker.getValue().toString().trim());
            Department department = new Department();
            department = listDepartments.get(number);
            worker.setDepartment(department);

            position = posAddWorker.getSelectionModel().getSelectedItem();
            worker.setPosition(position);
            Benefit benefit = benAddWorker.getSelectionModel().getSelectedItem();
            worker.setBenefit(benefit);
            Factory.getInstance().getWorkerDAO().addWorker(worker);
            listWorker.clear();
            listWorker.addAll(Factory.getInstance().getWorkerDAO().getAllWorkers());
            tableWorker.setItems(listWorker);
        } else {
            JOptionPane.showMessageDialog(null, "Заполнены не все поля");
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
            Department department = new Department();
            department = listDepartments.get(listDepartmentsString.indexOf(depUpdateStudent.getValue()));
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
                if (searchStudent.getSurname().toString().equals(student.getSurname().toString())) {

                } else {
                    searchBool = false;
                }
            } else {
            }
            if (searchStudent.getName() != null && searchBool == true) {
                if (searchStudent.getName().toString().equals(student.getName().toString())) {

                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchStudent.getPatronymic() != null && searchBool == true) {
                if (student.getPatronymic().toString().equals(searchStudent.getPatronymic().toString())) {
                } else {
                    searchBool = false;
                }
            } else {

            }
            if (searchStudent.getBirthday() != null && searchBool == true) {
                if (student.getBirthday().toString().equals(searchStudent.getBirthday().toString())) {

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
        LocalDate date = LocalDate.parse(student.getBirthday().toString());
        dataUpdateStudent.setValue(date);
        depUpdateStudent.setValue(listDepartments.get(listDepartmentsString.indexOf(student.getDepartment().getName())).getName());
        groupUpdateStudent.setValue(student.getGroup());
        benUpdateStudent.setValue(student.getBenefit());
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
            Department department = new Department();
            department = listDepartments.get(listDepartmentsString.indexOf(depUpdateStudent.getValue()));
            student.setDepartment(department);
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
        /* System.out.println("SUR:" + worker.getSurname() + "PAT:"
         + worker.getPatronymic() + "NAM:" + worker.getName() + "DR:"
         + worker.getBirthday() + "BEN:" + worker.getBenefit()
         + "DEP:" + worker.getDepartment() + "GEN:" + worker.getGender());*/
        Factory.getInstance().getStudentDAO().updateStudent(student);

        textUpdateSurStudent.setText(null);
        textUpdateNameStudent.setText(null);
        textUpdatePatStudent.setText(null);
        dataUpdateStudent.setValue(null);
        checkUpdateGenderManStudent.setSelected(false);
        checkUpdateGenderWomanStudent.setSelected(false);
        depUpdateStudent.setValue(null);
        groupUpdateStudent.setValue(null);
        benUpdateStudent.setValue(null);

        listStudent.clear();
        tableStudent.getItems().clear();
        listStudent.addAll(Factory.getInstance().getStudentDAO().getAllStudents());
        tableStudent.setItems(listStudent);
    }

    public void BtnDeleteStudent(int number) throws SQLException {
        student = listStudent.get(number);
        Factory.getInstance().getStudentDAO().deleteStudent(student);
        listStudent.clear();
        listStudent.addAll(Factory.getInstance().getStudentDAO().getAllStudents());
        tableStudent.setItems(listStudent);
    }

    public void BtnDeleteStudent() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableStudent.getSelectionModel();
        student = listStudent.get(selectionModel.getFocusedIndex());
        Factory.getInstance().getStudentDAO().deleteStudent(student);
        listStudent.clear();
        listStudent.addAll(Factory.getInstance().getStudentDAO().getAllStudents());
        tableStudent.setItems(listStudent);
    }

    public void BtnAddStudent() throws SQLException {
        if (textAddSurStudent.getText().trim().length() > 4
            && textAddNameStudent.getText().trim().length() > 4
            && textAddPatStudent.getText().trim().length() > 4
            && dataAddStudent.getValue().toString().trim().length() > 4
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
            int number = listDepartmentsString.indexOf(depAddStudent.getValue().toString());
            Department department = new Department();
            department = listDepartments.get(number);
            student.setDepartment(department);
            group = groupAddStudent.getSelectionModel().getSelectedItem();
            student.setGroup(group);

            Benefit benefit = benAddStudent.getSelectionModel().getSelectedItem();
            student.setBenefit(benefit);
            Factory.getInstance().getStudentDAO().saveOnlyStudent(student);
            listStudent.clear();
            listStudent.addAll(Factory.getInstance().getStudentDAO().getAllStudents());
            tableStudent.setItems(listStudent);
            group = null;
            benefit = null;
            department = null;

        } else {
            JOptionPane.showMessageDialog(null, "Заполнены не все поля");

        }
    }

    public void SelectRowTableChild() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableChild.getSelectionModel();
        int number = 0/*= selectionModel.getFocusedIndex()*/;
        child = listChild.get(selectionModel.getFocusedIndex());
        for (int i = 0; i < listWorkersChild.size(); i++) {
            if (listWorkersChild.get(i).getId_child().equals(child.getId())) {
                number = i;
            }
        }
        textUpdateSurChild.setText(child.getSurname());
        textUpdateNameChild.setText(child.getName());
        textUpdatePatChild.setText(child.getPatronymic());
        textUpdateSurWorkChild.setText(Factory.getInstance().getWorkerDAO().getWorkerById(
            Factory.getInstance().
            getWorkersChildDAO().
            getWorkersChildById(
                listWorkersChild.get(number)
                .getId()
            ).getId_worker()
        ).getSurname()
        );
        textUpdateNameWorkChild.setText(Factory.getInstance().getWorkerDAO().getWorkerById(
            Factory.getInstance().
            getWorkersChildDAO().
            getWorkersChildById(
                listWorkersChild.get(number)
                .getId()
            ).getId_worker()
        ).getName());
        textUpdatePatWorkChild.setText(Factory.getInstance().getWorkerDAO().getWorkerById(
            Factory.getInstance().
            getWorkersChildDAO().
            getWorkersChildById(
                listWorkersChild.get(number)
                .getId()
            ).getId_worker()
        ).getPatronymic());

        LocalDate date = LocalDate.parse(child.getBirthday().toString());
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
        if (textAddSurChild.getText().trim().length() > 4
            && textAddNameChild.getText().trim().length() > 4
            && textAddPatChild.getText().trim().length() > 4
            && dataAddChild.getValue().toString().trim().length() > 4
            && textAddNameWorkChild.getText().trim().length() > 4
            && textAddPatWorkChild.getText().trim().length() > 4
            && textAddSurWorkChild.getText().trim().length() > 4) {
            child.setSurname(textAddSurChild.getText().trim());
            child.setName(textAddNameChild.getText().trim());
            child.setPatronymic(textAddPatChild.getText().trim());
            Gender gender = new Gender();
            gender = Factory.getInstance().getGenderDAO().getGenderById(SelectOneCheckBox(checkAddGenderChildMan, checkAddGenderChildWoman));
            child.setGender(gender);
            child.setBirthday(dataAddChild.getValue().toString().trim());
            System.out.println("Имя:" + child.getName()
                + "Фамилия:" + child.getSurname()
                + "Отчество:" + child.getPatronymic()
                + "Пол:" + child.getGender().getName());
            Factory.getInstance().getChildDAO().addChild(child);

            workersChild.setId_child(child.getId());

            Worker searchWorker = new Worker();
            searchWorker.setName(textAddNameWorkChild.getText().trim());
            searchWorker.setSurname(textAddSurWorkChild.getText().trim());
            searchWorker.setPatronymic(textAddPatWorkChild.getText().trim());
            System.out.println("По пизде 1");
            if (listWorker.size() == 1) {
                System.out.println("Первая приблуда");
                worker = listWorker.get(0);
                if (worker.getName().toString().equals(searchWorker.getName().toString())
                    && worker.getSurname().toString().equals(searchWorker.getSurname().toString())
                    && worker.getPatronymic().toString().equals(searchWorker.getPatronymic().toString())) {
                    workersChild.setId_worker(worker.getId());
                    Factory.getInstance().getWorkersChildDAO().addWorkersChild(workersChild);
                } else if (listWorker.size() > 1) {
                    for (int i = 0; i < listWorker.size(); i++) {
                        System.out.println("Цикл номер " + i);
                        worker = listWorker.get(i);
                        if (worker.getName().toString().equals(searchWorker.getName().toString())
                            && worker.getSurname().toString().equals(searchWorker.getSurname().toString())
                            && worker.getPatronymic().toString().equals(searchWorker.getPatronymic().toString())) {
                            workersChild.setId_child(worker.getId());
                        }
                        Factory.getInstance().getWorkersChildDAO().addWorkersChild(workersChild);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Такого родителя не существует");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Заполнены не все поля");
        }
    }

    public void BtnDeleteChild() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableChild.getSelectionModel();
        child = listChild.get(selectionModel.getFocusedIndex());
        Factory.getInstance().getChildDAO().deleteChildren(child);
        listChild.clear();
        tableChild.getItems().clear();
        listChild.addAll(Factory.getInstance().getStudentDAO().getAllStudents());
        tableChild.setItems(listChild);
    }

    public void BtnSearchChild() throws SQLException {

    }

    public void BtnUpdateChild() throws SQLException {
        TableView.TableViewSelectionModel selectionModel = tableChild.getSelectionModel();
        child = listChild.get(selectionModel.getFocusedIndex());
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
            if (worker.getName().toString().equals(searchWorker.getName().toString())
                && worker.getSurname().toString().equals(searchWorker.getSurname().toString())
                && worker.getPatronymic().toString().equals(searchWorker.getPatronymic().toString())) {
                workersChild.setId_worker(worker.getId());
                Factory.getInstance().getWorkersChildDAO().updateWorkersChild(workersChild);
            } else if (listWorker.size() > 1) {
                for (int i = 0; i < listWorker.size(); i++) {
                    System.out.println("Цикл номер " + i);
                    worker = listWorker.get(i);
                    if (worker.getName().toString().equals(searchWorker.getName().toString())
                        && worker.getSurname().toString().equals(searchWorker.getSurname().toString())
                        && worker.getPatronymic().toString().equals(searchWorker.getPatronymic().toString())) {
                        workersChild.setId_child(worker.getId());
                    }
                    Factory.getInstance().getWorkersChildDAO().updateWorkersChild(workersChild);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Такого родителя не существует");
            }
        }
    }
}
