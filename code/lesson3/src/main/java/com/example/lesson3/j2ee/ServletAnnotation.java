package com.example.lesson3.j2ee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name="servletAnnotation", urlPatterns={"/servletAn"})
public class ServletAnnotation extends HttpServlet {

    private static final long serialVersionUID = 5577350050812857689L;

    private static final Logger logger = LoggerFactory.getLogger(ServletAnnotation.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("name = {}", req.getParameter("name"));
        resp.getWriter().write("request ok");
    }

}
