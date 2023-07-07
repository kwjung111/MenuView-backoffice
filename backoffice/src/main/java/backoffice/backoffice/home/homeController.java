package backoffice.backoffice.home;

import backoffice.backoffice.TestController;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class homeController {
    public static final Logger logger = LogManager.getLogger(homeController.class);

    @RequestMapping("")
    public String test(HttpServletRequest http){
        logger.info("home");
        return "home/home";
    }

}
