package com.example.springbootjpa.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserAddResponseDto {
    private String username;
    private String message;
}
