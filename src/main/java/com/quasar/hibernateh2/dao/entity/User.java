/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "user")
public class User extends Model implements Serializable{
    
    @Column(name = "loginUser")
    private String loginUser;
    
    @Column(name = "passUser")
    private String passUser;
    
    @Column(name = "passDB")
    private String passDB;
    
    @Column(name = "loginDB")
    private String loginDB;
    
    @Column(name = "linkDB")
    private String linkDB;
    
    @Column(name = "nameDB")
    private String nameDB;
    
    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public String getPassDB() {
        return passDB;
    }

    public void setPassDB(String passDB) {
        this.passDB = passDB;
    }

    public String getLoginDB() {
        return loginDB;
    }

    public void setLoginDB(String loginDB) {
        this.loginDB = loginDB;
    }

    public String getLinkDB() {
        return linkDB;
    }

    public void setLinkDB(String linkDB) {
        this.linkDB = linkDB;
    }

    public String getNameDB() {
        return nameDB;
    }

    public void setNameDB(String nameDB) {
        this.nameDB = nameDB;
    }
    
    
}
