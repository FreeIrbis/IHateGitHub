package com.quasar.hibernateh2.dao.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Irbis
 */
@Entity
@Table(name = "workers_child")
public class WorkersChild extends Model implements Serializable {
    
    @Column(name = "id_worker")
    private int id_worker;
    
    @Column(name = "id_child")
    private int id_child;
    
    public int getWorker() {
        return id_worker;
    }
     
    public void setWorker(int i) {
        id_worker = i;
    }
    
    public int getChild() {
        return id_child;
    }
       
     public void setChild(int i) {
        id_child = i;
    }
}
