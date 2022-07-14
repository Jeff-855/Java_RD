package com.ibytecode.client;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.ibytecode.business.HelloWorld;
import com.ibytecode.businesslogic.HelloWorldBean;
import com.ibytecode.clientutility.ClientUtility;
 
public class EJBApplicationClient1 {
    private static final String LOOKUP_STRING = "HelloWorldBean/remote";
    public static void main(String[] args) {
        HelloWorld bean = doLookup();
         //3. Call business logic
        System.out.println(bean.sayHello());
    }
 
    private static HelloWorld doLookup(){
        Context context = null;
        HelloWorld bean = null;
        String lookUpS = null;
        try{
                //1. Obtaining Context
                context = ClientUtility.getInitialContext();
                //2. Lookup and cast
               
                final String appName = "";
                final String moduleName = "HelloWorld1SessionBean";
                final String beanName = HelloWorldBean.class.getSimpleName();
                final String viewClassName = HelloWorld.class.getName();
            /*       
                Object ob = context.lookup("ejb:" + appName + "/" + moduleName  + "/" + beanName + "!" + viewClassName);
                System.out.println("NewTest 0:::");
                HelloWorld hw = (HelloWorld) PortableRemoteObject.narrow(ob, HelloWorld.class);
                bean= hw;
                System.out.println("hwBean Say Hello:"+ hw.sayHello());
               // */
               
                lookUpS = "ejb:" + appName + "/" + moduleName  + "/" + beanName + "!" + viewClassName;
                System.out.println("NewTest:::"); 
                bean = (HelloWorld)context.lookup(lookUpS);
                
                
        }catch(NamingException e){
        	System.out.println("NewTest222:::");
            e.printStackTrace();
        }
        return bean;
    }
}
