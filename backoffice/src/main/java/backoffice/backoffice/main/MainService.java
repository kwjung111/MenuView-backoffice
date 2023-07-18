package backoffice.backoffice.main;

import jakarta.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.HashMap;

@Service
public class MainService {
    public static final Logger logger = LogManager.getLogger(MainService.class);

    @Resource
    private SqlSessionTemplate session;

    public HashMap<String,Object> getUserInfo(){
        HashMap<String,Object> res = new HashMap<String,Object>();
        Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = principal.getName();
        logger.info(username);
        return  res;
    }


}
