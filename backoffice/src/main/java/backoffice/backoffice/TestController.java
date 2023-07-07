package backoffice.backoffice;


import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class TestController {

    public static final Logger logger = LogManager.getLogger(TestController.class);

    @ResponseBody
    @RequestMapping("")
    public String test(HttpServletRequest http){
        logger.info("api called");
        return "test";
    }
}
