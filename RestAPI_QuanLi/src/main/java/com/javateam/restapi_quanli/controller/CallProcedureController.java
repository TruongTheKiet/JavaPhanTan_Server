/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.controller;

import com.javateam.restapi_quanli.service.CallProcedureService;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TheKiet
 */
@RestController
public class CallProcedureController {

    @Autowired
    CallProcedureService procedureService;

    @RequestMapping(value = "/getDoanhThuNgay", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json")
    public List getDanhThuNgay(@RequestBody Object data) {

        LinkedHashMap map = (LinkedHashMap) data;
        String date_from = (String) map.get("date_from");
        String date_to = (String) map.get("date_to");
        int id_branch = Integer.parseInt(map.get("id_branch").toString());
        
        List result = procedureService.getDoanhThuNgay(id_branch, date_from, date_to);
        return result;
    }
    
    @RequestMapping(value = "/getDoanhThuTuanThang", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json")
    public List getDoanhThuTuanThang(@RequestBody Object data) {

        LinkedHashMap map = (LinkedHashMap) data;
        String date_from = (String) map.get("date_from");
        String date_to = (String) map.get("date_to");
        int id_branch = Integer.parseInt(map.get("id_branch").toString());
        
        List result = procedureService.getDoanhThuTuanThang(id_branch, date_from, date_to);
        return result;
    }
}
