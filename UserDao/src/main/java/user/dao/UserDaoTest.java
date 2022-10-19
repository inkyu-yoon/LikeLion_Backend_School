package user.dao;

import user.ConnectionMaker.ConnectionMaker;
import user.ConnectionMaker.DConnectionMaker;
import user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker1 = new DConnectionMaker();
        UserDao dao = new UserDao(connectionMaker1);

        User user = new User();
        user.setId("tryss");
        user.setName("윤인규");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId());

    }
}
