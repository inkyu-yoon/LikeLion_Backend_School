package com.springboot.likelionspringboot.controller;

import com.springboot.likelionspringboot.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("{var}")
    public String getvar(@PathVariable String var) {

        return var;
    }

    //http://localhost:8080/api/v1/get-api/request?name=윤인규&email=tryingmybest24h@gmail.com&organization=LikeLion
    @GetMapping("/request")
    public String getRP(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    @GetMapping("request2")
    public String getRP2(@RequestParam Map<String, String> RP) {
        StringBuilder sb = new StringBuilder();
        RP.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("request3")
    public String getRP3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
