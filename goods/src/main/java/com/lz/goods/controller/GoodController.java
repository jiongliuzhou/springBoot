package com.lz.goods.controller;

import com.github.pagehelper.PageInfo;
import com.lz.base.util.base.PageData;
import com.lz.base.util.base.ResultInvoke;
import com.lz.base.util.exception.ExceptionHelper;
import com.lz.goods.bean.request.GoodRequest;
import com.lz.goods.bean.vo.GoodVO;
import com.lz.goods.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *  会员管理
 * @create 2019/5/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/goodController")
@CrossOrigin
@Slf4j
public class GoodController {
    @Resource(name="goodServiceImpl")
    private GoodService goodService;

    /**
     * 获取会员信息列表
     * @param param
     * @return
     */
    @RequestMapping("/getGoodList")
    @ResponseBody
    public Object getGoodList(@RequestBody GoodRequest param){
        Object obj;
        try {
            PageInfo<GoodVO> goodList = goodService.getGoodList(param);
            obj=new PageData(goodList.getTotal(),goodList.getList());
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 获取会员详情
     * @param param
     * @return
     */
    @RequestMapping("/getGoodInfo")
    @ResponseBody
    public Object getGoodInfo(@RequestBody GoodRequest param){
        Object obj;
        try {
            GoodVO goodInfo = goodService.getGoodInfo(param);
            obj= ResultInvoke.success(goodInfo);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 新增会员信息
     * @param param
     * @return
     */
    @RequestMapping("/insertGood")
    @ResponseBody
    public Object insertGood(@RequestBody GoodRequest param){
        Object obj;
        try {
            Integer k = goodService.insertGood(param);
            if(k>0){
                obj= ResultInvoke.success();
            }else{
                obj= ResultInvoke.fail();
            }
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 修改会员信息
     * @param param
     * @return
     */
    @RequestMapping("/updateGood")
    @ResponseBody
    public Object updateGood(@RequestBody GoodRequest param){
        Object obj;
        try {
            Integer k = goodService.updateGood(param);
            if(k>0){
                obj= ResultInvoke.success();
            }else{
                obj= ResultInvoke.fail();
            }
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 删除会员信息
     * @param param
     * @return
     */
    @RequestMapping("/deleteGood")
    @ResponseBody
    public Object deleteGood(@RequestBody GoodRequest param){
        Object obj;
        try {
            Integer k = goodService.deleteGood(param);
            if(k>0){
                obj= ResultInvoke.success();
            }else{
                obj= ResultInvoke.fail();
            }
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }


}
