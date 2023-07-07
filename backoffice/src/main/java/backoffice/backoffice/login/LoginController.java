package backoffice.backoffice.login;

import backoffice.backoffice.TestController;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login2")
public class LoginController {

    public static final Logger logger = LogManager.getLogger(LoginController.class);


    @RequestMapping("")
    public String Login(HttpServletRequest http){
        logger.info("login called");
        //로그인 기본 경로
        return "login/login";
    }

    @GetMapping("/login")
    public String Login(@RequestParam String status){
        logger.info("login success");
        if(status == "success"){
            return "home/home";
        }
        else{
            return "home/home";
        }
    }


}
