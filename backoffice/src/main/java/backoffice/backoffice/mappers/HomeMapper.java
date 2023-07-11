package backoffice.backoffice.mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface HomeMapper {

    public HashMap<String,Object> findByusername(String username);

    public int signUp(HashMap<String,String> param);
}
