package user.dao;

import user.ConnectionMaker.ConnectionMaker;
import user.StatementStrategy.*;
import user.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;

    }
    //매개변수로 입력받아야 추상화할 수 있다. 객체를 생성할때, 직접 넣어주는 방법이 아니면, 구현클래스를 사용할 수 밖에 없게 됨
    public int getCount() throws SQLException, ClassNotFoundException {
        StatementStrategy st = new CountStatement();
        ArrayList<HashMap<String, Object>> list = StatementStrategyForExecute(st);
        System.out.println(list);
        return Integer.valueOf(String.valueOf(list.get(0).get("count")));
    }


    public void add(final User user) throws ClassNotFoundException, SQLException {

        StatementStrategyForUpdate(new StatementStrategy(){
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("INSERT INTO users(id,name,password) values(?,?,?)");
                ps.setString(1, user.getId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword());
                //내부 클래스라서 User를 생성자로 입력 안받아도 바로 사용할 수 있다는 장점이 있다.
                return ps;
            }
        });
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        StatementStrategyForUpdate(new StatementStrategy() {
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("delete from users");
                return ps;
            }
        });
    }

    public User getById(String id) throws SQLException, ClassNotFoundException {
        StatementStrategy st = new SelectStatement(id);
        ArrayList<HashMap<String, Object>> list = StatementStrategyForExecute(st);
        User user = null;
        if (list.size()!=0) {
            user = new User();
            user.setId(String.valueOf(list.get(0).get("id")));
            user.setName(String.valueOf(list.get(0).get("name")));
            user.setPassword(String.valueOf(list.get(0).get("password")));
        }

        if (user == null) throw new NullPointerException();

        return user;
    }

    public void StatementStrategyForUpdate(StatementStrategy stmt) throws SQLException, ClassNotFoundException {
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

    public ArrayList<HashMap<String, Object>> StatementStrategyForExecute(StatementStrategy stmt) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Connection c = null;
        PreparedStatement ps = null;
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        try {
            c = connectionMaker.makeConnection();
            ps = stmt.makePreparedStatement(c);
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            while (rs.next()) {
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
    }
