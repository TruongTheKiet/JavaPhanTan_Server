/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.dao;

import com.javateam.restapi_quanli.model.Menu;
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
public class MenuDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    
     public List getAllMenu() {
        Session session = this.sessionFactory.getCurrentSession();
        List chinhanh = session.createQuery("from Menu").list();
        return chinhanh;
    }

    public Menu getMenuByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Menu menu = (Menu) session.get(Menu.class, new Integer(id));
        return menu;
    }

    public List getMenuByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from Menu mn where lower(mn.Ten) like :searchName";
        Query query = session.createQuery(hql);
        query.setParameter("searchName", "%"+name.toLowerCase() + "%");
        return query.list();

    }
    
    public List getMenuByIDBranch(int id_branch) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from Menu mn where mn.ID_ChiNhanh = :id_branch";
        Query query = session.createQuery(hql);
        query.setInteger("id_branch", id_branch);
        return query.list();

    }
    
    public Menu addMenu(Menu menu) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(menu);
        return menu;
    }

    public void updateMenu(Menu menu) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(menu);
    }

    public void deleteMenuByIDBranchIDMonAn(int id_branch, int id_monan) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "delete from Menu mn where mn.ID_ChiNhanh = :id_branch and mn.ID_MonAn = :id_monan";
        Query query = session.createQuery(hql);
        query.setInteger("id_branch", id_branch);
        query.setInteger("id_monan", id_monan);
        query.executeUpdate();
    }
}
