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
    
    @RequestMapping(value = "/getDoanhThuNam", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json")
    public List getDoanhThuNam(@RequestBody Object data) {

        LinkedHashMap map = (LinkedHashMap) data;
        String date_from = (String) map.get("date_from");
        String date_to = (String) map.get("date_to");
        int id_branch = Integer.parseInt(map.get("id_branch").toString());
        
        List result = procedureService.getDoanhThuNam(id_branch, date_from, date_to);
        return result;
    }
    
    /*Chi phí*/
    
    @RequestMapping(value = "/getChiPhiNam", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json")
    public List getChiPhiNam(@RequestBody Object data) {

        LinkedHashMap map = (LinkedHashMap) data;
        String date_from = (String) map.get("date_from");
        String date_to = (String) map.get("date_to");
        int id_branch = Integer.parseInt(map.get("id_branch").toString());
        
        List result = procedureService.getChiPhiNam(id_branch, date_from, date_to);
        return result;
    }
    
    @RequestMapping(value = "/getChiPhiNgay", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json")
    public List getChiPhiNgay(@RequestBody Object data) {

        LinkedHashMap map = (LinkedHashMap) data;
        String date_from = (String) map.get("date_from");
        String date_to = (String) map.get("date_to");
        int id_branch = Integer.parseInt(map.get("id_branch").toString());
        
        List result = procedureService.getChiPhiNgay(id_branch, date_from, date_to);
        return result;
    }
    
    @RequestMapping(value = "/getChiPhiTuanThang", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json")
    public List getChiPhiTuanThang(@RequestBody Object data) {

        LinkedHashMap map = (LinkedHashMap) data;
        String date_from = (String) map.get("date_from");
        String date_to = (String) map.get("date_to");
        int id_branch = Integer.parseInt(map.get("id_branch").toString());
        
        List result = procedureService.getChiPhiTuanThang(id_branch, date_from, date_to);
        return result;
    }
    
    @RequestMapping(value = "/getNewCustomer/{nam}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getNewCustomer(@PathVariable int nam) {
        List result = procedureService.getNewCustomer(nam);
        return result;
    }
    @RequestMapping(value = "/getActivityCustomer", method = RequestMethod.POST)
    public List getActivityCustomer(@RequestBody Object data) 
    {
        LinkedHashMap map = (LinkedHashMap) data;
        String thang = (String) map.get("thang");
        String nam = (String) map.get("nam");
        String phone = (String)map.get("phone");
        int search_all = Integer.parseInt(map.get("search_all").toString());
        List result = procedureService.getActivityCustomer(search_all, thang, nam, phone);
        return result;
    }
    
        @RequestMapping(value = "/getDishesMonth/{id_branch}/{thang}/{nam}", produces = "application/json;charset=UTF-8", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getDishesMonth(@PathVariable String thang, @PathVariable String nam, @PathVariable int id_branch) 
    {
        List result = procedureService.getDishesMonth(id_branch, thang, nam);
        return result;
    }
    
    
    /*DonHang*/
     @RequestMapping(value = "/getDonHangNam", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json")
    public List getDonHangNam(@RequestBody Object data) {

        LinkedHashMap map = (LinkedHashMap) data;
        String date_from = (String) map.get("date_from");
        String date_to = (String) map.get("date_to");
        int id_loai = Integer.parseInt(map.get("id_loai").toString());
        
        List result = procedureService.getDonHangNam(id_loai, date_from, date_to);
        return result;
    }
    
    @RequestMapping(value = "/getDonHangNgay", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json")
    public List getDonHangNgay(@RequestBody Object data) {

        LinkedHashMap map = (LinkedHashMap) data;
        String date_from = (String) map.get("date_from");
        String date_to = (String) map.get("date_to");
        int id_loai = Integer.parseInt(map.get("id_loai").toString());
        
        List result = procedureService.getDonHangNgay(id_loai, date_from, date_to);
        return result;
    }
    
    @RequestMapping(value = "/getDonHangTuanThang", produces = "application/json;charset=UTF-8", method = RequestMethod.POST, headers = "Accept=application/json")
    public List getDonHangTuanThang(@RequestBody Object data) {

        LinkedHashMap map = (LinkedHashMap) data;
        String date_from = (String) map.get("date_from");
        String date_to = (String) map.get("date_to");
        int id_loai = Integer.parseInt(map.get("id_loai").toString());
        
        List result = procedureService.getDonHangTuanThang(id_loai, date_from, date_to);
        return result;
    }
}
