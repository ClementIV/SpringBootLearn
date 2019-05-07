package com.example.myrest.lesson4.lesson4myrest.dao;

import com.example.myrest.lesson4.lesson4myrest.model.User;

import java.util.List;

public interface UserDao {
    Integer addUser(User user);

    User getUser(Integer id);

    List<User> listUser();

    Integer updateUser(User user);

    Integer deleteUser(Integer id);
}
