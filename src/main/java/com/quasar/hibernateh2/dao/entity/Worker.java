package com.quasar.hibernateh2.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Irbis
 */
@Entity
@Table(name = "worker")
public class Worker extends Model implements ExelModel,Serializable {

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
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Branch.class)
    @JoinColumn(name = "branch")
    private Branch branch;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "children_of_workers",
            joinColumns = {@JoinColumn(name="worker_id")},
            inverseJoinColumns = {@JoinColumn(name="child_id")})
    private Set<Child> children = new HashSet<>();

    public Worker() {
        name = null;
    }

    public Worker(Worker s) {
        name = s.getName();
    }
    
    public Worker(String name) {
        this.name = name;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
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

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }
    
    @Override
    public String toString() {
        return getId().toString() + " " + getSurname() + " " + getName();
    }

    @Override
    public List<String> convertToListStrings() {
        List<String> list = new ArrayList<>();
            list.add(name);
            list.add(surname);
            list.add(patronymic);
            list.add(birthday);
            list.add(gender.getName());
            list.add(position.getName());
            list.add(benefit.getName());
            list.add(department.getName());
            list.add(branch.getName());

        return list;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.surname);
        hash = 67 * hash + Objects.hashCode(this.patronymic);
        hash = 67 * hash + Objects.hashCode(this.birthday);
        hash = 67 * hash + Objects.hashCode(this.gender);
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
        final Worker other = (Worker) obj;
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
