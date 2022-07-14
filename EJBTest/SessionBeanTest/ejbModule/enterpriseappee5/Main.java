package enterpriseappee5;

import ejb.SessionBeanBean;
import ejb.SessionBeanRemote;

import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class Main {

  @EJB
  private static SessionBeanRemote sessionBeanBean;
  private static SessionBeanRemote sessionBeanBean1;

  public static void main(String[] args) {
	  
	InitialContext ctx = null;
	String lookUpS = null;
	try {
		
		  Properties prop = new Properties();                   
          prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
          prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
          prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
         
          final String appName = "";
          final String moduleName = "SessionBeanTest";
          final String beanName = SessionBeanBean.class.getSimpleName();
          final String viewClassName = SessionBeanRemote.class.getName();
          
         
          lookUpS = "ejb:" + appName + "/" + moduleName  + "/" + beanName + "!" + viewClassName;
         
          ctx = new InitialContext(prop);
          SessionBeanRemote sessionBeanBean1 = (SessionBeanRemote)ctx.lookup(lookUpS);
          System.out.println("Displaying Message using EJB:");
          System.out.println("=================================");
         
          System.out.println("Name of the Company is : =" + sessionBeanBean1.getCompanyname());
          System.out.println("Address of the Company is : =" + sessionBeanBean1.getAddress());
          System.out.println("Message is : =" + sessionBeanBean1.getResult());
          System.out.println("=================================");
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   
  
  }
} 