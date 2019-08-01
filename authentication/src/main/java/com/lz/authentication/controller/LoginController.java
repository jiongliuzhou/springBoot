package com.lz.authentication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 登录界面
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Controller
@Slf4j
public class LoginController {
    @Resource
    @Lazy
    private TokenStore tokenStore;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


}
