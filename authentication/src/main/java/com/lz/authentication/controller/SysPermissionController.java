package com.lz.authentication.controller;

import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.PermissionRequest;
import com.lz.authentication.bean.vo.SysPermission;
import com.lz.authentication.service.SysPermissionService;
import com.lz.base.util.base.ResultInvoke;
import com.lz.base.util.exception.ExceptionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *  权限管理
 * @create 2019/5/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/sysPermissionController")
@CrossOrigin
@Slf4j
public class SysPermissionController {
    @Resource(name="sysPermissionServiceImpl")
    private SysPermissionService sysPermissionService;

    /**
     * 获取权限信息列表
     * @param param
     * @return
     */
    @RequestMapping("/getSysPermissionList")
    @ResponseBody
    public Object getSysPermissionList(PermissionRequest param){
        Object obj;
        try {
            PageInfo<SysPermission> sysPermissionList = sysPermissionService.getPermissionList(param);
            obj= ResultInvoke.success(sysPermissionList);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 获取权限详情
     * @param param
     * @return
     */
    @RequestMapping("/getSysPermissionInfo")
    @ResponseBody
    public Object getSysPermissionInfo(PermissionRequest param){
        Object obj;
        try {
            SysPermission sysPermissionInfo = sysPermissionService.getPermissionInfo(param);
            obj= ResultInvoke.success(sysPermissionInfo);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 新增权限信息
     * @param param
     * @return
     */
    @RequestMapping("/insertSysPermission")
    @ResponseBody
    public Object insertSysPermission(PermissionRequest param){
        Object obj;
        try {
            Integer k = sysPermissionService.insertPermission(param);
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
     * 修改权限信息
     * @param param
     * @return
     */
    @RequestMapping("/updateSysPermission")
    @ResponseBody
    public Object updateSysPermission(PermissionRequest param){
        Object obj;
        try {
            Integer k = sysPermissionService.updatePermission(param);
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
     * 删除权限信息
     * @param param
     * @return
     */
    @RequestMapping("/deleteSysPermission")
    @ResponseBody
    public Object deleteSysPermission(PermissionRequest param){
        Object obj;
        try {
            Integer k = sysPermissionService.deletePermission(param);
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
