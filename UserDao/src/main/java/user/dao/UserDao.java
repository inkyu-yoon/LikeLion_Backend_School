package user.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final User user) throws ClassNotFoundException, SQLException {
        jdbcTemplate.update("INSERT INTO users(id,name,password) values(?,?,?)", user.getId(), user.getName(), user.getPassword());
        //메서드(new 인터페이스() {구현부} ) 익명 클래스로 사용, 생성자로 입력받지 않아도, 여러 변수들을 공유할 수 있는 장점이 있다.
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {
        jdbcTemplate.update("delete from users");

    }


    public int getCount() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) AS COUNT FROM USERS";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public User getById(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
                return user;
            }
        };
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
