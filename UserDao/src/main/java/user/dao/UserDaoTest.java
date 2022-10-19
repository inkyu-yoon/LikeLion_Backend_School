package user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import user.ConnectionMaker.ConnectionMaker;
import user.ConnectionMaker.DConnectionMaker;
import user.UserDaoConfig;
import user.domain.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(UserDaoConfig.class);
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        userDao.add(new User("id", "name", "password"));
        System.out.println(userDao.getById("id").getName());
        userDao.delete();

    }
}
