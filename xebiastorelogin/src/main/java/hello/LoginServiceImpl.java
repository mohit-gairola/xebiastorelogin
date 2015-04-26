package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 
 //@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	UserDAO userDAO;
	
	   public String login(String name ,String  password){
		   
		   String passwordDB=userDAO.getPasswordByUserName(name);
		   
		   System.out.println("this is my password in database---"+passwordDB);
		   
		   //match the password
		   if(passwordDB.equals(password)){
			   return "successfully authenticated";
		   }
		   else{
			   return "not authenticated";
		   }
//		   return "authenticated";
	        
	    }

}
