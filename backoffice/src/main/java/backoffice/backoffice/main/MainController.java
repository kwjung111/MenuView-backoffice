package backoffice.backoffice.main;

import backoffice.backoffice.cmmn.CmmnController;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController extends CmmnController {
    public static final Logger logger = LogManager.getLogger(MainController.class);

    @Autowired
    private MainService mainService;

    @RequestMapping("")
    public String mainView(HttpServletRequest http){
        logger.info("main");
        return "main/main";
    }


    @RequestMapping("/info")
    public String userInfo(HttpServletRequest http){
        logger.info("userinfo");
        mainService.getUserInfo();
        return "main/main";
    }

}
