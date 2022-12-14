package com.example.springbootjpa.dto;


import com.example.springbootjpa.entity.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserAddRequestDto {
    private String username;
    private String password;

    public User toEntity() {
        return User.builder().username(this.username).password(this.password).build();
    }

}
