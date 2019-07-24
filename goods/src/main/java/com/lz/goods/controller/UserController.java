package com.lz.goods.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lz.api.service.SysUserApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author lz
 * @create 2019/6/20
 * @since 1.0.0
 */
@Controller
@RequestMapping("/userController")
public class UserController {
    @Reference
    private SysUserApiService sysUserApiService;
    /**
     * 获取用户名
     * @param principal
     * @return
     */
    @RequestMapping("/userName")
    @ResponseBody
    public Object userName(Principal principal) {
        return principal.getName();
    }

    /**
     * 获取当前用户信息
     * @param principal
     * @return
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Object getUserInfo(Principal principal){
        return sysUserApiService.getSysUserInfo(principal.getName());
    }
}

