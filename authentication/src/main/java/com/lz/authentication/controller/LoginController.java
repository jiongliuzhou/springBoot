package com.lz.authentication.controller;

import com.lz.authentication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * 登录界面
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Controller
public class LoginController {
    @Resource(name="userServiceImpl")
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
