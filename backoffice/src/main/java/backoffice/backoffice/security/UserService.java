package backoffice.backoffice.security;

import backoffice.backoffice.mappers.HomeMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service
public class UserService {

    @Autowired
    private HomeMapper mapper;

    private static final Logger logger = LogManager.getLogger(UserService.class);

    private void validateDuplicateMember(Map<String,String> param) {

        String username = param.get("username");

        Map<String,Object> findedUser = mapper.findByusername(username);
        if (findedUser != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

}
