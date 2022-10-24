package user.dao;

import user.ConnectionMaker.ConnectionMaker;
import user.Jdbc.JdbcContext;
import user.StatementStrategy.*;
import user.domain.User;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDao {

    private DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public void add(final User user) throws ClassNotFoundException, SQLException {
        JdbcContext jdbcContext = new JdbcContext(dataSource);

        jdbcContext.StatementStrategyForUpdate(new StatementStrategy() {
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("INSERT INTO users(id,name,password) values(?,?,?)");
                ps.setString(1, user.getId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword());
                //내부 클래스라서 User를 생성자로 입력 안받아도 바로 사용할 수 있다는 장점이 있다.
                return ps;
            }
        });

        //메서드(new 인터페이스() {구현부} ) 익명 클래스로 사용, 생성자로 입력받지 않아도, 여러 변수들을 공유할 수 있는 장점이 있다.
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        JdbcContext jdbcContext = new JdbcContext(dataSource);

        jdbcContext.StatementStrategyForUpdate(new StatementStrategy() {
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("delete from users");
                return ps;
            }
        });
    }


    public int getCount() throws SQLException, ClassNotFoundException {
        JdbcContext jdbcContext = new JdbcContext(dataSource);
        StatementStrategy st = new CountStatement();
        ArrayList<HashMap<String, Object>> list = jdbcContext.StatementStrategyForExecute(st);
        System.out.println(list);
        return Integer.valueOf(String.valueOf(list.get(0).get("count")));
    }


    public User getById(String id) throws SQLException, ClassNotFoundException {
        JdbcContext jdbcContext = new JdbcContext(dataSource);
        StatementStrategy st = new SelectStatement(id);
        ArrayList<HashMap<String, Object>> list = jdbcContext.StatementStrategyForExecute(st);
        User user = null;
        if (list.size() != 0) {
            user = new User();
            user.setId(String.valueOf(list.get(0).get("id")));
            user.setName(String.valueOf(list.get(0).get("name")));
            user.setPassword(String.valueOf(list.get(0).get("password")));
        }

        if (user == null) throw new NullPointerException();

        return user;
    }

}
