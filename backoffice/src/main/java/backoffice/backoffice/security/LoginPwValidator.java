package backoffice.backoffice.security;

import backoffice.backoffice.cmmn.CmmnController;
import backoffice.backoffice.mappers.HomeMapper;
import backoffice.backoffice.support.SqlSessionSupport;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Service
public class LoginPwValidator extends SqlSessionSupport implements UserDetailsService {

    public static final Logger logger = LogManager.getLogger(LoginPwValidator.class);

    @Autowired
    private HomeMapper mapper;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //실질적으으로 비밀번호를 비교함

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //유저가 있는지만 확인함

        HashMap<String,Object> userInfo = mapper.findByusername(username);

        logger.info("username is " + username);

        if(userInfo == null) {
            return null;
        }
            String password = userInfo.get("password").toString();
            String role     = userInfo.get("role").toString();

            return User.builder()
                    .username(username)
                    .password(password)
                    .roles(role)
                    .build();
    }


}
