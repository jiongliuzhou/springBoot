package com.lz.goods.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.base.constant.ConstantStr;
import com.lz.base.util.date.DateHelper;
import com.lz.base.util.uuid.UUIDHelper;
import com.lz.goods.bean.request.GoodRequest;
import com.lz.goods.bean.vo.GoodVO;
import com.lz.goods.mapper.GoodMapper;
import com.lz.goods.service.GoodService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 商品管理业务层实现类
 * @create 2019/5/21
 * @since 1.0.0
 */
@Service(value="goodServiceImpl")
@Transactional
public class GoodServiceImpl implements GoodService {
    @Resource
    private GoodMapper goodMapper;

    /**
     * 获取商品信息列表
     * @param param
     * @return
     */
    public PageInfo<GoodVO> getGoodList(GoodRequest param) {
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        return new PageInfo<>(goodMapper.getGoodList(param));
    }

    /**
     * 获取商品信息详情
     * @param param
     * @return
     */
    public GoodVO getGoodInfo(GoodRequest param) {
        return goodMapper.getGoodInfo(param);
    }

    /**
     * 增加商品信息
     * @param param
     * @return
     */
    public Integer insertGood(GoodRequest param) {
        param.setGoodId(UUIDHelper.get32UUID());
        param.setCreateTime(DateHelper.getNow());
        param.setStatus(ConstantStr.FAIL_CODE.getKey());
        return goodMapper.insertGood(param);
    }

    /**
     * 修改商品信息
     * @param param
     * @return
     */
    public Integer updateGood(GoodRequest param) {
        param.setUpdateTime(DateHelper.getNow());
        return goodMapper.updateGood(param);
    }

    /**
     * 删除商品信息
     * @param param
     * @return
     */
    public Integer deleteGood(GoodRequest param) {
        return goodMapper.deleteGood(param);
    }

}
