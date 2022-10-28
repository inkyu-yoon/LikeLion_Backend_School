package com.springboot.likelionspringboot.controller;

import com.springboot.likelionspringboot.dao.UserDao;
import com.springboot.likelionspringboot.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("users")
    public void add(@RequestBody Map<String, String> postData) {

        User user = new User(postData.get("id"), postData.get("name"), postData.get("password"));
        userDao.add(user);

        System.out.println(user + "등록하였습니다.");

    }

    @DeleteMapping("users/{id}")
    public String deleteid(@PathVariable String id) {
        userDao.delete(id);
        return id;
    }

    @DeleteMapping("users/deleteAll")
    public void deleteAll() {
        userDao.deleteAll();

    }
}
