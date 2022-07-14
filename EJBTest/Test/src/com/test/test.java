package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		System.out.println("Connected to the database do find");
    	Connection conn1 = null;
        Connection conn2 = null;
        Connection conn3 = null;
 
        String url1 = "jdbc:mysql://localhost:3306/testdb";
		String user = "root";
		String password = "Td950439";
		
		/*
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn1 = DriverManager.getConnection(url1, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			conn1 = DriverManager.getConnection(url1, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (conn1 != null) {
		    System.out.println("Connected to the database test1");
		}else {
		    System.out.println("Connected to the database not ok");
		}

	}

}
