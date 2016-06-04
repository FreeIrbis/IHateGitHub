package com.quasar.hibernateh2.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Irbis
 */
@Entity
@Table(name = "worker")
public class Worker extends Model implements Serializable {

    private static final long serialVersionUID = 1573501611425593245L;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private String birthday;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "gender")
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class)
    @JoinColumn(name = "department")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Benefit.class)
    @JoinColumn(name = "benefit")
    private Benefit benefit;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    @JoinColumn(name = "position")
    private Position position;

    public Worker() {
        name = null;
    }

    public Worker(Worker s) {
        name = s.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String s) {
        surname = s;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String s) {
        patronymic = s;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String s) {
        birthday = s;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department i) {
        department = i;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position i) {
        position = i;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit i) {
        benefit = i;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender i) {
        gender = i;
    }
    
    
    public List<String> convertToListStrings() {
        List<String> list = new ArrayList<>();
        if(name==null){System.out.println("null");}else{list.add(name);}
        if(surname==null){System.out.println("null");}else{list.add(surname);}
        if(patronymic==null){System.out.println("null");}else{list.add(patronymic);}
        if(birthday.toString()==null){System.out.println("null");}else{list.add(birthday.toString());}
        if(gender.getName()==null){System.out.println("null");}else{list.add(gender.getName());}
        if(benefit.getName()==null){System.out.println("null");}else{list.add(benefit.getName());}
        if(department.getName()==null){System.out.println("null");}else{list.add(department.getName());}
        /*list.add(surname);
        list.add(patronymic);
        list.add(birthday.toString());
        list.add(gender.getName());
        list.add(benefit.getName());
        list.add(department.getName());*/
        return list;
    }
}
