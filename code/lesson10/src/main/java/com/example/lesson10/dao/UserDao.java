package com.example.lesson10.dao;

import com.example.lesson10.dto.UserDto;

import java.util.List;

public interface UserDao {
    public int save(UserDto user );

    public int update(UserDto user);

    public int delete(Integer id);

    List<UserDto> findAll();

    UserDto getUser(Integer id);
}
