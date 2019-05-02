package com.example.springbootdemo.modules.Controllers;

import com.example.springbootdemo.modules.Dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String test(){
        return "hello";
    }

    @RequestMapping(value="/getUserMap")
    public String getUserMap(Map<String,Object> map){
        UserDto dto = new UserDto();
        dto.setUserName("java 乐园");
        dto.setAge(30);
        dto.setPositon("cto");
        map.put("user",dto);

        return "getUserMap";
    }

    @RequestMapping("/sayHi")
    public Map<String,String> sayHi2SpringBoot(){
        Map<String,String> resp = new HashMap<>();
        resp.put("code","0000000");
        resp.put("msg","hello world Spring Boot");
        return resp;
    }
}
