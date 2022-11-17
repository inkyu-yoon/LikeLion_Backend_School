package com.example.springbootjpa.service;

import com.example.springbootjpa.dto.UserAddRequestDto;
import com.example.springbootjpa.dto.UserAddResponseDto;
import com.example.springbootjpa.dto.UserFindDto;

public interface UserService {

    UserFindDto findUser(Long number);

    UserAddResponseDto add(UserAddRequestDto userAddRequestDto);
}
