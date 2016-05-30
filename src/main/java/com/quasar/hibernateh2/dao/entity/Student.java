package com.quasar.hibernateh2.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student extends Model implements ExelModel, Serializable {

    private static final long serialVersionUID = 1990501617629593245L;

    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;
     
    @Column(name = "patronymic")
    private String patronymic;
    
    // System.out.println(new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(test[9]).getTime()));
    @Column(name = "birthday")
    @Temporal(value = TemporalType.DATE)
    private Date birthday;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "id_gender")
    private Gender id_gender;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Groups.class)
    @JoinColumn(name = "id_group")
    private Groups id_group;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Benefit.class)
    @JoinColumn(name = "id_benefit")
    private Benefit id_benefit;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Branch.class)
    @JoinColumn(name = "id_branch")
    private Branch id_branch;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    private Role role;

    public Student() {
        name = null;
    }

    public Student(Student s) {
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
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date date) {
        birthday = date;
    }
    
    public Gender getGender() {
        return id_gender;
    }

    public void setGender(Gender i) {
        id_gender = i;
    }
    
    public Groups getGroups() {
        return id_group;
    }
     
    public void setGroups(Groups i) {
        id_group = i;
    }
    
    public Benefit getBenefit() {
        return id_benefit;
    }
       
     public void setBenefit(Benefit i) {
        id_benefit = i;
    }
        
    public Branch getBranch() {
        return id_branch;
    }

    public void setBranch(Branch i) {
        id_branch = i;
    }
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public List<String> convertToListStrings() {
        List<String> list = new ArrayList<>();
        list.add(name);
        list.add(surname);
        list.add(patronymic);
        list.add(birthday.toString());
        list.add(id_gender.getName());
        list.add(id_benefit.getName());
        list.add(id_branch.getName());
        list.add(id_group.getName());
        return list;
    }
}
