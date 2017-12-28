/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.dao;

import com.javateam.restapi_quanli.model.MonAn;
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
public class MonAnDAO {
     @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List getAllMonAn() {
        Session session = this.sessionFactory.getCurrentSession();
        List chinhanh = session.createQuery("from MonAn").list();
        return chinhanh;
    }

    public MonAn getMonAnByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MonAn monan = (MonAn) session.get(MonAn.class, new Integer(id));
        return monan;
    }

    public List getMonAnByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from MonAn ma where lower(ma.Ten) like :searchName";
        Query query = session.createQuery(hql);
        query.setParameter("searchName", "%"+name.toLowerCase() + "%");
        return query.list();

    }

    public MonAn addMonAn(MonAn monan) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(monan);
        return monan;
    }

    public void updateMonAn(MonAn monan) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(monan);
    }

    public void deleteMonAnByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MonAn p = (MonAn) session.load(MonAn.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }
}
