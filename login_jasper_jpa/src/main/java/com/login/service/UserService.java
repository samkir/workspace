package com.login.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.UserDaoImpl;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class UserService {

 @Autowired
 private UserDaoImpl userDao;
 
 public JasperPrint exportPdfFile(int c_invoice_id, int c_bpartner_id) throws SQLException, JRException, IOException {
  return userDao.exportPdfFile(c_invoice_id,c_bpartner_id);
 }
}