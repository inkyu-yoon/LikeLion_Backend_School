package user.dao;

import user.ConnectionMaker.ConnectionMaker;
import user.StatementStrategy.AddStatement;
import user.StatementStrategy.CountStatement;
import user.StatementStrategy.DeleteAllStatement;
import user.StatementStrategy.StatementStrategy;
import user.domain.User;

import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class UserDao {

    private ConnectionMaker connectionMaker;
    private ResultSet rs = null;
    int count;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
    //매개변수로 입력받아야 추상화할 수 있다. 객체를 생성할때, 직접 넣어주는 방법이 아니면, 구현클래스를 사용할 수 밖에 없게 됨

    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException, ClassNotFoundException {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = connectionMaker.makeConnection();
            ps = stmt.makePreparedStatement(c);
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
        }
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {

            }
        }

    }

    public ArrayList<HashMap<String,Object>> jdbcContextWithStatementStrategyForExecute(StatementStrategy stmt) throws SQLException, ClassNotFoundException {

        Connection c = null;
        PreparedStatement ps = null;
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        try {
            c = connectionMaker.makeConnection();
            ps = stmt.makePreparedStatement(c);
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            System.out.println("md = " + md);
            int columns = md.getColumnCount();
            System.out.println("columns = " + columns);
            while(rs.next()){
                HashMap<String, Object> row = new HashMap<>(columns);
                for (int i = 1; i <= columns; i++) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(row);
            }

            return list;
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

    public int getCount() throws SQLException, ClassNotFoundException {
        StatementStrategy st = new CountStatement();
        ArrayList<HashMap<String, Object>> list = jdbcContextWithStatementStrategyForExecute(st);
        System.out.println(list);
        return Integer.valueOf(String.valueOf(list.get(0).get("count")));

    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy st = new AddStatement(user);
        jdbcContextWithStatementStrategy(st);
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        StatementStrategy st = new DeleteAllStatement();
        jdbcContextWithStatementStrategy(st);
    }

    public User getById(String id) throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM users where id = ?");
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


}
