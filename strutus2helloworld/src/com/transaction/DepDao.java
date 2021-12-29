package com.transaction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
//import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;




public class DepDao {
	// method for create connection
	public static Connection getConnection() throws Exception {
		try {
			
			//String driver="com.mysql.jdbc.Driver";
			//String url = "jdbc:mysql://localhost:3306/testdb";
			//String user = "root";
			//String password ="Tdcc123*";
			
	        
			String driver="com.ibm.db2.jcc.DB2Driver";
			 String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
			 String url="jdbc:db2://localhost:50000/ibmsf";
	        //String url1="jdbc:db2://localhost:50000/ibmsf";
	        String user ="db2admin";
	        String password="db2admin";
			
			Class.forName(jdbcClassName);
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	
	// method for save input data in database
	public int addDep(String id, String prty_id, String isin, Date iss_dt,Date mat_dt,Double  tot_amt) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO testdb.depinst VALUES (?,?,?,?,?,?)";
			System.out.println("test:"+ sql);
			
			
			
			System.out.println("tot_amt:"+ tot_amt);
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("id:"+id+"aa");
			ps.setString(2, prty_id);
			System.out.println("prty_id:"+prty_id+"aa");
			ps.setString(3,isin);
			System.out.println("isin:"+isin+"aa");
			ps.setDate(4, new java.sql.Date(iss_dt.getTime()));
			System.out.println("iss_dt:"+ new java.sql.Date(iss_dt.getTime()));
			ps.setDate(5, new java.sql.Date(mat_dt.getTime()));
			System.out.println("mat_dt:"+ new java.sql.Date(mat_dt.getTime()));
			ps.setDouble(6,tot_amt);
			System.out.println("tot_amt:"+tot_amt);
			System.out.println("test1:"+ sql);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			throw new Exception("Insert Fail:"+ e);
			
			//return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	// method for fetch saved user data
		public ResultSet report() throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT id,prty_id,isin,iss_dt,mat_dt,tot_amt from testdb.depinst";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		// method for fetch old data to be update
		public ResultSet fetchUserDetails(String id) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT id,prty_id,isin,iss_dt,mat_dt,tot_amt from testdb.depinst WHERE id=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				System.out.println("SQL**"+sql);
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		// method for update new data in database
		public int updateDetails(String id, Date iss_dt, Date mat_dt,Double tot_amt)
				throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE testdb.depinst SET iss_dt=?,mat_dt=?,tot_amt=? WHERE id=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				
				ps.setDate(1, new java.sql.Date(iss_dt.getTime()));
				ps.setDate(2, new java.sql.Date(mat_dt.getTime()));
				ps.setDouble(3, tot_amt);
				ps.setString(4, id);
				
				i = ps.executeUpdate();
				System.out.println("Result****"+ i);
				return i;
				
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		// method for delete the record
		public int delDepInst(String id) throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "DELETE FROM testdb.depinst WHERE id=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, id);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
}


