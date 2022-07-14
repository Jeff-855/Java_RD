package com.ibytecode.business;
import java.sql.ResultSet;
import java.util.List;

import javax.ejb.Remote;
import com.ibytecode.ejb.entity.*;
//import com.jwt.ejb.entity.Employee;
 
@Remote
public interface HelloWorld {
    public String sayHello();
    public String sayHello1();
    public String addEmployee(Employee employee);
    public List doquery();
    public void doquery1();
    public void doupdate();
    public void doinsert();
    
}

