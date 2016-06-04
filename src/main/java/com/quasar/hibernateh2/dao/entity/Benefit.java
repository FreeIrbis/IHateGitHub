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
@Table(name = "benefit")
public class Benefit extends Model implements Serializable {

   private static final long serialVersionUID = 1947601617629593245L;

    @OneToMany(mappedBy = "benefit")
    private Set<Student> students;

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }
    
    @OneToMany(mappedBy = "benefit")
    private Set<Worker> workers;
    
    @Column(name = "name")
    private String name;

    public Benefit() {
    }

    public Benefit(Benefit s) {
        this.students = new HashSet<>();
        name = s.getName();
    }
    
    public String getName() {
        return name;
    }
   
    public void setName(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return getName();
    }
}
