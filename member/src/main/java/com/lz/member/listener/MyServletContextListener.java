package com.lz.member.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 自定义ServletContextListener
 * @author lz
 * @create 2019/7/19
 * @since 1.0.0
 */
@Slf4j
@WebListener
public class MyServletContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.debug("====================MyServletContextListener contextInitialized====================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.debug("====================MyServletContextListener contextDestroyed====================");
    }
}
