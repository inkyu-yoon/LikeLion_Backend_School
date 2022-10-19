package user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import user.ConnectionMaker.ConnectionMaker;
import user.ConnectionMaker.DConnectionMaker;
import user.ConnectionMaker.NConnectionMaker;
import user.dao.UserDao;

@Configuration
public class UserDaoConfig {

    @Bean
    public UserDao nUserDao() {
        ConnectionMaker nConnectionMaker = new NConnectionMaker();
        UserDao userDao = new UserDao(nConnectionMaker);
        return userDao;
    }

    @Bean
    public UserDao dUserDao() {
        ConnectionMaker dConnectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(dConnectionMaker);
        return userDao;
    }


}
