package hello;

/**
 * Created by anshulsharma on 24/04/15.
 */
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"hello"})
public class TestDBApplication {
//
//	  public static void main(String[] args) {
//	        SpringApplication.run(TestApplication.class, args);
//	    }

	@Autowired
	UserDAO userDAO;
	
    @Bean
    public LoginService getMockLoginService(){
        return new LoginService() {
			
			@Override
			public String login(String name, String password) {
				// TODO Auto-generated method stub

			   //Mock DB
			
				
				String passwordDB =userDAO.getPasswordByUserName(name);
				System.out.println("password in mock dao ---"+ passwordDB);
				if (passwordDB.equals(password)){
					return "authenticated mock";
				}
				else{
					
				return "not authenticated ";
				}
			}
		};
    }
    
    @Bean
    public DBConnection getMockDBConnection(){
    	return new DBConnection() {
			
			@Override
			public Connection getConnection(){
					Connection conn = null;
					
					
					try {
						// STEP 2: Register JDBC driver
						Class.forName("com.mysql.jdbc.Driver");

						// STEP 3: Open a connection
						System.out.println("Connecting to database...");
						conn = DriverManager.getConnection("jdbc:mysql://localhost/xebiastoretest", "root", "root");

						return conn;
					}
					catch(Exception ex){
						ex.printStackTrace();
						return conn;
					}
					finally{
					}
				}
    	
			
		};
    


    }
}
