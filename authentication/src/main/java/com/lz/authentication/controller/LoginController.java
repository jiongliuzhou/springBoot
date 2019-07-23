package com.lz.authentication.controller;

import com.lz.base.util.exception.ExceptionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录界面
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        // token can be revoked here if needed
        new SecurityContextLogoutHandler().logout(request, null, null);
        try {
            //sending back to client
            response.sendRedirect(request.getHeader("referer"));
        } catch (IOException e) {
            log.error(ExceptionHelper.dealException(e));
        }
    }

}
