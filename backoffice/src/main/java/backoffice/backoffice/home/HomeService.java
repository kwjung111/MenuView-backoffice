package backoffice.backoffice.home;

import backoffice.backoffice.mappers.HomeMapper;
import jakarta.annotation.Resource;
import jakarta.mail.internet.MimeMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class HomeService {

    public static final Logger logger = LogManager.getLogger(HomeService.class);

    @Resource
    private SqlSessionTemplate session;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender javaMailSender;

    public int signUpSvc(HashMap<String,String> reqParam){
        logger.info("signupSvc called");
        HomeMapper mapper = session.getMapper(HomeMapper.class);

        String username = reqParam.get("username");

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

    public HashMap<String,Object> findIdSvc(HashMap<String,String> reqParam){
        logger.info("findIdSvc called");
        HomeMapper mapper = session.getMapper(HomeMapper.class);
        HashMap<String,Object> res = new HashMap<String,Object>();
        String username = null;
        if(mapper.findId(reqParam) != null) {
            username = (String) mapper.findId(reqParam).get("username");
        }

        res.put("username",username);
        return res;
    }
    
    //회원가입 이메일인증
    public HashMap<String,Object> signUpVerifySvc(HashMap<String,String> reqParam){
        logger.info("signUpVerifySvc called");
        HashMap<String,Object> res = new HashMap<String,Object>();

        String authNum = createCode();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        SimpleMailMessage message = new SimpleMailMessage();
        
        //TODO 이메일 인증 로직 구현 필요

        return res;
    }

    // 인증번호 및 임시 비밀번호 생성 메서드
    private String createCode() {
        Random random = new Random();
        StringBuffer key = new StringBuffer();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(4);

            switch (index) {
                case 0: key.append((char) ((int) random.nextInt(26) + 97)); break;
                case 1: key.append((char) ((int) random.nextInt(26) + 65)); break;
                default: key.append(random.nextInt(9));
            }
        }
        return key.toString();
    }
}
