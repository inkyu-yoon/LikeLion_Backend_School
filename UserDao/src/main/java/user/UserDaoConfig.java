package user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import user.ConnectionMaker.ConnectionMaker;
import user.ConnectionMaker.DConnectionMaker;

import user.dao.UserDao;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class UserDaoConfig {

    @Bean
    public UserDao userDao() {
        return new UserDao(dataSource()); //Dconnection이 들어간 userDao가 반환
    }
    //참고로 지금 userDao는 어떠한 구현 클래스도 의존하고 있지 않다. 매개변수로 쓰이는 객체는 인터페이스이기 때문이다.
    // userDao는 Dconnection 클래스가 존재하는지조차 모르는 상태이다.
    @Bean
    public DataSource dataSource(){
        Map<String, String> env = System.getenv();

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(env.get("DB_HOST"));
        dataSource.setUsername(env.get("DB_USER"));
        dataSource.setPassword(env.get("DB_PASSWORD"));
        return dataSource;
    }


    @Bean
    public ConnectionMaker realConnectionMaker(){
        return new DConnectionMaker();
    }
}

