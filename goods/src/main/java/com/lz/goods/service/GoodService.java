package com.lz.goods.service;

import com.github.pagehelper.PageInfo;
import com.lz.goods.bean.request.GoodRequest;
import com.lz.goods.bean.vo.GoodVO;

/**
 *  商品管理业务层接口
 * @create 2019/5/21
 * @since 1.0.0
 */
public interface GoodService {
    /**
     * 获取商品列表
     * @param param
     * @return
     */
    PageInfo<GoodVO> getGoodList(GoodRequest param);

    /**
     * 获取商品详情
     * @param param
     * @return
     */
    GoodVO getGoodInfo(GoodRequest param);

    /**
     * 增加商品信息
     * @param param
     * @return
     */
    Integer insertGood(GoodRequest param);

    /**
     * 修改商品信息
     * @param param
     * @return
     */
    Integer updateGood(GoodRequest param);

    /**
     * 删除商品信息
     * @param param
     * @return
     */
    Integer deleteGood(GoodRequest param);
}
