package com.springboot.hello.HelloController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class hello {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {

        return "hello Test";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "Inkyu";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }
}
