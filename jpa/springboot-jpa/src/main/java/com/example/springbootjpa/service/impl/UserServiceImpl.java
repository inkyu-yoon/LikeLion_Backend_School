package com.example.springbootjpa.service.impl;

import com.example.springbootjpa.dto.UserFindDto;
import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.repository.UserRepository;
import com.example.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserFindDto findUser(Long number) {
        User foundUser = userRepository.findById(number).get();
        UserFindDto user = new UserFindDto();

        return null;
    }
}
