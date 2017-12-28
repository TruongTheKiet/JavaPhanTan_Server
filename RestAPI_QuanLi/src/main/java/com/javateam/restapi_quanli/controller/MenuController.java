/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.controller;

import com.javateam.restapi_quanli.model.Menu;
import com.javateam.restapi_quanli.model.MonAn;
import com.javateam.restapi_quanli.service.MenuService;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TheKiet
 */
@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/getAllMenu", produces = "application/json;charset=UTF-8", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getAllMenu() {

        List listofChiNhanh = menuService.getAllMemu();
        return listofChiNhanh;
    }

    @RequestMapping(value = "/getMenu/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8", headers = "Accept=application/json")
    public Menu getMenuByID(@PathVariable int id) {
        return menuService.getMemuByID(id);
    }

    @RequestMapping(value = "/getMenu/Search/{name}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8", headers = "Accept=application/json")
    public List getMenuByID(@PathVariable String name) {
        String name1 = name;
        return menuService.getMemuByName(name);
    }

    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    public void addMenu(@RequestBody Object data) {
       LinkedHashMap map = (LinkedHashMap) data;
       String list_id_monan = (String)map.get("list_id_monan");
       int id_branch = (int)map.get("id_branch");
        String[] id_monans = list_id_monan.split(",");
        for (int i = 0; i < id_monans.length; i++) {
            menuService.addMemu(new Menu(0,id_branch, Integer.parseInt(id_monans[i])));
        }
    }

    @RequestMapping(value = "/updateMenu", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateMenu(@RequestBody Menu menu) {
        menuService.updateMemu(menu);
    }

    @RequestMapping(value = "/deleteMenu/{id_branch}/{list_id_monan", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteMenu(@PathVariable("id_branch") int id_branch, @PathVariable("list_id_monan") String list_id_monan) {
        String[] id_monans = list_id_monan.split(",");
        for (int i = 0; i < id_monans.length; i++) {
            menuService.deleteMenuByIDBranchIDMonAn(id_branch, Integer.parseInt(id_monans[i]));
        }
    }
}
