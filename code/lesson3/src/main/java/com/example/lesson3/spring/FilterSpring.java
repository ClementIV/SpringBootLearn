package com.example.lesson3.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 多个过滤器执行顺序，以过滤的.java名字排序，字典顺序决定执行顺序，所以在定义FilterChain一定要注意这个规则。
 */
public class FilterSpring implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(FilterSpring.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        logger.info("FilterSpring request uri = " + req.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
