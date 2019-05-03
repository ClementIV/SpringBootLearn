package com.example.lesson3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 在启动类中看到ServerLetComponentScan 注解，
 * 该注解的作用是启动项目时扫描本包及其子包带有的WebsServlet, WebFilter和WebListener注解的类
 * 进行Servlet,Filter和Listener自动注册
 */
@SpringBootApplication
@ServletComponentScan
public class Lesson3Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson3Application.class, args);
    }

}
