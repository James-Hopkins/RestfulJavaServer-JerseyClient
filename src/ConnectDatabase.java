

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDatabase {
   public static void main(String[] args) {
      Connection con = null;
      
      try {
    	  // before start open terminal in /A00220384_James_Hopkins/local_hsql_installation/hsqldb-2.4.0/hsqldb 
    	  //and run next line
    	  // java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/fruity --dbname.0 fruits
    	  //Registering the HSQLDB JDBC driver
    	  Class.forName("org.hsqldb.jdbc.JDBCDriver");
         
    	  //Creating the connection with HSQLDB
    	  con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
    	  if (con!= null){
    		  Statement stmt = con.createStatement();
    		  stmt.executeUpdate("CREATE TABLE IF NOT EXISTS "
				  + "FRUIT(id INTEGER IDENTITY, "
				  + "name VARCHAR(32) NOT NULL, "
				  + "price DOUBLE NOT NULL, "
				  + "texture VARCHAR(64) NOT NULL, "
				  + "color VARCHAR(32) NOT NULL)");
    		  stmt.executeUpdate("INSERT INTO FRUIT (id, name, price, texture, color) "
    		  		+ "VALUES ('1', 'Cherry', 2.02, 'waxy', 'red')");
    		  stmt.executeUpdate("INSERT INTO FRUIT (id, name, price, texture, color) "
      		  		+ "VALUES ('2', 'apple', 1.62, 'smooth', 'green')");
    		  stmt.executeUpdate("INSERT INTO FRUIT (id, name, price, texture, color) "
      		  		+ "VALUES ('3', 'kiwi', 2.42, 'hairy', 'brown')");
    		  System.out.println("Connection created successfully");
    		  
    	  }else{
    		  System.out.println("Problem with creating connection");
    	  }
      
  		}  catch (Exception e) {
  			e.printStackTrace(System.out);
  		}
   }
}