package com.lz.member.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义过滤器
 * @author lz
 * @create 2019/7/19
 * @since 1.0.0
 */
@Slf4j
@WebFilter
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("===============MyFilter init===============");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.debug("===============MyFilter===============");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.debug("===============MyFilter destroy===============");
    }

}
