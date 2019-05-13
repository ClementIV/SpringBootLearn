package com.example.lesson10.dao;

import com.example.lesson10.dto.UserDto;

import java.util.List;

public interface UserDao {
    int save(UserDto user);

    int update(UserDto user);

    int delete(Integer id);

    List<UserDto> findAll();

    UserDto getUser(Integer id);
}
