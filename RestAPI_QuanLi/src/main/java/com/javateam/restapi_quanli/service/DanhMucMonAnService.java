/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javateam.restapi_quanli.service;

import com.javateam.restapi_quanli.dao.DanhMucMonAnDAO;
import com.javateam.restapi_quanli.model.DanhMucMonAn;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TheKiet
 */
@Service("DanhMucMonAnService")
public class DanhMucMonAnService {
 
 @Autowired
 DanhMucMonAnDAO danhmucmonanDAO;
 
 @Transactional
 public List getAllDanhMucMonAn() {
  return danhmucmonanDAO.getAllDanhMucMonAn();
 }
 
 @Transactional
 public DanhMucMonAn getDanhMucMonAn(int id) {
  return danhmucmonanDAO.getDanhMucMonAn(id);
 }
 
 @Transactional
 public void addDanhMucMonAn(DanhMucMonAn danhmucmonan) {
  danhmucmonanDAO.addDanhMucMonAn(danhmucmonan);
 }
 
 @Transactional
 public void updateDanhMucMonAn(DanhMucMonAn danhmucmonan) {
  danhmucmonanDAO.updateDanhMucMonAn(danhmucmonan);
 
 }
 
 @Transactional
 public void deleteDanhMucMonAn(int id) {
  danhmucmonanDAO.deleteDanhMucMonAn(id);
 }
}