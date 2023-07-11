package backoffice.backoffice;


import backoffice.backoffice.support.SqlSessionSupport;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class TestController extends SqlSessionSupport {

    public static final Logger logger = LogManager.getLogger(TestController.class);

    @ResponseBody
    @RequestMapping("")
    public Object test(HttpServletRequest http){
        logger.info("api called");
        //json 형태로 리턴(ResposeBody 어노테이션 필요)
        List<Map<String,Object>> resList =  new ArrayList<Map<String,Object>>();
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("ctnt","test");
        resList.add(res);
        return resList;
    }

    @ResponseBody
    @RequestMapping("/login")
    public Object logintest(HttpServletRequest http){
        logger.info("api called");
        HashMap<String,Object> hMap = new HashMap<String,Object>();
        Object ret = selectDataSource("mappers.loginMapper.login", hMap);
        return ret;
    }
}
