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
@Table(name = "monan")
public class MonAn {
    /*
    `ID` int(11) NOT NULL AUTO_INCREMENT,
    `Ten` varchar(100) DEFAULT NULL,
    `Gia` int(11) DEFAULT NULL,
    `HinhAnh` VARCHAR(300) DEFAULT NULL,
    `ThongTin` varchar(300) DEFAULT NULL,
    `ID_DanhMuc` int(11) DEFAULT NULL,
     */
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name = "Ten")
    private String Ten;
    @Column(name = "Gia")
    private String Gia;
    @Column(name = "HinhAnh")
    private String HinhAnh;
    @Column(name = "ThongTin")
    private String ThongTin;
    @Column(name = "ID_DanhMuc")
    private int ID_DanhMuc;

    public MonAn(int ID, String Ten, String Gia, String HinhAnh, String ThongTin, int ID_DanhMuc) {
        this.ID = ID;
        this.Ten = Ten;
        this.Gia = Gia;
        this.HinhAnh = HinhAnh;
        this.ThongTin = ThongTin;
        this.ID_DanhMuc = ID_DanhMuc;
    }

    
    
    public MonAn() {
    }

    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getThongTin() {
        return ThongTin;
    }

    public void setThongTin(String ThongTin) {
        this.ThongTin = ThongTin;
    }

    public int getID_DanhMuc() {
        return ID_DanhMuc;
    }

    public void setID_DanhMuc(int ID_DanhMuc) {
        this.ID_DanhMuc = ID_DanhMuc;
    }
    
    
}
