package com.lz.member.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 *  自定义ServletRequestListener
 * @author lz
 * @create 2019/7/19
 * @since 1.0.0
 */
@Slf4j
@WebListener
public class MyServletRequestListener implements ServletRequestListener{
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.debug("====================MyServletRequestListener requestDestroyed====================");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        log.debug("====================MyServletRequestListener requestInitialized====================");
    }
}
