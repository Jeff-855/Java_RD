package com.ibytecode.businesslogic;

import com.ibytecode.business.HelloWorld;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Remote;

//import com.ibytecode.ejb.entity.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.sql.DataSource;

//import com.jwt.ejb.entity.Employee;
import com.ibytecode.ejb.entity.Employee;

@Stateless
@Remote(HelloWorld.class)

public class HelloWorldBean implements HelloWorld {
	// entitymanger control
	@PersistenceContext(unitName = "HelloWorldSessionBean")
	private EntityManager em;

	// µù¤Jdata source
	@Resource(lookup = "java:jboss/MySqlDS")
	private DataSource ds;

	public HelloWorldBean() {
		System.out.println("bean construction");
	}

	public String sayHello() {
		return "Hello World !!!";
	}

	public String sayHello1() {
		return "Hello World1  !!!";
	}

	public String addEmployee(Employee employee) {
		String result = "no";
		System.out.println("addEmpolyee bean***" + result);
		try {
			em.persist(employee);
		} catch (PersistenceException ex) {
			throw new PersistenceException("Error while using EntityManager: " + ex.getMessage(), ex);

		}
		result = "ok";
		System.out.println("addEmpolyee bean1***" + result);
		return result;

	}

	public List doquery() {
		System.out.println("addEmpolyee query bean***");

		Query query = em.createNativeQuery("select id,last_name,first_name from testdb.employee where id >?");
		@SuppressWarnings("rawtypes")
		List rows = query.setParameter(1, "1").getResultList();

		for (Object row : rows) {
			Object[] cells = (Object[]) row;
			System.out.println("id = " + cells[0]);
			System.out.println("lastname = " + cells[1]);
			System.out.println("firstname = " + cells[2]);
		}
		return rows;
	}

	public void doquery1() {
		System.out.println("query1 id bigger than 40 :");
		ResultSet res = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("select id,last_name,first_name from testdb.employee where id > ?");
			stat.setInt(1, 40);
			res = stat.executeQuery();
			while (res.next()) {
				System.out.println("id:" + res.getString(1));
				System.out.println("last_name:" + res.getString(2));
				System.out.println("first_name:" + res.getString(3));
			}
			// return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// return res;
	}

	public void doupdate() {
		System.out.println("bean update :");

		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement stat = conn.prepareStatement("update testdb.employee set first_name =? where id=?");
			stat.setString(1, "Jeff1");
			stat.setInt(2, 40);
			stat.executeUpdate();
			conn.close();
			System.out.println("bean update OK:");
			// return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void doinsert() {
		System.out.println("bean Insert :");

		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement stat = conn
					.prepareStatement("insert into testdb.employee (last_name,first_name,email) values(?,?,?)");
			stat.setString(1, "Yang");
			stat.setString(2, "Jeff2");
			stat.setString(3, "yang3082@gmail.com");
			stat.executeUpdate();
			conn.close();
			System.out.println("bean Insert OK:");
			// return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}