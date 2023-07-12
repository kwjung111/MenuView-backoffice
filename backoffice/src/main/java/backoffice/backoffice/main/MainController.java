package backoffice.backoffice.main;

import backoffice.backoffice.cmmn.CmmnController;
import backoffice.backoffice.home.HomeController;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController extends CmmnController {
    public static final Logger logger = LogManager.getLogger(MainController.class);


    @RequestMapping("")
    public String MainView(HttpServletRequest http){
        logger.info("main");
        return "main/main";
    }

}
