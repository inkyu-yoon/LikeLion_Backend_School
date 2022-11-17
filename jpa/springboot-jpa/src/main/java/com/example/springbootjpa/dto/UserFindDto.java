package com.example.springbootjpa.dto;


import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFindDto {
    private String id;
    private String username;
}
