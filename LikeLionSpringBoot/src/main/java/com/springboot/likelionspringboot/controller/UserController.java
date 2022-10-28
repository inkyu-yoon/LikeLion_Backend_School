package com.springboot.likelionspringboot.controller;

import com.springboot.likelionspringboot.dao.UserDao;
import com.springboot.likelionspringboot.domain.User;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Entity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("add")
    public void add(@RequestBody Map<String, String> postData) {

        User user = new User(postData.get("id"), postData.get("name"), postData.get("password"));
        userDao.add(user);

        System.out.println(user + "등록하였습니다.");

    }

    @DeleteMapping("{id}")
    public String deleteid(@PathVariable String id) {
        userDao.delete(id);
        return id;
    }

    @DeleteMapping("deleteAll")
    public void deleteAll() {
        userDao.deleteAll();

    }

    @GetMapping("selectAll")
    public String selectAll() {
        StringBuilder sb = new StringBuilder();
        List<User> users = userDao.selectAll();
        for (User user : users) {
            sb.append(user);
        }
        return sb.toString();
    }
}
