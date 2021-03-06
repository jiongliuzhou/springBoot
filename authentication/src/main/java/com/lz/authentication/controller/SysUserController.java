package com.lz.authentication.controller;

import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.UserRequest;
import com.lz.authentication.bean.vo.SysUser;
import com.lz.authentication.service.SysUserService;
import com.lz.base.util.base.ResultInvoke;
import com.lz.base.util.exception.ExceptionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *  用户管理
 * @create 2019/5/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/sysUserController")
@CrossOrigin
@Slf4j
public class SysUserController {
    @Resource(name="sysUserServiceImpl")
    private SysUserService sysUserService;

    /**
     * 获取用户信息列表
     * @param param
     * @return
     */
    @RequestMapping("/getSysUserList")
    @ResponseBody
    public Object getSysUserList(UserRequest param){
        Object obj;
        try {
            PageInfo<SysUser> sysUserList = sysUserService.getUserList(param);
            obj= ResultInvoke.success(sysUserList);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 获取用户详情
     * @param param
     * @return
     */
    @RequestMapping("/getSysUserInfo")
    @ResponseBody
    public Object getSysUserInfo(UserRequest param){
        Object obj;
        try {
            SysUser sysUserInfo = sysUserService.getUserInfo(param);
            obj= ResultInvoke.success(sysUserInfo);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 新增用户信息
     * @param param
     * @return
     */
    @RequestMapping("/insertSysUser")
    @ResponseBody
    public Object insertSysUser(UserRequest param){
        Object obj;
        try {
            Integer k = sysUserService.insertUser(param);
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
     * 修改用户信息
     * @param param
     * @return
     */
    @RequestMapping("/updateSysUser")
    @ResponseBody
    public Object updateSysUser(UserRequest param){
        Object obj;
        try {
            Integer k = sysUserService.updateUser(param);
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
     * 删除用户信息
     * @param param
     * @return
     */
    @RequestMapping("/deleteSysUser")
    @ResponseBody
    public Object deleteSysUser(UserRequest param){
        Object obj;
        try {
            Integer k = sysUserService.deleteUser(param);
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
