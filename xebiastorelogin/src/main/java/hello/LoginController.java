package hello;

/**
 * Created by anshulsharma on 24/04/15.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.test.SpringApplicationConfiguration;


@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

   
	@RequestMapping("/admin")
    public @ResponseBody String login(@RequestParam(value="name", required=false, defaultValue="World") String name,@RequestParam(value="password", required=false, defaultValue="World") String password, Model model) {
//        model.addAttribute("name", name);
        return loginService.login(name,password);
    }

}
