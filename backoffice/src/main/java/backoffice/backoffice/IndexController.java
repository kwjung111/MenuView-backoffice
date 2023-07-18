package backoffice.backoffice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController {

    //리디렉션 수행 컨트롤러


    @RequestMapping("")
    public void homeRedirection(HttpServletRequest http, HttpServletResponse res)throws Exception{
        //TODO 로그인 여부 분기처리 필요
        res.sendRedirect("/login");
    }

}
