package backoffice.backoffice.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("backoffice.backoffice.mappers")
public class MybatisConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public DataSource DataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.mariadb.jdbc.Driver")
                .url("jdbc:mariadb://43.201.232.98:9999/menudb?characterEncoding=UTF-8&serverTimezone=UTC")
                .username("kwjung")
                .password("123456")
                .build();
    }
    //application.properties 의 datasource 불러옴
    //왜 안됨?

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource); //의존성 주입
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mappers/**/*.xml"));
        //sqlSessionFactoryBean.setTypeAliasesPackage("com.example.demo.dto");

        return sqlSessionFactoryBean.getObject();
    }

    /*
        @Bean
        public MapperFactoryBean<Mapper> (SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    //session 을 구현, 코드에서 sqlSession 을 대체
}
