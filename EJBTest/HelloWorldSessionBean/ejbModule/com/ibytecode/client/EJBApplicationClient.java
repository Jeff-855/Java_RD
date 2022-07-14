package com.ibytecode.client;
import javax.naming.Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.naming.NamingException;

import javax.naming.InitialContext;

import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import com.ibytecode.business.HelloWorld;
import com.ibytecode.businesslogic.HelloWorldBean;
import com.ibytecode.clientutility.ClientUtility;
import com.ibytecode.clientutility.sqlClient;
import com.ibytecode.ejb.entity.Employee;
import com.mysql.jdbc.Driver;

import javax.persistence.Persistence;
//import com.jwt.ejb.entity.Employee;
 
public class EJBApplicationClient {
    private static final String LOOKUP_STRING = "HelloWorldBean/remote";
    @SuppressWarnings("null")
	public static void main(String[] args) {
        HelloWorld bean = doLookup();
         //3. Call business logic
        System.out.println("got Bean***"+bean.toString());
        System.out.println(bean.sayHello());
        System.out.println("again"+ bean.sayHello());
        Employee employee = new Employee();
        System.out.println("got employee***");
               
        employee.setFirstName("Mukesh");
        employee.setLastName("Kumar");
        employee.setEmail("mrajnitro@gmail.com");
        System.out.println("got employee1***"+employee.getFirstName());
        System.out.println(bean.sayHello1());
       // bean.addEmployee(employee);
           
        //doFind();.
        List res= bean.doquery();
        for (Object row : res) {  
            Object[] cells = (Object[]) row;  
            System.out.println("id = " + cells[0]);  
            System.out.println("lastname = " + cells[1]);  
            System.out.println("firstname = " + cells[2]);  
        }  
       // System.out.println("get bean query"+ res);
        //nativequery
        System.out.println("get bean by em.nativesql");
        bean.doquery();
        
        System.out.println("get bean by ds.jdbc");
        //jdbc query
        bean.doquery1();
       // bean.doupdate();
        System.out.println("insert by ds.jdbc");
        bean.doinsert();
       
        //doQuery();
        
        System.out.println("got employee2***"+employee.getFirstName());
    }
 
    private static HelloWorld doLookup(){
        Context context = null;
        HelloWorld bean = null;
        String lookUpS = null;
        try{
                    //1. Obtaining Context
        	 System.out.println("before Context***");
            context = ClientUtility.getInitialContext();   
            System.out.println("after Context***");
            final String appName = "";
            final String moduleName = "HelloWorldSessionBean";
            final String beanName = HelloWorldBean.class.getSimpleName();
            final String viewClassName = HelloWorld.class.getName();
            
            //Object ob = context.lookup("java:global" + appName + "/" + moduleName  + "/" + beanName );
            
           /*
            Properties props = new Properties();
    		props.setProperty(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
    		InitialContext ctx = new InitialContext(props);
    		HelloWorld ejb = (HelloWorld)
    				ctx.lookup("ejb:/HelloWorldSessionBean/HelloWorldBean!com.ibytecode.business.HelloWorld");
    		
            */
            lookUpS = "ejb:" + appName + "/" + moduleName  + "/" + beanName + "!" + viewClassName;
            System.out.println("NewTest:::");
            bean = (HelloWorld)context.lookup(lookUpS); 
                System.out.println("after lookup  Context***"+bean.sayHello());
                
                System.out.println("NewTest1:::");
        }catch(NamingException e){
            e.printStackTrace();
        }
        return bean;
    }
    
    private static void doFind() {
    	System.out.println("Connected to the database do find");
    	Connection conn1 = null;
        Connection conn2 = null;
        Connection conn3 = null;
    	InitialContext context = null;
		try {
			context = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	try {
			DataSource datasource = (DataSource) context.lookup("java:jboss/MySqlDS");
			try {
				conn2 = datasource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	if (conn2 != null) {
    		System.out.println("conn2 connect ok");
    	}else {
    		System.out.println("conn2 connect not ok");
    	}
       
        String url1 = "jdbc:mysql://localhost:3306/testdb";
		String user = "root";
		String password = "Td950439";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn1 = DriverManager.getConnection(url1, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
