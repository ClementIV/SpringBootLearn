package com.example.springbootdemo.modules.Dto;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;

    private int age;

    private String addr;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void setAddr(String addr){
        this.addr = addr;
    }
    public String getAddr(){
        return addr;
    }

}
