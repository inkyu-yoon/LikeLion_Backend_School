package user;

import user.ConnectionMaker.ConnectionMaker;
import user.ConnectionMaker.DConnectionMaker;
import user.ConnectionMaker.NConnectionMaker;
import user.dao.UserDao;

public class UserDaoConfig {

    public UserDao NUserDao() {
        ConnectionMaker nConnectionMaker = new NConnectionMaker();
        UserDao userDao = new UserDao(nConnectionMaker);
        return userDao;
    }

    public UserDao DUserDao() {
        ConnectionMaker dConnectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(dConnectionMaker);
        return userDao;
    }


}
