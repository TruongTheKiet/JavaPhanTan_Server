/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.service;

import com.javateam.restapi_quanli.dao.MonAnDAO;
import com.javateam.restapi_quanli.model.MonAn;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TheKiet
 */
@Service("MonAnService")
public class MonAnService {
     @Autowired
    MonAnDAO monanDAO;

    @Transactional
    public List getAllMonAn() {
        return monanDAO.getAllMonAn();
    }

    @Transactional
    public MonAn getMonAnByID(int id) {
        return monanDAO.getMonAnByID(id);
    }

    @Transactional
    public MonAn addMonAn(MonAn monan) {
       return monanDAO.addMonAn(monan);

    }

    @Transactional
    public void updateMonAn(MonAn monan) {
        monanDAO.updateMonAn(monan);

    }

    @Transactional
    public void deleteMonAnByID(int id) {
        monanDAO.deleteMonAnByID(id);
    }
    
     @Transactional
    public List getMonAnByName(String name) {
        return monanDAO.getMonAnByName(name);
    }
}
