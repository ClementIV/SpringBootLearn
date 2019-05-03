package com.example.lesson3.j2ee;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName= "filterAnnotation", urlPatterns="/*")
public class FilterAnnotation implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(FilterAnnotation.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        logger.info("FilterAnnotation request uri = " + req.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
