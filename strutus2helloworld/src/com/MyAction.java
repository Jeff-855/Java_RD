package com;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
//import com.mysql.jdbc.Connection;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//public class MyAction extends ActionSupport {
public class MyAction extends ActionSupport {
    private static final long serialVersionUID=1L;
    private String name;
    public String id;
    private Map<String,String> testmap;
    
    public Map<String,String> getTestmap(){
    	return testmap;
    }
    
    public void setTestmap(Map<String,String> testmap){
    	this.testmap=testmap;
    }
    
    private List<String> data;
    
    public List<String> getData() {
		return data;
	}
    public void setData(List<String> data) {
		this.data = data;
	}
	
	
    String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/testdb";
	String user = "root";
	String password ="Tdcc123*";
	Connection connection = null;
	ResultSet resultSet = null;
	String aa = null;
	String selectSql = null;
	Statement statement = null;
	String j_id=null;
	String j_name=null;
	
	
	public String execute() throws Exception{
           Hashtable jj = query(id); 
           Enumeration idKeys;
           idKeys = jj.keys();
           testmap=new HashMap<String,String>();
           data = new ArrayList<String>();
           while(idKeys.hasMoreElements()) {
        	  j_id = (String) idKeys.nextElement();
        	  System.out.println( "j_id: " + j_id+"**");
              System.out.println( "j_name: " + jj.get(j_id)+"**");
              j_name=jj.get(j_id).toString();
              id=j_id;
              name=j_name;
              
              data.add(name);
      		  testmap.put(j_id, j_name);
      		}
           
          // List list = dao.selectLend(pageNow, pageSize);
         //  Pager page = new Pager(pageNow, dao.selectLendSize());
          // Map session = ActionContext.getContext().getSession();
          // session.put("userinfo", list);
          // session.put("pageinfo", page);
           
          /* if (!jj.isEmpty()){
        	   
           id = jj.get("aa").toString();
           name= jj.get("bb").toString();
           }*/
    	   return SUCCESS;
    	}
    
    
    public  Hashtable query (String id){
    	Hashtable qResult= new Hashtable();
    	try {
            // returns the Class object for the class with the specified name
            Class cls = Class.forName(driver);
            
            // returns the name and package of the class
            System.out.println("Class found = " + cls.getName());
            System.out.println("Package = " + cls.getPackage());
         } catch(ClassNotFoundException ex) {
            System.out.println(ex.toString());
         }
    	try {
    		   
    	        connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();

            // Create and execute a SELECT SQL statement.
           
            if (id.equals("*")){
            	 selectSql = "SELECT id,name from testdb.employees ";
            	 System.out.println("selectSql0 = " + selectSql);
            }else {
                 selectSql = "SELECT id,name from testdb.employees where id ='"+id+"'";
                 System.out.println("selectSql1 = " + selectSql);
            }
            System.out.println("selectSql = " + selectSql);
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            int i=0;
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                String t =resultSet.getString(1);
                String t1=resultSet.getString(2);
               
                qResult.put(t,t1);
            }
            /*if (!qResult.isEmpty()){
            	System.out.println(qResult.keys().toString());
                System.out.println(qResult.get(aa).toString());
            }else{
            	System.out.println("empty");
            }*/
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    	  	
    	return qResult;
    }
    
    
    public String getName() {
	      return name;
	}
    public void setName(String name) {
	      this.name = name;
    }
    
    public String getId() {
	      return id;
	}
    public void setId(String id) {
	      this.id = id;
    }
}

/*
package com;

public class MyAction {
	 private String name;
	   public String execute() throws Exception {
	      return "success";
	   } 
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }

}
*/


