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
@Table(name = "chinhanh")
public class ChiNhanh {

    /*`ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` nvarchar(100) DEFAULT NULL,
  `DiaChi` nvarchar(100) DEFAULT NULL,
  `SDT` varchar(15) DEFAULT NULL,
  `TinhThanh` varchar(100) DEFAULT NULL,
  `SoLuongBan` int(11) DEFAULT NULL,
  `ID_QuanLy` int(11) DEFAULT NULL,F*/
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name = "Ten")
    private String Ten;
    @Column(name = "DiaChi")
    private String DiaChi;
    @Column(name = "SDT")
    private String SDT;
    @Column(name = "TinhThanh")
    private String TinhThanh;
    @Column(name = "SoluongBan")
    private int SoLuongBan;
    @Column(name = "ID_QuanLy")
    private int ID_QuanLy;
    
    /*contrctor*/

    public ChiNhanh() {
        super();
    }

    public ChiNhanh(int ID, String Ten, String DiaChi, String SDT, String TinhThanh, int SoLuongBan, int ID_QuanLy) {
        super();
        this.ID = ID;
        this.Ten = Ten;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TinhThanh = TinhThanh;
        this.SoLuongBan = SoLuongBan;
        this.ID_QuanLy = ID_QuanLy;
    }
    /*getter, setter*/

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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTinhThanh() {
        return TinhThanh;
    }

    public void setTinhThanh(String TinhThanh) {
        this.TinhThanh = TinhThanh;
    }

    public int getSoLuongBan() {
        return SoLuongBan;
    }

    public void setSoLuongBan(int SoLuongBan) {
        this.SoLuongBan = SoLuongBan;
    }

    public int getID_QuanLy() {
        return ID_QuanLy;
    }

    public void setID_QuanLy(int ID_QuanLy) {
        try{
        this.ID_QuanLy = ID_QuanLy;
        }
        catch(Exception e){
            this.ID_QuanLy = -1;
        }
    }
    
}
