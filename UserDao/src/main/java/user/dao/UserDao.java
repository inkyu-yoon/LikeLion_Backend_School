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

        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }

        rs.close();
        ps.close();
        c.close();

        if (user == null) throw new NullPointerException();

        return user;
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = connectionMaker.makeConnection();
            ps = c.prepareStatement("DELETE FROM userdao.users");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {

                }
            }
        }

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
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c= connectionMaker.makeConnection();
            ps = c.prepareStatement("SELECT COUNT(*) as count FROM userdao.users");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt("count");
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {

                }
            }
        }


    }
}
