package com.transaction;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
public class UpdateAction {
	private static final long serialVersionUID = -1905974197186620917L;
	private String id,prty_id,isin;
	private Date iss_dt,mat_dt;
	private Double tot_amt;
	ResultSet rs = null;
	

	String msg="";
	DepDao depDao= new DepDao();
	String submitType;
	
	public String execute() throws Exception {
		try {
			
			
			if (submitType.equals("updatedata")) {
				rs = depDao.fetchUserDetails(id.trim());
				if (rs != null) {
					while (rs.next()) {
						prty_id = rs.getString("prty_id");
						isin = rs.getString("isin");
						iss_dt = rs.getDate("iss_dt");
						mat_dt = rs.getDate("mat_dt");
						tot_amt= rs.getDouble("tot_amt");
						
						msg = "success";
					}
				}
			} else {
				
				int i = depDao.updateDetails(id, iss_dt, mat_dt, tot_amt);
				if (i > 0) {
					msg = "success";
				} else {
					msg = "error";
				}
			}
		   }catch (Exception e) {
			e.printStackTrace();
		}
	        System.out.println("update msg" +  msg);
			return msg ;
	    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrty_id() {
		return prty_id;
	}
	public void setPrty_id() {
		this.prty_id=prty_id;
	}
	
	public String getIsin() {
		return isin;
	}
	public void setIsin() {
		this.isin=isin;
	}
	
	public Date getIss_dt() {
		return iss_dt;
	}

	public void setIss_dt(Date iss_dt) {
		this.iss_dt = iss_dt;
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
		this.tot_amt = tot_amt;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}