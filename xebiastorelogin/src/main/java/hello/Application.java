package hello;

/**
 * Created by anshulsharma on 24/04/15.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"hello"})

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        SpringApplication.run(TestApplication.class, args);
    }
    
    
//    @Bean
//    public LoginService getLoginService(){
//        return new LoginServiceImpl();
//    }
    


}