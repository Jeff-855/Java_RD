package com.ibytecode.clientutility;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class sqlClient {
	 public static void doQuery() {
		 EntityManager entityManager = 
		            JPAUtility.getEntityManagerFactory().createEntityManager();
		        //EntityTransaction etx = entityManager.getTransaction();
		       // etx.begin();
		       // entityManager.persist(user);
		        Query query= entityManager.createNativeQuery("select id,lastName,firstname from testdb where id = ?");
		    	List rows= query.setParameter(1, "1").getResultList();
		        //etx.commit();
		               
		    	
	    	 
	        for (Object row : rows) {  
	            Object[] cells = (Object[]) row;  
	            System.out.println("id = " + cells[0]);  
	            System.out.println("lastname = " + cells[1]);  
	            System.out.println("firstname = " + cells[2]);  
	        }  
	        entityManager.close(); 
	    }
}
