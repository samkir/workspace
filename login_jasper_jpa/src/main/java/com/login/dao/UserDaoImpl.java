package com.login.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


@Repository
public class UserDaoImpl {

 @Autowired
 private DataSource dataSource;
 @Autowired
 private ResourceLoader resourceLoader;
 
 

 public JasperPrint exportPdfFile(int c_invoice_id, int c_bpartner_id) throws SQLException, JRException, IOException {

	 String path = resourceLoader.getResource("classpath:test.jrxml").getURI().getPath();

	  JasperReport jasperReport = JasperCompileManager.compileReport(path);
  
    Map<String, Object> parameters = new HashMap<String, Object>();
   
parameters.put("c_invoice_id",c_invoice_id);
parameters.put("c_bpartner_id",c_bpartner_id);

  JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());

  return print;
 }
}