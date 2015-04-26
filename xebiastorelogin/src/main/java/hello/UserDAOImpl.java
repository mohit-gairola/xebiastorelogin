package hello;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

	
//	// JDBC driver name and database URL
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost/xebiastore";
//
//	// Database credentials
//	static final String USER = "root";
//	static final String PASS = "root";
//	
//	public Connection getConnection(){
//		Connection conn = null;
//		
//		
//		try {
//			// STEP 2: Register JDBC driver
//			Class.forName(JDBC_DRIVER);
//
//			// STEP 3: Open a connection
//			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//			return conn;
//		}
//		catch(Exception ex){
//			ex.printStackTrace();
//			return conn;
//		}
//		finally{
//		}
//	}
	@Autowired
	DBConnection dbConnection;

	public String getPasswordByUserName(String userName) {

		String password = "";
		Statement stmt = null;
		try{
			Connection conn=dbConnection.getConnection();
			stmt = conn.createStatement();
			
			
			String sql = "SELECT password FROM user where name ='" + userName+"'";
			
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				password = rs.getString("password");

			}
			 rs.close();
			 stmt.close();
			 conn.close();
			 
			 return password;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return password;
		}
		      
			
		
	}
}
