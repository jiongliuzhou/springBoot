package com.lz.authentication.controller;

import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.ResourceRequest;
import com.lz.authentication.bean.vo.SysResource;
import com.lz.authentication.service.SysResourceService;
import com.lz.base.util.base.ResultInvoke;
import com.lz.base.util.exception.ExceptionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *  资源管理
 * @create 2019/5/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/sysResourceController")
@CrossOrigin
@Slf4j
public class SysResourceController {
    @Resource(name="sysResourceServiceImpl")
    private SysResourceService sysResourceService;

    /**
     * 获取资源信息列表
     * @param param
     * @return
     */
    @RequestMapping("/getSysResourceList")
    @ResponseBody
    public Object getSysResourceList(ResourceRequest param){
        Object obj;
        try {
            PageInfo<SysResource> sysResourceList = sysResourceService.getResourceList(param);
            obj= ResultInvoke.success(sysResourceList);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 获取资源详情
     * @param param
     * @return
     */
    @RequestMapping("/getSysResourceInfo")
    @ResponseBody
    public Object getSysResourceInfo(ResourceRequest param){
        Object obj;
        try {
            SysResource sysResourceInfo = sysResourceService.getResourceInfo(param);
            obj= ResultInvoke.success(sysResourceInfo);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 新增资源信息
     * @param param
     * @return
     */
    @RequestMapping("/insertSysResource")
    @ResponseBody
    public Object insertSysResource(ResourceRequest param){
        Object obj;
        try {
            Integer k = sysResourceService.insertResource(param);
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
     * 修改资源信息
     * @param param
     * @return
     */
    @RequestMapping("/updateSysResource")
    @ResponseBody
    public Object updateSysResource(ResourceRequest param){
        Object obj;
        try {
            Integer k = sysResourceService.updateResource(param);
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
     * 删除资源信息
     * @param param
     * @return
     */
    @RequestMapping("/deleteSysResource")
    @ResponseBody
    public Object deleteSysResource(ResourceRequest param){
        Object obj;
        try {
            Integer k = sysResourceService.deleteResource(param);
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
