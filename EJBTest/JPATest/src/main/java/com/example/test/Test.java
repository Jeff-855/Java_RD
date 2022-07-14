package com.example.test;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jwt.ejb.entity.Employee;
public class Test {
    private static final String PERSISTENCE_UNIT_NAME = "JPATest";
      private static EntityManagerFactory factory;
      public static void main(String[] args) {
        //factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        //EntityManager em = factory.createEntityManager();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
       	EntityManager em = factory.createEntityManager( );
        /* read the existing entries and write to console
        //Query q = em.createQuery("select e from testdb.test e");
         * */
        Query q = em.createNativeQuery("select * from test ", Employee.class);
        List<Employee> employeeList = q.getResultList();
        for (Employee employee : employeeList) {
          System.out.println("id:"+ employee.getId());
          System.out.println("last Name:"+ employee.getLastName());
          System.out.println("first Name:"+ employee.getFirstName());
          System.out.println("email:"+ employee.getEmail());
        }
        System.out.println("Size: " + employeeList.size());
        
        /*
        // create new todo
        em.getTransaction().begin();
        Employee emp = new Employee();
        emp.setLastName("Yang");
        emp.setFirstName("Jeff");
        emp.setEmail("m@gmail.com");
        
        em.persist(emp);
        em.getTransaction().commit();
        em.close();
        
        System.out.println("ok: " +emp.getId());
        */
      }
    }