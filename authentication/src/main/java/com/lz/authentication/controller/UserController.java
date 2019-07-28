package com.lz.authentication.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lz.api.service.SysUserApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author DELL
 * @create 2019/6/20
 * @since 1.0.0
 */
@RestController
public class UserController {
    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }

    @Reference
    private SysUserApiService sysUserApiService;
    /**
     * 获取用户名
     * @param principal
     * @return
     */
    @RequestMapping("/userController/userName")
    @ResponseBody
    public Object userName(Principal principal) {
        return principal.getName();
    }

    /**
     * 获取当前用户信息
     * @param principal
     * @return
     */
    @RequestMapping("/userController/getUserInfo")
    @ResponseBody
    public Object getUserInfo(Principal principal){
        return sysUserApiService.getSysUserInfo(principal.getName());
    }
}

