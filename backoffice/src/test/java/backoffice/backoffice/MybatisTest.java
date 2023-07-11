package backoffice.backoffice;

import backoffice.backoffice.support.SqlSessionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class MybatisTest extends SqlSessionSupport {

    public static final Logger logger = LogManager.getLogger(MybatisTest.class);

    /*
    @Test
    public void MapperTest(){
        logger.info("mybatisTest");
        HashMap<String,Object> hMap = new HashMap<String,Object>();
        Object ret = selectDataSource("testMapper.test", hMap);
        System.out.println(ret);
    }
    */

}
