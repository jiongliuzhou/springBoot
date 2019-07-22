package com.lz.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 登录界面
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginOut")
    public String logOut(){
        return "loginOut";
    }

}
