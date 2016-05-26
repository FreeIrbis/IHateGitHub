package com.quasar.hibernateh2.dao.entity;

import java.io.Serializable;
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

    @Column(name = "age")
    private Long age;

    @Column(name = "birthday")
    private String birthday;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "id_gender")
    private Gender id_gender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class)
    @JoinColumn(name = "id_department")
    private Department id_department;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Benefit.class)
    @JoinColumn(name = "id_benefit")
    private Benefit id_benefit;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    @JoinColumn(name = "id_position")
    private Position id_position;

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

    public Long getAge() {
        return age;
    }

    public void setAge(Long l) {
        age = l;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String s) {
        name = s;
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
        return id_department;
    }

    public void setDepartment(Department i) {
        id_department = i;
    }

    public Position getPosition() {
        return id_position;
    }

    public void setPosition(Position i) {
        id_position = i;
    }

    public Benefit getBenefit() {
        return id_benefit;
    }

    public void setBenefit(Benefit i) {
        id_benefit = i;
    }

    public Gender getGender() {
        return id_gender;
    }

    public void setGender(Gender i) {
        id_gender = i;
    }
}
