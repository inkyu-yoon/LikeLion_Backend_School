package com.springboot.likelionspringboot.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/post-api")
public class PostController {
    @PostMapping("member") //member 요청이 들어오면 아래 메서드가 실행
    public String post(@RequestBody Map<String, Object> postData) { //RequestBody 는 Body의 내용을 보고 변수를 매핑해줌
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }
}
