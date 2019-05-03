package com.example.lesson3.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ListenerSpring implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(ListenerSpring.class);
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        logger.info("FilterSpring requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        logger.info("FilterSpring requestInitialized");
    }
}
