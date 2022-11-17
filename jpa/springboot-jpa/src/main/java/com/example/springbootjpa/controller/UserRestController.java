package com.example.springbootjpa.controller;


import com.example.springbootjpa.dto.UserAddRequestDto;
import com.example.springbootjpa.dto.UserAddResponseDto;
import com.example.springbootjpa.dto.UserFindDto;
import com.example.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFindDto> find(@PathVariable(name = "id") Long id) {
        UserFindDto user = userService.findUser(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("")
    public ResponseEntity<UserAddResponseDto> add(@RequestBody UserAddRequestDto userAddRequestDto) {
        UserAddResponseDto addUser = userService.add(userAddRequestDto);
        return ResponseEntity.ok().body(addUser);

    }
}

