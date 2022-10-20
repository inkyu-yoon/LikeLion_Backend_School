package user.dao;

import user.ConnectionMaker.ConnectionMaker;
import user.domain.User;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {


    private ConnectionMaker connectionMaker;
    private DataSource dataSource;
    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
    //매개변수로 입력받아야 추상화할 수 있다. 객체를 생성할때, 직접 넣어주는 방법이 아니면, 구현클래스를 사용할 수 밖에 없게 됨

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void add(User user) throws ClassNotFoundException, SQLException {

        Connection c = connectionMaker.makeConnection();
        //mysql이랑 연결

        PreparedStatement ps = c.prepareStatement("INSERT INTO userdao.users(id,name,password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        //insert 문에서 사용
        ps.close();
        c.close();

    }

    public User getById(String id) throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM userdao.users where id = ?");

        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));
        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("DELETE FROM userdao.users");
        ps.executeUpdate();
        ps.close();
        c.close();

    }
    public void deleteById(String id) throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("DELETE FROM userdao.users WHERE id = ?");
        ps.setString(1, id);
        ps.executeUpdate();
        ps.close();
        c.close();

    }

    public int getCount() throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) as count FROM userdao.users");
        ResultSet rs = ps.executeQuery();

        rs.next();
        int count = Integer.valueOf(rs.getString("count"));
        rs.close();
        ps.close();
        c.close();
        return count;
    }
}
