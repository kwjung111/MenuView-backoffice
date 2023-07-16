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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
//TODO 회원탈퇴 로직 만들어야됨
//TODO 트랜잭션 적용 필요
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
        //TODO 로그인 여부 분기처리 필요
        res.sendRedirect("/login");
    }


    //로그인 페이지
    @RequestMapping("/login")
    public String loginView(HttpServletRequest http){
        //로그인 여부 분기처리 필요
        logger.info("home");
        return "home/home";
    }

    //회원가입 페이지
    @RequestMapping("/signUp")
    public String signUpView(HttpServletRequest request, HttpServletResponse response){
        logger.info("singUp page");
        return "home/signUp";
    }


    //ID 찾기
    @RequestMapping("/findId")
    public String findIdView(HttpServletRequest http){
        //로그인 여부 분기처리 필요
        logger.info("findIdView");
        return "home/findId";
    }

    //비밀번호 변경
    //TODO Bcrypt 는 단방향 암호화이기떄문에 찾기 없이 변경 로직 수행
    @RequestMapping("/findPwd")
    public String findPwdView(HttpServletRequest http){
        //로그인 여부 분기처리 필요
        logger.info("findPwdView");
        return "home/findPwd";
    }

    @ResponseBody
    @RequestMapping("/logintest")
    public Object logintest(HttpServletRequest request, HttpServletResponse response){
        logger.info("api called");

        Map<String,Object> reqParam = getRequestedParam(request);
        String username = reqParam.get("username").toString();

        HomeMapper mapper = session.getMapper(HomeMapper.class);
        System.out.println("reqParam : " + reqParam);
        HashMap<String,Object> hMap = mapper.findByusername(username);

        return hMap;
    }
    //TODO 서비스로 뺴기


    @ResponseBody
    @RequestMapping(value = "/signUp",method= RequestMethod.POST)
    public String signUp(HttpServletRequest request, HttpServletResponse response ){

        HashMap<String,Object> reqParam = (HashMap<String, Object>) getRequestedParam(request);
        int res = homeservice.signUpSvc(reqParam);
        String resMsg = null;
        if(res ==1 ){
            resMsg = "가입 성공";
        }
        else{
            resMsg = "회원가입 에러 : 재시도 해주세요";
        }
        return resMsg;
    }

    //ID 찾기
    @ResponseBody
    @RequestMapping(value = "/findId", method=RequestMethod.POST)
    public HashMap<String,Object> findId(HttpServletRequest request,  HttpServletResponse response, @RequestBody HashMap<String,Object> reqParam){
        logger.info("findIdProc");
        HashMap<String,Object> res = homeservice.findIdSvc(reqParam);
        return res;
    }

    //회원가입->이메일인증
    @RequestMapping(value = "/signUp/verify",method= RequestMethod.POST)
    public int signUpVerify(HttpServletRequest request, HttpServletResponse response, @RequestBody HashMap<String,String> reqParam ){
        homeservice.signUpVerifySvc(reqParam);
        return 1;

    }

}
