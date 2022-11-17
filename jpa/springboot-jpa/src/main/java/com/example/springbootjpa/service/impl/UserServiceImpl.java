package com.example.springbootjpa.service.impl;

import com.example.springbootjpa.dto.UserAddRequestDto;
import com.example.springbootjpa.dto.UserAddResponseDto;
import com.example.springbootjpa.dto.UserFindDto;
import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.repository.UserRepository;
import com.example.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
        user.setId(foundUser.getId());
        user.setUsername(foundUser.getUsername());
        return user;
    }

    @Override
    public UserAddResponseDto add(UserAddRequestDto userAddRequestDto) {
        User savedUser = userRepository.save(userAddRequestDto.toEntity());
        UserAddResponseDto userAddResponseDto = new UserAddResponseDto();
        userAddResponseDto.setUsername(savedUser.getUsername());
        userAddResponseDto.setMessage("가입이 완료 되었습니다");

        return userAddResponseDto;
    }
}
