package com.springboot.likelionspringboot.dao;

import com.springboot.likelionspringboot.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
            return user;
        }
    };

    public void add(User user) {
        jdbcTemplate.update("INSERT INTO USERS(id,name,password) VALUES (?,?,?)", user.getId(), user.getName(), user.getPassword());
    }

    public void delete(String id) {
        jdbcTemplate.update("DELETE FROM USERS WHERE id = ?", id);
    }
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM USERS");
    }

    public List<User> selectAll() {
       return jdbcTemplate.query("SELECT * FROM USERS", rowMapper);
    }

    public User selectById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE ID = ? ", rowMapper,id);
    }

}
