package com.lz.goods.service;

import com.lz.base.util.date.DateHelper;
import com.lz.base.util.json.JsonHelper;
import com.lz.base.util.uuid.UUIDHelper;
import com.lz.goods.bean.request.GoodRequest;
import com.lz.goods.bean.vo.GoodVO;
import com.lz.goods.mapper.GoodMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品管理service测试
 * @author lz
 * @create 2019/7/19
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class GoodServiceImplTest {
    @Resource
    private GoodMapper goodMapper;

    /**
     * 获取商品列表
     */
    @Test
    public void getGoodList(){
        GoodRequest param=new GoodRequest();
        List<GoodVO> goodList = goodMapper.getGoodList(param);
        String json = JsonHelper.toJSON(goodList);
        log.debug(json);
    }

    /**
     * 获取商品信息详情
     */
    @Test
    public void getGoodInfo(){
        GoodRequest param=new GoodRequest();
        param.setGoodId("a48d34e35c7744f19e564a471a6a2c66");
        GoodVO goodInfo = goodMapper.getGoodInfo(param);
        String json = JsonHelper.toJSON(goodInfo);
        log.debug(json);
    }

    /**
     * 新增商品
     */
    @Test
    public void insertGood(){
        GoodRequest param=new GoodRequest();
        param.setGoodId(UUIDHelper.get32UUID());
        param.setStatus("0");
        param.setCreateTime(DateHelper.getNow());
        param.setGoodName("Good");
        param.setGoodPrice("20.0");
        param.setGoodStock("100");
        Integer k = goodMapper.insertGood(param);
        log.debug(k.toString());
    }

    /**
     * 修改商品
     */
    @Test
    public void updateGood(){
        GoodRequest param=new GoodRequest();
        param.setGoodId("b0f9044b4bc94c64bd49013298145fdb");
        param.setUpdateTime(DateHelper.getNow());
        param.setGoodName("Good");
        param.setGoodPrice("20.0");
        param.setGoodStock("100");
        Integer k = goodMapper.updateGood(param);
        log.debug(k.toString());
    }

    /**
     * 删除商品
     */
    @Test
    public void deleteGood(){
        GoodRequest param=new GoodRequest();
        param.setGoodId("b0f9044b4bc94c64bd49013298145fdb");
        Integer k = goodMapper.deleteGood(param);
        log.debug(k.toString());
    }
}
