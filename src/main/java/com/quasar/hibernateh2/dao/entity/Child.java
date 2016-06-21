package com.quasar.hibernateh2.dao.entity;

/**
 *
 * @author Irbis
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "children")
public class Child extends Model implements ExelModel,Serializable {

    private static final long serialVersionUID = 1990501617629593245L;

    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;
     
    @Column(name = "patronymic")
    private String patronymic;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "children")
    private Set<Worker> workers = new HashSet<>();

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
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "gender")
    private Gender gender;
    
    public Child() {
        name = null;
    }

    public Child(Child s) {
        name = s.getName();
    }
    
    public Child(String name) {
        this.name = name;
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
    
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender s) {
        gender = s;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public List<String> convertToListStrings() {
        List<String> list = new ArrayList<>();
        list.add(name);
        list.add(surname);
        list.add(patronymic);
        list.add(birthday);
        list.add(gender.getName());
        return list;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.surname);
        hash = 47 * hash + Objects.hashCode(this.patronymic);
        hash = 47 * hash + Objects.hashCode(this.birthday);
        hash = 47 * hash + Objects.hashCode(this.gender);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Child other = (Child) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.patronymic, other.patronymic)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        return true;
    }

}
