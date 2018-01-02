/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.dao;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.ParameterMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TheKiet
 */
@Repository
public class CallProcedureDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List getDoanhThuNgay(int id_branch, String date_from, String date_to) {
        Session session = this.sessionFactory.getCurrentSession();
//        String hql = "call sp_DoanhThuDay(:id_branch,:date_order)";
//        Query query = session.createQuery(hql)
//                .setParameter("id_branch", id_branch)
//                .setString("date_order", date_order);
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_DoanhThuDay");
        procedureCall.registerParameter("id_branch", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("date_from", String.class, ParameterMode.IN);
        procedureCall.registerParameter("date_to", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_branch").bindValue(id_branch);
        procedureCall.getParameterRegistration("date_from").bindValue(date_from);
        procedureCall.getParameterRegistration("date_to").bindValue(date_to);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id_order", objects[0]);
            item.put("time", objects[1]);
            item.put("branch_name", objects[2]);
            item.put("total", objects[3]);
            item.put("stt", objects[4]);
            item.put("type_order", objects[5]);
            map.add(item);
        }
        return map;

    }

    public List getDoanhThuTuanThang(int id_branch, String date_from, String date_to) {
        Session session = this.sessionFactory.getCurrentSession();
//        String hql = "call sp_DoanhThuDay(:id_branch,:date_order)";
//        Query query = session.createQuery(hql)
//                .setParameter("id_branch", id_branch)
//                .setString("date_order", date_order);
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_DoanhThuWeekMonth");
        procedureCall.registerParameter("id_branch", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("date_from", String.class, ParameterMode.IN);
        procedureCall.registerParameter("date_to", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_branch").bindValue(id_branch);
        procedureCall.getParameterRegistration("date_from").bindValue(date_from);
        procedureCall.getParameterRegistration("date_to").bindValue(date_to);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id_order", objects[0]);
            item.put("time", objects[1]);
            item.put("branch_name", objects[2]);
            item.put("total", objects[3]);
            item.put("stt", objects[4]);
            item.put("type_order", objects[5]);
            map.add(item);
        }
        return map;

    }

    public List getDoanhThuNam(int id_branch, String date_from, String date_to) {
        Session session = this.sessionFactory.getCurrentSession();
//        String hql = "call sp_DoanhThuDay(:id_branch,:date_order)";
//        Query query = session.createQuery(hql)
//                .setParameter("id_branch", id_branch)
//                .setString("date_order", date_order);
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_DoanhThuYear");
        procedureCall.registerParameter("id_branch", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("date_from", String.class, ParameterMode.IN);
        procedureCall.registerParameter("date_to", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_branch").bindValue(id_branch);
        procedureCall.getParameterRegistration("date_from").bindValue(date_from);
        procedureCall.getParameterRegistration("date_to").bindValue(date_to);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id_order", objects[0]);
            item.put("time", objects[1]);
            item.put("branch_name", objects[2]);
            item.put("total", objects[3]);
            item.put("stt", objects[4]);
            item.put("type_order", objects[5]);
            map.add(item);
        }
        return map;

    }

    public List getChiPhiNgay(int id_branch, String date_from, String date_to) {
        Session session = this.sessionFactory.getCurrentSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_ChiPhiDay");
        procedureCall.registerParameter("id_branch", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("date_from", String.class, ParameterMode.IN);
        procedureCall.registerParameter("date_to", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_branch").bindValue(id_branch);
        procedureCall.getParameterRegistration("date_from").bindValue(date_from);
        procedureCall.getParameterRegistration("date_to").bindValue(date_to);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();

            item.put("stt", objects[0]);
            item.put("time", objects[1]);
            item.put("chiphi", objects[2]);
            map.add(item);
        }
        return map;

    }

    public List getChiPhiTuanThang(int id_branch, String date_from, String date_to) {
        Session session = this.sessionFactory.getCurrentSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_ChiPhiWeekMonth");
        procedureCall.registerParameter("id_branch", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("date_from", String.class, ParameterMode.IN);
        procedureCall.registerParameter("date_to", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_branch").bindValue(id_branch);
        procedureCall.getParameterRegistration("date_from").bindValue(date_from);
        procedureCall.getParameterRegistration("date_to").bindValue(date_to);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();

            item.put("stt", objects[0]);
            item.put("time", objects[1]);
            item.put("chiphi", objects[2]);
            map.add(item);
        }
        return map;

    }

    public List getChiPhiNam(int id_branch, String date_from, String date_to) {
        Session session = this.sessionFactory.getCurrentSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_ChiPhiYear");
        procedureCall.registerParameter("id_branch", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("date_from", String.class, ParameterMode.IN);
        procedureCall.registerParameter("date_to", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_branch").bindValue(id_branch);
        procedureCall.getParameterRegistration("date_from").bindValue(date_from);
        procedureCall.getParameterRegistration("date_to").bindValue(date_to);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();

            item.put("stt", objects[0]);
            item.put("time", objects[1]);
            item.put("chiphi", objects[2]);
            map.add(item);
        }
        return map;
    }

    public List getNewCustomer(int nam) {
        Session session = this.sessionFactory.getCurrentSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_NewCustomer");
        procedureCall.registerParameter("nam", Integer.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("nam").bindValue(nam);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();

            item.put("thang", objects[0]);
            item.put("soluong", objects[1]);
            map.add(item);
        }
        return map;
    }

    public List getActivityCustomer(int search_all, String thang, String nam, String phone) {
        Session session = this.sessionFactory.getCurrentSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_KhachHang");
        procedureCall.registerParameter("search_all", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("thang", String.class, ParameterMode.IN);
        procedureCall.registerParameter("nam", String.class, ParameterMode.IN);
        procedureCall.registerParameter("phone", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("search_all").bindValue(search_all);
        procedureCall.getParameterRegistration("thang").bindValue(thang);
        procedureCall.getParameterRegistration("nam").bindValue(nam);
        procedureCall.getParameterRegistration("phone").bindValue(phone);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();

            item.put("id", objects[1]);
            item.put("tenkh", objects[2]);
            item.put("tongtien", objects[3]);
            item.put("soluongdh", objects[4]);

            map.add(item);
        }
        return map;
    }

    public List getDishesMonth(int id_branch, String thang, String nam) {
        Session session = this.sessionFactory.getCurrentSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_MonAnMonth");
        procedureCall.registerParameter("id_branch", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("thang", String.class, ParameterMode.IN);
        procedureCall.registerParameter("nam", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_branch").bindValue(id_branch);
        procedureCall.getParameterRegistration("thang").bindValue(thang);
        procedureCall.getParameterRegistration("nam").bindValue(nam);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();

            item.put("stt", objects[0]);
            item.put("tenmonan", objects[1]);
            item.put("tenchinhanh", objects[2]);
            item.put("soluong", objects[3]);

            map.add(item);
        }
        return map;
    }

    public List getDonHangNgay(int id_loai, String date_from, String date_to) {
        Session session = this.sessionFactory.getCurrentSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_DonHangDay");
        procedureCall.registerParameter("id_loai", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("date_from", String.class, ParameterMode.IN);
        procedureCall.registerParameter("date_to", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_loai").bindValue(id_loai);
        procedureCall.getParameterRegistration("date_from").bindValue(date_from);
        procedureCall.getParameterRegistration("date_to").bindValue(date_to);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();

            item.put("time", objects[0]);
            item.put("donhang", objects[1]);
            map.add(item);
        }
        return map;

    }

    public List getDonHangTuanThang(int id_loai, String date_from, String date_to) {
        Session session = this.sessionFactory.getCurrentSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_DonHangWeekMonth");
        procedureCall.registerParameter("id_loai", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("date_from", String.class, ParameterMode.IN);
        procedureCall.registerParameter("date_to", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_loai").bindValue(id_loai);
        procedureCall.getParameterRegistration("date_from").bindValue(date_from);
        procedureCall.getParameterRegistration("date_to").bindValue(date_to);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();
            
            item.put("time", objects[0]);
            item.put("donhang", objects[1]);
            map.add(item);
        }
        return map;

    }

    public List getDonHangNam(int id_loai, String date_from, String date_to) {
        Session session = this.sessionFactory.getCurrentSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_DonHangYear");
        procedureCall.registerParameter("id_loai", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("date_from", String.class, ParameterMode.IN);
        procedureCall.registerParameter("date_to", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_loai").bindValue(id_loai);
        procedureCall.getParameterRegistration("date_from").bindValue(date_from);
        procedureCall.getParameterRegistration("date_to").bindValue(date_to);

        ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
        ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();

        List results = resultSetOutput.getResultList();
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (Integer i = 0; i < results.size(); i++) {

            Object[] objects = (Object[]) results.get(i);

            Map<String, Object> item = new HashMap<String, Object>();
  
            item.put("time", objects[0]);
            item.put("donhang", objects[1]);
            map.add(item);
        }
        return map;
    }

}
