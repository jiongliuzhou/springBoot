package com.lz.api.service;

import com.lz.api.bean.request.GoodsParam;
import com.lz.api.bean.vo.GoodsInfo;

import java.util.List;

/**
 * 商品管理
 * @author lz
 * @create 2019/7/19
 * @since 1.0.0
 */
public interface GoodsApiService {
    /**
     * 获取商品列表接口
     * @param param
     * @return
     */
    List<GoodsInfo> getGoodsList(GoodsParam param);
}
