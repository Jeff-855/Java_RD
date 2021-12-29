package com.transaction;

import java.sql.Date;

public class DepBean {
	// generate getter and setters
		private String id, prty_id, isin;
		private Date iss_dt,mat_dt;
		private Double tot_amt;
		int srNo;
		public String id() {
			return id;
		}

		public void setid(String id) {
			this.id = id;
		}
		
		public String prty_id() {
			return prty_id;
		}

		public void setprty_id(String prty_id) {
			this.prty_id = prty_id;
		}
		
		public String isin() {
			return isin;
		}
		public void setisin(String isin) {
			this.isin=isin;
		}
		public Date iss_dt() {
			return iss_dt;
		}
		
		public void setiss_dt(Date iss_dt) {
			this.iss_dt=iss_dt;
		}
		public Date mat_dt() {
			return mat_dt;
		}
		public void setmat_dt(Date mat_dt) {
			this.mat_dt=mat_dt;
		}
		public Double tot_amt(){
			return tot_amt;
		}
		public void settot_amt(Double tot_amt) {
			this.tot_amt=tot_amt;
		}
		
		public int srNo() {
			return srNo;
		}
		public void setsrNo(int srNo) {
			this.srNo=srNo;
		}
		
		
}
