package com.springboot.likelionspringboot.dao;

import com.springboot.likelionspringboot.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public void add(User user) {
        jdbcTemplate.update("INSERT INTO USERS(id,name,password) VALUES (?,?,?)", user.getId(), user.getName(), user.getPassword());
    }

    public void delete(String id) {
        jdbcTemplate.update("DELETE FROM USERS WHERE id = ?", id);
    }
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM USERS");
    }


}
