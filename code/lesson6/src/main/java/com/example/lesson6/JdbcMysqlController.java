package com.example.lesson6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JdbcMysqlController {
    @Value("${jdbc.mysql.username}")
    private String username;

    @Value("${jdbc.mysql.password}")
    private String password;

    @Value("${jdbc.mysql.url}")
    private String url;

    @RequestMapping("/getJdbcMysqlInfo")
    public Map<String,String> getJdbcMysqlInfo(){
        Map<String,String> response = new HashMap<>();
        response.put("username",username);
        response.put("password",password);
        response.put("url",url);
        return response;
    }
}
