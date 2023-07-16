package backoffice.backoffice.mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface HomeMapper {

    public HashMap<String,Object> findByusername(String username);

    public HashMap<String,Object> getUserAuth(String username);

    public int signUp(HashMap<String,Object> param);

    public int signUpAuth(String mbrSeq);

    public HashMap<String,Object> findId(HashMap<String,Object> param);


}
