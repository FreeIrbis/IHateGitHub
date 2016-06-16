package com.quasar.hibernateh2.dao.entity;

import java.io.Serializable;
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
    private Set<Worker> workers;

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
     
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return getName();
    }

    public Branch() {
        this.name = null;
    }
    
    public Branch(String name) {
        this.name = null;
    }

    public Branch(Branch s) {
        this.name = s.getName();
    }
    
    public String getName() {
        return name;
    }
    
   
    public void setName(String s) {
        name = s;
    }
}