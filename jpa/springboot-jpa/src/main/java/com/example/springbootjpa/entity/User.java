package com.example.springbootjpa.entity;

import javax.persistence.*;

@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

}
