package com.example.lesson3.j2ee;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class ListenerAnnotation implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(ListenerAnnotation.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("requestInitialized");
    }

}
