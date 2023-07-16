package backoffice.backoffice.security;

import backoffice.backoffice.mappers.HomeMapper;
import backoffice.backoffice.support.SqlSessionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class LoginPwValidator extends SqlSessionSupport implements UserDetailsService {

    public static final Logger logger = LogManager.getLogger(LoginPwValidator.class);

    @Autowired
    private HomeMapper mapper;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //단방향 패스워드 암호화

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //유저가 있는지만 확인함

        UserDetailsVO userDetails = new UserDetailsVO();

        HashMap<String,Object> userInfo = mapper.findByusername(username);

        HashMap<String,Object> authInfos = mapper.getUserAuth(username);

        List<String> authorities = new ArrayList<String>();

        authorities.add(authInfos.get("role").toString());

        logger.info("username is " + username);

        if(userInfo == null) {
            return null;
        }
        userDetails.setUsername(userInfo.get("username").toString());
        userDetails.setPassword(userInfo.get("password").toString());
        userDetails.setName(userInfo.get("name").toString());
        userDetails.setAuthorities(authorities);
        logger.info("user authorities : " + authorities);
            return userDetails;
    }


}
