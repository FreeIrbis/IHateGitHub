package com.quasar.hibernateh2.dao.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Irbis
 */
@Entity
@Table(name = "branch")
public class Branch extends Model implements Serializable {

    private static final long serialVersionUID = 1990501617629593245L;

     @OneToMany(mappedBy = "branch")
    private Set<Student> students = new HashSet<>();

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Student> getStudents() {
        return students;
    }
     
    @Column(name = "name")
    private String name;

    public Branch() {
        name = null;
    }

    public Branch(Branch s) {
        name = s.getName();
    }
    
    public String getName() {
        return name;
    }
    
   
    public void setName(String s) {
        name = s;
    }
}