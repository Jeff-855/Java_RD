import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ibm.db2.jcc.DB2Driver;

public class TestDB1 {
	public static int gvar;
	public static void main(String[] argv) {
        float y = 0;
        say("Hello, world\n");        
        DBConnectionTest();
        
    }
    public static void say(String s) {
        int x = 10;
        System.out.print(s+x);
        System.out.println("******");
        
    }
    public static void DBConnectionTest() {
    	System.out.println("******DB Connection Test Begin******");
        String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
        String url="jdbc:db2://localhost:50000/ibmsf";
       // String url="jdbc:db2://172.20.8.56:60000/ibmsf";
       // String url="jdbc:db2://128.1.120.230:50014/ibmsf";
        //String user="bcssdb2p";
        //String password="bcss1234";
          String user="db2admin";
          String password="db2admin";
        Connection connection = null;
        
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        
        try {
            //Load class into memory
            Class.forName(jdbcClassName);
            //Establish connection
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            String sqlStm = "select isin,issr_nm,issr_id from ibmsf.iss fetch first 20 rows only";
            //String sqlStm ="select ts,bcss_bus_date,gen_schd_ind from ibmsf.bcss_bus_date";
            preparedStatement = connection.prepareStatement(sqlStm);
          
            resultSet = preparedStatement.executeQuery();
         // Iterate through the Db2 data in the result set 
            while(resultSet.next()){
            	System.out.println( resultSet.getString(1)+" ***  "+resultSet.getString(2)+" ***  "+resultSet.getString(3));
            }
            System.out.println( "******DB Connection Test End******");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(connection!=null){
                System.out.println("Connected successfully.");
                try {
                	preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
}
