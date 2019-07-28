package com.lz.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lz
 * @create 2019/7/22
 * @since 1.0.0
 */
@Controller
public class IndexController {

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/list")
    public String index(){
        return "list";
    }
}
