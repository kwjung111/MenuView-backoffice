package backoffice.backoffice.home;

import backoffice.backoffice.cmmn.CmmnController;
import backoffice.backoffice.mappers.HomeMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController extends CmmnController {
    public static final Logger logger = LogManager.getLogger(HomeController.class);

    @Resource
    private SqlSessionTemplate session;

    @Autowired
    HomeService homeservice;

    //로그인페이지로 리디렉션
    @RequestMapping("")
    public void homeRedirection(HttpServletRequest http,HttpServletResponse res)throws Exception{
        logger.info("user entered");
        //로그인 여부 분기처리 필요
        res.sendRedirect("/login");
    }
    
    //로그인 페이지
    @RequestMapping("/login")
    public String homeView(HttpServletRequest http){
        //로그인 여부 분기처리 필요
        logger.info("home");
        return "home/home";
    }

    @ResponseBody
    @RequestMapping("/logintest")
    public Object logintest(HttpServletRequest request, HttpServletResponse response){
        logger.info("api called");

        Map<String,String> reqParam = getRequestedParam(request);

        String username = reqParam.get("username");

        HomeMapper mapper = session.getMapper(HomeMapper.class);
        System.out.println(reqParam);
        HashMap<String,Object> hMap = mapper.findByusername(username);

        return hMap;
    }

    @RequestMapping("/signUp")
    public String signUpView(HttpServletRequest request, HttpServletResponse response){
        logger.info("singUp page");
        return "home/signUp";
    }

    @RequestMapping(value = "/signUp",method= RequestMethod.POST)
    @ResponseBody
    public int signUp(HttpServletRequest request, HttpServletResponse response ){

        HashMap<String,String> reqParam = (HashMap<String, String>) getRequestedParam(request);

        int res = homeservice.signUpSvc(reqParam);

        return res;
    }


}
