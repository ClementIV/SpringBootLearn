package com.example.myrest.lesson4.lesson4myrest.controller;

import com.example.myrest.lesson4.lesson4myrest.dao.UserDao;
import com.example.myrest.lesson4.lesson4myrest.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    // 新增一个用户信息
    @PostMapping("/user")
    public Map<String, Object> addUser(User user){
        Map<String,Object> response = new HashMap<>();
        response.put("code","000000");
        response.put("body",userDao.addUser(user));
        logger.info("-- add user --");
        return response;
    }

    //根据用户Id获取用户信息
    @GetMapping("/user/{id}")
    public Map<String,Object> getUser(@PathVariable Integer id){
        Map<String,Object> response = new HashMap<>();
        response.put("code","000000");
        response.put("body",userDao.getUser(id));
        logger.info("--get User--");
        return response;
    }

    //获取所有的用户信息
    @GetMapping("/user")
    public Map<String,Object> listUser(){
        Map<String,Object> response = new HashMap<>();
        response.put("code","000000");
        response.put("body",userDao.listUser());

        logger.info("--listUser--");
        return response;
    }

    //根据用户id更新用户信息
    @PutMapping("/user")
    public Map<String,Object> updateUser(User user){
        Map<String,Object> response = new HashMap<>();
        response.put("code","000000");
        response.put("body",userDao.updateUser(user));
        logger.info("---Update User---");

        return response;
    }

    @DeleteMapping("/user/{id}")
    public Map<String,Object> deleteUser(@PathVariable Integer id){
        Map<String,Object> response = new HashMap<>();
        response.put("code","00000000");
        response.put("body",userDao.deleteUser(id));
        logger.info("-- delete User --");

        return response;
    }
}
