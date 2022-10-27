package com.springboot.likelionspringboot.controller;

import com.springboot.likelionspringboot.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping("member")
    public String putMap(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(m -> {
            sb.append(m.getKey() + " : " + m.getValue() + "\n");
        });
        return sb.toString();
        //DTO의 경우, toString()을 오버라이딩 하고 return을 객체.toString() 으로 하면, text/pain값이 나오고
        // 그냥 객체를 반환하게끔 하면, 객체의 변수와 변수에 초기화된 데이터가 JSON의 형태로 나타나게 되는데, 이는 @ResponseBody의 역할이며
        //ResponseBody는 RestController 에 있다.
    }

    @PutMapping("member3")
    public ResponseEntity<MemberDto> postMemberDto(@RequestBody MemberDto memberDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
}
