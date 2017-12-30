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

    public List getDoanhThuNgay(int id_branch, String date_order) {
        Session session = this.sessionFactory.getCurrentSession();
//        String hql = "call sp_DoanhThuDay(:id_branch,:date_order)";
//        Query query = session.createQuery(hql)
//                .setParameter("id_branch", id_branch)
//                .setString("date_order", date_order);
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_DoanhThuDay");
        procedureCall.registerParameter("id_branch", Integer.class, ParameterMode.IN);
        procedureCall.registerParameter("date_order", String.class, ParameterMode.IN);

        procedureCall.getParameterRegistration("id_branch").bindValue(id_branch);
        procedureCall.getParameterRegistration("date_order").bindValue(date_order);

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
            map.add(item);
        }
        return map;

    }
}
