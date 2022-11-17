package com.example.springbootjpa.dto;


import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFindDto {
    private Long id;
    private String username;
    private String message;
}
