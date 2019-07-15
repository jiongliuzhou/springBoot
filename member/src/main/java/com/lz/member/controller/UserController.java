package com.lz.member.controller;

import com.github.pagehelper.PageInfo;
import com.lz.base.util.base.ResultInvoke;
import com.lz.member.bean.request.MemberRequest;
import com.lz.member.bean.vo.MemberVO;
import com.lz.member.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *  用户管理
 * @create 2019/5/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/memberController")
@CrossOrigin
public class UserController {
    @Resource(name="userServiceImpl")
    private UserService userService;

    /**
     * 获取用户信息列表
     * @param param
     * @return
     */
    @RequestMapping("/getMemberList")
    @ResponseBody
    public Object getMemberList(@RequestBody MemberRequest param){
        Object obj;
        try {
            PageInfo<MemberVO> userList = userService.getUserList(param);
            obj= ResultInvoke.success(userList);
        }catch (Exception e){
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 获取用户详情
     * @param param
     * @return
     */
    @RequestMapping("/getMemberInfo")
    @ResponseBody
    public Object getMemberInfo(@RequestBody MemberRequest param){
        Object obj;
        try {
            MemberVO userInfo = userService.getUserInfo(param);
            obj= ResultInvoke.success(userInfo);
        }catch (Exception e){
            obj= ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 新增用户信息
     * @param param
     * @return
     */
    @RequestMapping("/insertMember")
    @ResponseBody
    public Object insertMember(@RequestBody MemberRequest param){
        Object obj;
        try {
            Integer k = userService.insertUser(param);
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
     * 修改用户信息
     * @param param
     * @return
     */
    @RequestMapping("/updateMember")
    @ResponseBody
    public Object updateMember(@RequestBody MemberRequest param){
        Object obj;
        try {
            Integer k = userService.updateUser(param);
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
     * 删除用户信息
     * @param param
     * @return
     */
    @RequestMapping("/deleteMember")
    @ResponseBody
    public Object deleteMember(@RequestBody MemberRequest param){
        Object obj;
        try {
            Integer k = userService.deleteUser(param);
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
