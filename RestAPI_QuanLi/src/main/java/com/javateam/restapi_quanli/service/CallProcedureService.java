/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.service;

import com.javateam.restapi_quanli.dao.CallProcedureDAO;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TheKiet
 */
@Service("CallProcedureService")
public class CallProcedureService {

    @Autowired
    CallProcedureDAO procedureDAO;

    @Transactional
    public List getDoanhThuNgay(int id_branch, String date_from, String date_to) {
        return procedureDAO.getDoanhThuNgay(id_branch, date_from, date_to);
    }
    
    @Transactional
    public List getDoanhThuTuanThang(int id_branch, String date_from, String date_to) {
        return procedureDAO.getDoanhThuTuanThang(id_branch, date_from, date_to);
    }
    
     @Transactional
    public List getDoanhThuNam(int id_branch, String date_from, String date_to) {
        return procedureDAO.getDoanhThuNam(id_branch, date_from, date_to);
    }
    
    @Transactional
    public List getChiPhiNgay(int id_branch, String date_from, String date_to) {
        return procedureDAO.getChiPhiNgay(id_branch, date_from, date_to);
    }
    
    @Transactional
    public List getChiPhiTuanThang(int id_branch, String date_from, String date_to) {
        return procedureDAO.getChiPhiTuanThang(id_branch, date_from, date_to);
    }
    
     @Transactional
    public List getChiPhiNam(int id_branch, String date_from, String date_to) {
        return procedureDAO.getChiPhiNam(id_branch, date_from, date_to);
    }
    
         @Transactional
    public List getNewCustomer(int nam) {
        return procedureDAO.getNewCustomer(nam);
    }
    
    @Transactional
    public List getActivityCustomer(int search_all, String thang, String nam, String phone) {
        return procedureDAO.getActivityCustomer(search_all, thang, nam, phone);
    }
    
    @Transactional
    public List getDishesMonth(int id_branch, String thang, String nam) {
        return procedureDAO.getDishesMonth(id_branch, thang, nam);
    }
    
    @Transactional
    public List getDonHangNgay(int id_loai, String date_from, String date_to) {
        return procedureDAO.getDonHangNgay(id_loai, date_from, date_to);
    }
    
    @Transactional
    public List getDonHangTuanThang(int id_loai, String date_from, String date_to) {
        return procedureDAO.getDonHangTuanThang(id_loai, date_from, date_to);
    }
    
     @Transactional
    public List getDonHangNam(int id_loai, String date_from, String date_to) {
        return procedureDAO.getDonHangNam(id_loai, date_from, date_to);
    }
    
}
