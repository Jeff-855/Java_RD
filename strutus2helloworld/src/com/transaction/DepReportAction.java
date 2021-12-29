package com.transaction;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.transaction.DepBean;
import com.transaction.DepDao;


import com.opensymphony.xwork2.ActionSupport;

public class DepReportAction  {

	private static final long serialVersionUID = 6329394260276112660L;
	ResultSet rs = null;
	DepBean depBean = null;
	List<DepBean> beanList = null;
	DepDao depDao = new DepDao();
	private boolean noData = false;
	
	private int srNo=0;
	
	/*private ArrayList list=new ArrayList();  
	public ArrayList getList() {  
	    return list;  
	}  
	public void setList(ArrayList list) {  
	    this.list = list;  
	}  */
	
	public String execute() throws Exception {
			   
		try {
			beanList = new ArrayList<DepBean>();
			
			rs = depDao.report();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					depBean = new DepBean();
					depBean.setid(rs.getString("id"));
					depBean.setprty_id(rs.getString("prty_id"));
					depBean.setisin(rs.getString("isin"));
					depBean.setiss_dt(rs.getDate("iss_dt"));
					depBean.setmat_dt(rs.getDate("mat_dt"));
					depBean.settot_amt(rs.getDouble("tot_amt"));
					//list.add(depBean);
					beanList.add(depBean);
					
					System.out.println(depBean.id());
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<DepBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<DepBean> beanList) {
		this.beanList = beanList;
	}
	/*	
	public List<EmpBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<EmpBean> beanList) {
		this.beanList = beanList;
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
	}*/
}
