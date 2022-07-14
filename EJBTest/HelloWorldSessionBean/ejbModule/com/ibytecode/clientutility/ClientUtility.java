package com.ibytecode.clientutility;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.wildfly.common.context.Contextual;
public class ClientUtility {
    /*location of JBoss JNDI Service provider the client will use. 
    It should be URL string.*/
    /*private static final String PROVIDER_URL = "jnp://localhost:1099";*/
	//private static final String PROVIDER_URL = "localhost:8080";
   private static final String PROVIDER_URL = "http-remoting://localhost:8080";
   
    /*specifying the list of package prefixes to use when 
    loading in URL context factories. colon separated*/
    /*private static final String JNP_INTERFACES = 
            "org.jboss.naming:org.jnp.interfaces";*/
    private static final String JNP_INTERFACES = 
    		//"org.jboss.naming:org.jnp.interfaces";
            "org.jboss.ejb.client.naming";
    /*Factory that creates initial context objects. 
    fully qualified class name. */
    
    /*private static final String INITIAL_CONTEXT_FACTORY = 
            "org.jnp.interfaces.NamingContextFactory";*/
    private static final String INITIAL_CONTEXT_FACTORY =
    		"org.wildfly.naming.client.WildFlyInitialContextFactory";
    		//"org.jboss.naming.remote.client.InitialContextFactory";
   
    private static Context initialContext;
     
    public static Context getInitialContext() throws NamingException
    {
        if (initialContext == null) {
            //Properties extends HashTable
            Properties prop = new Properties();                   
            prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
            prop.put(Context.PROVIDER_URL, PROVIDER_URL);
           // prop.put("jboss.naming.client.ejb.context", true);
            
            //initialContext = new WildFlyInitialContext(prop);
            initialContext = new InitialContext(prop);
        }
        return initialContext;
    }
}
