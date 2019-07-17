package com.lz.goods.controller;

import com.github.pagehelper.PageInfo;
import com.lz.base.util.base.ResultInvoke;
import com.lz.goods.bean.request.GoodRequest;
import com.lz.goods.bean.vo.GoodVO;
import com.lz.goods.service.GoodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public Object getGoodList(GoodRequest param){
        Object obj;
        try {
            PageInfo<GoodVO> GoodList = goodService.getGoodList(param);
            obj= ResultInvoke.success(GoodList);
        }catch (Exception e){
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
    public Object getGoodInfo(GoodRequest param){
        Object obj;
        try {
            GoodVO GoodInfo = goodService.getGoodInfo(param);
            obj= ResultInvoke.success(GoodInfo);
        }catch (Exception e){
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
    public Object insertGood(GoodRequest param){
        Object obj;
        try {
            Integer k = goodService.insertGood(param);
            if(k>0){
                obj= ResultInvoke.success();
            }else{
                obj= ResultInvoke.fail();
            }
        }catch (Exception e){
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
    public Object updateGood(GoodRequest param){
        Object obj;
        try {
            Integer k = goodService.updateGood(param);
            if(k>0){
                obj= ResultInvoke.success();
            }else{
                obj= ResultInvoke.fail();
            }
        }catch (Exception e){
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
    public Object deleteGood(GoodRequest param){
        Object obj;
        try {
            Integer k = goodService.deleteGood(param);
            if(k>0){
                obj= ResultInvoke.success();
            }else{
                obj= ResultInvoke.fail();
            }
        }catch (Exception e){
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }


}
