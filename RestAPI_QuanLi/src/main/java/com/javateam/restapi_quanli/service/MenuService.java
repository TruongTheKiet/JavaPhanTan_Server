/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.service;

import com.javateam.restapi_quanli.dao.MenuDAO;
import com.javateam.restapi_quanli.model.Menu;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TheKiet
 */
@Service("MenuService")
public class MenuService {
    @Autowired
    MenuDAO menuDAO;

    @Transactional
    public List getAllMemu() {
        return menuDAO.getAllMenu();
    }

    @Transactional
    public Menu getMemuByID(int id) {
        return menuDAO.getMenuByID(id);
    }

    @Transactional
    public Menu addMemu(Menu menu) {
       return menuDAO.addMenu(menu);

    }

    @Transactional
    public void updateMemu(Menu menu) {
        menuDAO.updateMenu(menu);

    }

    @Transactional
    public void deleteMenuByIDBranchIDMonAn(int id_branch, int id_monan) {
        menuDAO.deleteMenuByIDBranchIDMonAn(id_branch, id_monan);
    }
    
     @Transactional
    public List getMemuByName(String name) {
        return menuDAO.getMenuByName(name);
    }
     @Transactional
    public List getMenuByIDBranch(int id_branch) {
        return menuDAO.getMenuByIDBranch(id_branch);
    }
    
}
