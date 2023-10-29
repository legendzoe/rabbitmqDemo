package com.example.springbootdemo.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/example")
public class TestController {

    @GetMapping("/test")
    public String getStr() {
        return "hello word";
    }

}
