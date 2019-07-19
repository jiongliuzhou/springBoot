package com.lz.goods.controller;

import com.github.pagehelper.PageInfo;
import com.lz.base.util.json.JsonHelper;
import com.lz.goods.bean.request.GoodRequest;
import com.lz.goods.bean.vo.GoodVO;
import com.lz.goods.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
/**
 * 会员管理controller测试
 * @author lz
 * @create 2019/7/19
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class GoodControllerTest {
    @Resource(name="goodServiceImpl")
    private GoodService goodService;

    /**
     * 获取会员列表
     */
    @Test
    public void getGoodList(){
        GoodRequest param=new GoodRequest();
        PageInfo<GoodVO> goodList = goodService.getGoodList(param);
        String json = JsonHelper.toJSON(goodList);
        log.debug(json);
    }

    /**
     * 获取会员信息详情
     */
    @Test
    public void getGoodInfo(){
        GoodRequest param=new GoodRequest();
        param.setGoodId("a48d34e35c7744f19e564a471a6a2c66");
        GoodVO goodInfo = goodService.getGoodInfo(param);
        String json = JsonHelper.toJSON(goodInfo);
        log.debug("===========================:"+json);
    }

    /**
     * 新增会员
     */
    @Test
    public void insertGood(){
        GoodRequest param=new GoodRequest();
        param.setGoodName("Good");
        param.setGoodPrice("20.0");
        param.setGoodStock("100");
        Integer k = goodService.insertGood(param);
        log.debug(k.toString());
    }

    /**
     * 修改会员
     */
    @Test
    public void updateGood(){
        GoodRequest param=new GoodRequest();
        param.setGoodId("ebe6772bb69b408e945231d47de781ec");
        param.setGoodName("Good");
        param.setGoodPrice("20.0");
        param.setGoodStock("100");
        Integer k = goodService.updateGood(param);
        log.debug(k.toString());
    }

    /**
     * 删除会员
     */
    @Test
    public void deleteGood(){
        GoodRequest param=new GoodRequest();
        param.setGoodId("ebe6772bb69b408e945231d47de781ec");
        Integer k = goodService.deleteGood(param);
        log.debug(k.toString());
    }
}
