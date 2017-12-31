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
}
