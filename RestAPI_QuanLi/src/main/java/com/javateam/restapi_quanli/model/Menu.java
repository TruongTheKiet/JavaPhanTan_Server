/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TheKiet
 */
@Entity
@Table(name = "menu")
public class Menu {
    /*`ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ChiNhanh` int(11) DEFAULT NULL,
  `ID_MonAn` int(11) DEFAULT NULL,*/
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name = "ID_ChiNhanh")
    private int ID_ChiNhanh;
    @Column(name = "ID_MonAn")
    private String ID_MonAn;

    public Menu() {
    }

    public Menu(int ID, int ID_ChiNhanh, String ID_MonAn) {
        this.ID = ID;
        this.ID_ChiNhanh = ID_ChiNhanh;
        this.ID_MonAn = ID_MonAn;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_ChiNhanh() {
        return ID_ChiNhanh;
    }

    public void setID_ChiNhanh(int ID_ChiNhanh) {
        this.ID_ChiNhanh = ID_ChiNhanh;
    }

    public String getID_MonAn() {
        return ID_MonAn;
    }

    public void setID_MonAn(String ID_MonAn) {
        this.ID_MonAn = ID_MonAn;
    }
    
    
}
