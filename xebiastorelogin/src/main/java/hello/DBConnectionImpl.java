package hello;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

//@Component
public class DBConnectionImpl  implements DBConnection{

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/xebiastore";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	
	public Connection getConnection(){
		Connection conn = null;
		
		
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			return conn;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return conn;
		}
		finally{
		}
	}

}
