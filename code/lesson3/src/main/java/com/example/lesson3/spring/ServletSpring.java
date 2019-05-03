package com.example.lesson3.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletSpring extends HttpServlet {
    private static final long serivalVersionUID = 45646464646L;

    private static final Logger logger = LoggerFactory.getLogger(ServletSpring.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        logger.info("name = {}",request.getParameter("name"));
        response.getWriter().write("request ok");
    }
}
