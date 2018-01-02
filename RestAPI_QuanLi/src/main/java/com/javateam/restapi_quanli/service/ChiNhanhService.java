/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.service;

import com.javateam.restapi_quanli.dao.ChiNhanhDAO;
import com.javateam.restapi_quanli.model.ChiNhanh;
import com.javateam.restapi_quanli.model.DanhMucMonAn;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TheKiet
 */
@Service("ChiNhanhService")
public class ChiNhanhService {

    @Autowired
    ChiNhanhDAO chinhanhDAO;

    @Transactional
    public List getAllChiNhanh() {
        return chinhanhDAO.getAllChiNhanh();
    }

    @Transactional
    public ChiNhanh getChiNhanhByID(int id) {
        return chinhanhDAO.getChiNhanhByID(id);
    }

    @Transactional
    public ChiNhanh addChiNhanh(ChiNhanh chinhanh) {
       return chinhanhDAO.addChiNhanh(chinhanh);

    }

    @Transactional
    public void updateChiNhanh(ChiNhanh chinhanh) {
        chinhanhDAO.updateChiNhanh(chinhanh);

    }

    @Transactional
    public void deleteChiNhanhByID(int id) {
        chinhanhDAO.deleteChiNhanhByID(id);
    }
    
     @Transactional
    public List getChiNhanhByName(String name) {
        return chinhanhDAO.getChiNhanhByName(name);
    }
}
