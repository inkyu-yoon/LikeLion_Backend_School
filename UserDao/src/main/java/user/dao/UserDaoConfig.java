package user.dao;

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
