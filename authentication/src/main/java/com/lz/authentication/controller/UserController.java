package com.lz.authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
}

