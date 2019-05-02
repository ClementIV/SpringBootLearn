package com.example.springbootdemo.modules.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping("/sayHi")
    public Map<String,String> sayHi2SpringBoot(){
        Map<String,String> resp = new HashMap<>();
        resp.put("code","0000000");
        resp.put("msg","hello world Spring Boot");
        return resp;
    }
}
