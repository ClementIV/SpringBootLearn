package com.example.lesson3;

import com.example.lesson3.spring.FilterSpring;
import com.example.lesson3.spring.ListenerSpring;
import com.example.lesson3.spring.ServletSpring;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;

import java.util.EventListener;

@Configuration
public class BeanConfig {

    @Bean
    public ServletRegistrationBean<Servlet> getFervletSpring(){
        ServletRegistrationBean<Servlet> servletSpring = new ServletRegistrationBean<>(new ServletSpring());
        servletSpring.addUrlMappings("/servletSpring");//访问路径映射
        return servletSpring;
    }

    @Bean
    public FilterRegistrationBean<Filter> getFilterSpring(){
        FilterRegistrationBean<Filter> filterSpring = new FilterRegistrationBean<>(new FilterSpring());
        filterSpring.addUrlPatterns("/servletSpring");//拦截路径映射
        return filterSpring;
    }

    @Bean
    public ServletListenerRegistrationBean<EventListener> getListenerSpring(){
        ServletListenerRegistrationBean<EventListener> listenerSpring = new ServletListenerRegistrationBean<EventListener>(new ListenerSpring());
        return listenerSpring;
    }

}
