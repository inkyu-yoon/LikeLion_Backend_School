package com.example.springbootjpa.service;

import com.example.springbootjpa.dto.UserFindDto;

public interface UserService {

    UserFindDto findUser(Long number);
}
