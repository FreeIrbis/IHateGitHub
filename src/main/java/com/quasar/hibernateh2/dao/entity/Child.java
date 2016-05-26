package com.quasar.hibernateh2.dao.entity;

/**
 *
 * @author Irbis
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "children")
public class Child extends Model implements Serializable {

    private static final long serialVersionUID = 1990501617629593245L;

    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;
     
    @Column(name = "patronymic")
    private String patronymic;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Column(name = "birthday")
    private String birthday;
    
    @Column(name = "gender")
    private String gender;
    
    public Child() {
        name = null;
    }

    public Child(Child s) {
        name = s.getName();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String s) {
        name = s;
    }

     public String getBirthday() {
        return birthday;
    }
    
    public void setBirthday(String s) {
        birthday = s;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String s) {
        gender = s;
    }

}
