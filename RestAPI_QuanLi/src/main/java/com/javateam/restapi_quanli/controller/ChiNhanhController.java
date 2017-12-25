/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.controller;

import com.javateam.restapi_quanli.model.ChiNhanh;
import com.javateam.restapi_quanli.model.DanhMucMonAn;
import com.javateam.restapi_quanli.service.ChiNhanhService;
import java.util.List;
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
public class ChiNhanhController {

    @Autowired
    ChiNhanhService chinhanhService;

    @RequestMapping(value = "/getAllChiNhanh",produces = "application/json;charset=UTF-8", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getAllChiNhanh() {

        List listofChiNhanh = chinhanhService.getAllChiNhanh();
        return listofChiNhanh;
    }

    @RequestMapping(value = "/getChiNhanh/{id}", method = RequestMethod.GET,produces = "application/json;charset=UTF-8", headers = "Accept=application/json")
    public ChiNhanh getChiNhanhByID(@PathVariable int id) {
        return chinhanhService.getChiNhanhByID(id);
    }

    @RequestMapping(value = "/getChiNhanh/Search/{name}", method = RequestMethod.GET,produces = "application/json;charset=UTF-8", headers = "Accept=application/json")
    public List getChiNhanhByID(@PathVariable String name) {
        String name1 = name;
        return chinhanhService.getChiNhanhByName(name);
    }
    
    @RequestMapping(value = "/addChiNhanh", method = RequestMethod.POST, headers = "Accept=application/json")
    public ChiNhanh addChiNhanh(@RequestBody ChiNhanh chinhanh) {
        ChiNhanh tmp =  chinhanhService.addChiNhanh(chinhanh);
        return tmp;
    }

    @RequestMapping(value = "/updateChiNhanh", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateChiNhanh(@RequestBody ChiNhanh chinhanh) {
        chinhanhService.updateChiNhanh(chinhanh);
    }

    @RequestMapping(value = "/deleteChiNhanh/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteChiNhanh(@PathVariable("id") int id) {
        chinhanhService.deleteChiNhanhByID(id);
    }
}
