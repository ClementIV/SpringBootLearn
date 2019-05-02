package com.example.springbootdemo.modules.Dto;

import java.io.Serializable;

public class UserDto implements Serializable {


    private String userName;

    private String position;

    private int age;


    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setPositon (String position){
        this.position = position;
    }

    public String getPositon (){
        return position;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}
