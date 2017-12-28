/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.controller;

import com.javateam.restapi_quanli.model.MonAn;
import com.javateam.restapi_quanli.service.MonAnService;
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
public class MonAnController {
    @Autowired
    MonAnService monanService;

    @RequestMapping(value = "/getAllMonAn",produces = "application/json;charset=UTF-8", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getAllMonAn() {

        List listofChiNhanh = monanService.getAllMonAn();
        return listofChiNhanh;
    }

    @RequestMapping(value = "/getMonAn/{id}", method = RequestMethod.GET,produces = "application/json;charset=UTF-8", headers = "Accept=application/json")
    public MonAn getMonAnByID(@PathVariable int id) {
        return monanService.getMonAnByID(id);
    }

    @RequestMapping(value = "/getMonAn/Search/{name}", method = RequestMethod.GET,produces = "application/json;charset=UTF-8", headers = "Accept=application/json")
    public List getMonAnByID(@PathVariable String name) {
        String name1 = name;
        return monanService.getMonAnByName(name);
    }
    
    @RequestMapping(value = "/addMonAn", method = RequestMethod.POST)
    public MonAn addMonAn(@RequestBody MonAn monan) {
        MonAn tmp =  monanService.addMonAn(monan);
        return tmp;
    }

    @RequestMapping(value = "/updateMonAn", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateMonAn(@RequestBody MonAn monan) {
        monanService.updateMonAn(monan);
    }

    @RequestMapping(value = "/deleteMonAn/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteMonAn(@PathVariable("id") int id) {
        monanService.deleteMonAnByID(id);
    }
}
