package com.lz.goods.mapper;

import com.lz.goods.bean.request.GoodRequest;
import com.lz.goods.bean.vo.GoodVO;
import com.lz.goods.mapper.provider.GoodProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  商品管理mapper
 * @create 2019/5/21
 * @since 1.0.0
 */
@Mapper
public interface GoodMapper {
    /**
     * 获取商品列表
     * @param param
     * @return
     */
    @SelectProvider(type = GoodProvider.class,method = "getGoodList")
    List<GoodVO> getGoodList(GoodRequest param);

    /**
     * 获取商品详情
     * @param param
     * @return
     */
    @SelectProvider(type = GoodProvider.class,method = "getGoodInfo")
    GoodVO getGoodInfo(@Param("param") GoodRequest param);

    /**
     * 增加商品信息
     * @param param
     * @return
     */
    @InsertProvider(type = GoodProvider.class,method = "insertGood")
    Integer insertGood(GoodRequest param);

    /**
     * 修改商品信息
     * @param param
     * @return
     */
    @UpdateProvider(type = GoodProvider.class,method = "updateGood")
    Integer updateGood(GoodRequest param);

    /**
     * 删除商品信息
     * @param param
     * @return
     */
    @DeleteProvider(type = GoodProvider.class,method = "deleteGood")
    Integer deleteGood(GoodRequest param);
}
