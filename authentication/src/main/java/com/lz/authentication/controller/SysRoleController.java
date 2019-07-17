package com.lz.authentication.controller;

import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.RoleRequest;
import com.lz.authentication.bean.vo.SysRole;
import com.lz.authentication.service.SysRoleService;
import com.lz.base.util.base.ResultInvoke;
import com.lz.base.util.exception.ExceptionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *  角色管理
 * @create 2019/5/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/sysRoleController")
@CrossOrigin
@Slf4j
public class SysRoleController {
    @Resource(name="sysRoleServiceImpl")
    private SysRoleService sysRoleService;

    /**
     * 获取角色信息列表
     * @param param
     * @return
     */
    @RequestMapping("/getSysRoleList")
    @ResponseBody
    public Object getSysRoleList(RoleRequest param){
        Object obj;
        try {
            PageInfo<SysRole> sysRoleList = sysRoleService.getRoleList(param);
            obj= ResultInvoke.success(sysRoleList);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 获取角色详情
     * @param param
     * @return
     */
    @RequestMapping("/getSysRoleInfo")
    @ResponseBody
    public Object getSysRoleInfo(RoleRequest param){
        Object obj;
        try {
            SysRole sysRoleInfo = sysRoleService.getRoleInfo(param);
            obj= ResultInvoke.success(sysRoleInfo);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 新增角色信息
     * @param param
     * @return
     */
    @RequestMapping("/insertSysRole")
    @ResponseBody
    public Object insertSysRole(RoleRequest param){
        Object obj;
        try {
            Integer k = sysRoleService.insertRole(param);
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
     * 修改角色信息
     * @param param
     * @return
     */
    @RequestMapping("/updateSysRole")
    @ResponseBody
    public Object updateSysRole(RoleRequest param){
        Object obj;
        try {
            Integer k = sysRoleService.updateRole(param);
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
     * 删除角色信息
     * @param param
     * @return
     */
    @RequestMapping("/deleteSysRole")
    @ResponseBody
    public Object deleteSysRole(RoleRequest param){
        Object obj;
        try {
            Integer k = sysRoleService.deleteRole(param);
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
