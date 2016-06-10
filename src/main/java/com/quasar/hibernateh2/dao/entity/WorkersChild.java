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
    private Long id_worker;
    
    @Column(name = "id_child")
    private Long id_child;

    public Long getId_worker() {
        return id_worker;
    }

    public void setId_worker(Long id_worker) {
        this.id_worker = id_worker;
    }

    public Long getId_child() {
        return id_child;
    }

    public void setId_child(Long id_child) {
        this.id_child = id_child;
    }
    
    
}
