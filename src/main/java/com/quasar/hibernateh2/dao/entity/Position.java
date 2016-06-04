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
@Table(name = "position")
public class Position extends Model implements Serializable {

    private static final long serialVersionUID = 1990501617629593245L;

    @OneToMany(mappedBy = "position")
    private Set<Worker> workers;

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }
    
    @Column(name = "name")
    private String name;
    
    public Position() {
        name = null;
    }
    public Position(String name) {
        this.name = name;
    }
    

    public Position(Position s) {
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