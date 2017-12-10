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

/*

  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TenDanhMuc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
*/
@Entity
@Table(name="danhmucmonan")
public class DanhMucMonAn {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "TenDanhMuc")
    private String TenDanhMuc;
    
    
    public DanhMucMonAn() {
        super();
    }
    public DanhMucMonAn(int _id, String _tendanhmuc) {
        super();
        this.ID = _id;
        this.TenDanhMuc = _tendanhmuc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }
   
    
}
