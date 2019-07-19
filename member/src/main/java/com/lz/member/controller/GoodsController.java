package com.lz.member.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lz.api.bean.request.GoodsParam;
import com.lz.api.bean.vo.GoodsInfo;
import com.lz.api.service.GoodsApiService;
import com.lz.base.util.base.ResultInvoke;
import com.lz.base.util.exception.ExceptionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 *  商品管理
 * @create 2019/5/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/goodsController")
@CrossOrigin
@Slf4j
public class GoodsController {
    //此处注解为dubbo包下的注解
    @Reference
    private GoodsApiService goodsApiService;

    /**
     * 获取会员信息列表
     * @param goodsName
     * @return
     */
    @RequestMapping("/getGoodsList")
    @ResponseBody
    public Object getGoodsList(String goodsName){
        Object obj;
        try {
            GoodsParam param=new GoodsParam(goodsName);
            //从dubbo服务获取商品列表信息
            List<GoodsInfo> goodsList = goodsApiService.getGoodsList(param);
            obj= ResultInvoke.success(goodsList);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }


}
