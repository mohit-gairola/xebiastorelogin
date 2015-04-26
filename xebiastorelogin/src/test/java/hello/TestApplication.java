package hello;

/**
 * Created by anshulsharma on 24/04/15.
 */
import static org.mockito.Mockito.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"hello"})
public class TestApplication {
//
//	  public static void main(String[] args) {
//	        SpringApplication.run(TestApplication.class, args);
//	    }

    
    @Bean
    public LoginService getMockLoginService(){
        return new LoginService() {
			
			@Override
			public String login(String name, String password) {
				// TODO Auto-generated method stub

			   //MockDAO Object
				UserDAO userDAO = getMockUserDAO();
				
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
//
//    @Bean
//    public GreetingController getGreetingController(){
//     return new GreetingController();`	
//    }


    public UserDAO getMockUserDAO(){
    	 UserDAO userDAO = mock(UserDAO.class);    	 
		  when(userDAO.getPasswordByUserName("mohit")).thenReturn("pwd");
		    
		    		    
		    return userDAO;
    }
}