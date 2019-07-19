package com.lz.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lz.api.bean.request.GoodsParam;
import com.lz.api.bean.vo.GoodsInfo;
import com.lz.api.service.GoodsApiService;
import com.lz.dubbo.mapper.GoodsMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息管理
 * @author lz
 * @create 2019/7/19
 * @since 1.0.0
 */
//此处用的是bubbo包的注解
@Service
public class GoodsApiServiceImpl implements GoodsApiService{
    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 获取商品列表接口
     * @param param
     * @return
     */
    @Override
    public List<GoodsInfo> getGoodsList(GoodsParam param) {
        return goodsMapper.getGoodList(param);
    }
}
