package com.transaction;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class DepAction {
	private static final long serialVersionUID=1L;
	private String id, prty_id,isin;
	private Date iss_dt,mat_dt;
	private Double tot_amt;
	private String type;
	private int srNo=0;
	public String execute() throws Exception{
		DepDao depDao = null;
		depDao =new DepDao();
		String msg="";
		try {
			if (type.equals("add")) {
			srNo = depDao.addDep(id, prty_id, isin,iss_dt, mat_dt, tot_amt);
			}else if (type.equals("del")) {
				srNo = depDao.delDepInst(id);
			}else if (type.equals("report")){
				System.out.println("Report");
			}else if (type.equals("update")) {
				srNo=depDao.updateDetails(id,  iss_dt, mat_dt,tot_amt);
			}else if (type.equals("del")) {
				srNo=depDao.delDepInst(id);
			}
			if (srNo > 0) {
				msg = "success";
				System.out.println("success");
			} else {
				msg = "error";
				System.out.println("false");
				
			}
		} catch (Exception e) {
			throw new Exception("input fail"+e);
		}
		return msg;
		
		
	}
	public String getId() {
		  return id;
	}
	public void setId(String id) {
		  this.id= id;
	}
	public String getPryt_id() {
		  return prty_id;
	}
	public void setPrty_id(String prty_id) {
		  this.prty_id= prty_id;
	}
	public String getIsin() {
		  return isin;
	}
	public void setIsin(String isin) {
		  this.isin= isin;
	}
	public Date getIss_dt() {
		  return iss_dt;
	}
	public void setIss_dt(Date iss_dt) {
		  this.iss_dt= iss_dt;
	}
	public Date getMat_dt() {
		  return mat_dt;
	}
	public void setMat_dt(Date mat_dt) {
		  this.mat_dt= mat_dt;
	}
	public Double getTot_amt() {
		  return tot_amt;
	}
	public void setTot_amt(Double tot_amt) {
		  this.tot_amt= tot_amt;
	}
	public String getType() {
		  return type;
	}
	public void setType(String type) {
		  this.type= type;
	}

}
