package com.lz.dubbo.mapper;

import com.lz.api.bean.request.GoodsParam;
import com.lz.api.bean.vo.GoodsInfo;
import com.lz.dubbo.mapper.provider.GoodsProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  商品管理mapper
 * @create 2019/5/21
 * @since 1.0.0
 */
@Mapper
public interface GoodsMapper {
    /**
     * 获取商品列表
     * @param param
     * @return
     */
    @SelectProvider(type = GoodsProvider.class,method = "getGoodList")
    List<GoodsInfo> getGoodList(GoodsParam param);

}
