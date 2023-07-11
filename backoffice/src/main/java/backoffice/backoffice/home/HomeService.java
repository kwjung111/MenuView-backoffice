package backoffice.backoffice.home;

import backoffice.backoffice.mappers.HomeMapper;
import jakarta.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HomeService {

    public static final Logger logger = LogManager.getLogger(HomeService.class);

    @Resource
    private SqlSessionTemplate session;

    @Autowired
    PasswordEncoder passwordEncoder;

    public int signUpSvc(HashMap<String,String> reqParam){
        logger.info("signupSvc called");
        String username = reqParam.get("username");
        HomeMapper mapper = session.getMapper(HomeMapper.class);

        try {
            HashMap<String, Object> hMap = mapper.findByusername(username);
        }
        catch(Exception e){
            logger.error("duplicated member exists");
            return 0;
        }

        String pwd = reqParam.get("password");

        String encodedPwd = passwordEncoder.encode(pwd);

        reqParam.put("password",encodedPwd);

        int result = mapper.signUp(reqParam);

        return result;
    }
}
