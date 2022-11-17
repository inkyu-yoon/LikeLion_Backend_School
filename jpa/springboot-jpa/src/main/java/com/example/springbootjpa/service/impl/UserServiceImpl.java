package com.example.springbootjpa.service.impl;

import com.example.springbootjpa.dto.UserAddRequestDto;
import com.example.springbootjpa.dto.UserAddResponseDto;
import com.example.springbootjpa.dto.UserFindDto;
import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.repository.UserRepository;
import com.example.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserFindDto findUser(Long number) {
        Optional<User> optUser = userRepository.findById(number);
        if (optUser.isEmpty()) {
            return new UserFindDto(number, "", "해당 id 유저가 없습니다.");
        } else {
            User foundUser = optUser.get();
            return new UserFindDto(foundUser.getId(), foundUser.getUsername(), foundUser.getPassword());
        }

    }

    @Override
    public UserAddResponseDto add(UserAddRequestDto userAddRequestDto) {
        List<User> all = userRepository.findAll();
        for (User user : all) {
            if (user.getUsername().equals(userAddRequestDto.getUsername())) {
                return new UserAddResponseDto("", "해당 id는 중복입니다.");
            }
        }
        User savedUser = userRepository.save(userAddRequestDto.toEntity());
        UserAddResponseDto userAddResponseDto = new UserAddResponseDto();
        userAddResponseDto.setUsername(savedUser.getUsername());
        userAddResponseDto.setMessage("가입이 완료 되었습니다.");

        return userAddResponseDto;
    }
}
