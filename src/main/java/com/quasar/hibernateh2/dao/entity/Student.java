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
    @JoinColumn(name = "gender")
    private Gender gender;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Groups.class)
    @JoinColumn(name = "group")
    private Groups group;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Benefit.class)
    @JoinColumn(name = "benefit")
    private Benefit benefit;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Branch.class)
    @JoinColumn(name = "branch")
    private Branch branch;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    private Role role;
    
    @Column(name = "phone")
    private String phone;

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name = "email")
    private String email;

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
        return gender;
    }

    public void setGender(Gender i) {
        gender = i;
    }
    
    public Groups getGroups() {
        return group;
    }
     
    public void setGroups(Groups i) {
        group = i;
    }
    
    public Benefit getBenefit() {
        return benefit;
    }
       
     public void setBenefit(Benefit i) {
        benefit = i;
    }
        
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch i) {
        branch = i;
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
        list.add(gender.getName());
        list.add(benefit.getName());
        list.add(branch.getName());
        list.add(group.getName());
        return list;
    }
}
