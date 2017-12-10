package com.javateam.restapi_quanli.controller;

import com.javateam.restapi_quanli.model.DanhMucMonAn;
import com.javateam.restapi_quanli.service.DanhMucMonAnService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TheKiet
 */
@RestController
public class DanhMucMonAnController {

    @Autowired
    DanhMucMonAnService danhmucmonanService;

    @RequestMapping(value = "/getAllDanhMuc", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getDanhMucMonAn() {

        List listOfCountries = danhmucmonanService.getAllDanhMucMonAn();
        return listOfCountries;
    }

    @RequestMapping(value = "/getDanhMuc/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public DanhMucMonAn getDanhMucMonAnById(@PathVariable int id) {
        return danhmucmonanService.getDanhMucMonAn(id);
    }

    @RequestMapping(value = "/addDanhMuc", method = RequestMethod.POST, headers = "Accept=application/json")
    public void addDanhMucMonAn(@RequestBody DanhMucMonAn danhmucmonan) {
        danhmucmonanService.addDanhMucMonAn(danhmucmonan);

    }

    @RequestMapping(value = "/updateDanhMuc", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateDanhMucMonAn(@RequestBody DanhMucMonAn danhmucmonan) {
        danhmucmonanService.updateDanhMucMonAn(danhmucmonan);
    }

    @RequestMapping(value = "/deleteDanhMuc/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteDanhMucMonAn(@PathVariable("id") int id) {
        danhmucmonanService.deleteDanhMucMonAn(id);
    }

}
