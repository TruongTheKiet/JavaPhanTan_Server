/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.dao;

import com.javateam.restapi_quanli.model.DanhMucMonAn;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TheKiet
 */
@Repository
public class DanhMucMonAnDAO {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 public void setSessionFactory(SessionFactory sf) {
  this.sessionFactory = sf;
 }
 
 public List getAllCountries() {
  Session session = this.sessionFactory.getCurrentSession();
  List danhmucmonan = session.createQuery("from DanhMucMonAn").list();
  return danhmucmonan;
 }
 
 public DanhMucMonAn getDanhMucMonAn(int id) {
  Session session = this.sessionFactory.getCurrentSession();
  DanhMucMonAn danhmucmonan = (DanhMucMonAn) session.load(DanhMucMonAn.class, new Integer(id));
  return danhmucmonan;
 }
 
 public DanhMucMonAn addDanhMucMonAn(DanhMucMonAn danhmucmonan) {
  Session session = this.sessionFactory.getCurrentSession();
  session.persist(danhmucmonan);
  return danhmucmonan;
 }
 
 public void updateDanhMucMonAn(DanhMucMonAn danhmucmonan) {
  Session session = this.sessionFactory.getCurrentSession();
  session.update(danhmucmonan);
 }
 
 public void deleteDanhMucMonAn(int id) {
  Session session = this.sessionFactory.getCurrentSession();
  DanhMucMonAn p = (DanhMucMonAn) session.load(DanhMucMonAn.class, new Integer(id));
  if (null != p) {
   session.delete(p);
  }
 } 
}