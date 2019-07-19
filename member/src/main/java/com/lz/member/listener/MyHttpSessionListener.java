package com.lz.member.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 自定义HttpSessionListener
 * @author lz
 * @create 2019/7/19
 * @since 1.0.0
 */
@Slf4j
@WebListener
public class MyHttpSessionListener implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("====================MyHttpSessionListener Created====================");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("====================MyHttpSessionListener Destroyed====================");
    }
}
