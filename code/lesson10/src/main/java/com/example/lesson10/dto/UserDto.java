package com.example.lesson10.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Data
public class UserDto {
    @Setter(AccessLevel.PUBLIC)

    private Integer id;
    private String username;
    private String mobileNo;
    private String email;
    private String nickName;
    private String photo;
    private Date  birthday;
}
