/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.dao;

import com.javateam.restapi_quanli.model.ChiNhanh;
import com.javateam.restapi_quanli.model.DanhMucMonAn;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TheKiet
 */
@Repository
public class ChiNhanhDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List getAllChiNhanh() {
        Session session = this.sessionFactory.getCurrentSession();
        List chinhanh = session.createQuery("from ChiNhanh").list();
        return chinhanh;
    }

    public ChiNhanh getChiNhanhByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ChiNhanh chinhanh = (ChiNhanh) session.get(ChiNhanh.class, new Integer(id));
        return chinhanh;
    }

    public List getChiNhanhByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from ChiNhanh cn where lower(cn.Ten) like :searchName";
        Query query = session.createQuery(hql);
        query.setParameter("searchName", "%"+name.toLowerCase() + "%");
        return query.list();

    }

    public ChiNhanh addChiNhanh(ChiNhanh chinhanh) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(chinhanh);
        return chinhanh;
    }

    public void updateChiNhanh(ChiNhanh chinhanh) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(chinhanh);
    }

    public void deleteChiNhanhByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ChiNhanh p = (ChiNhanh) session.load(ChiNhanh.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }
}
