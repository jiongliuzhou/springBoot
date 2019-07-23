package com.lz.member.controller;

import com.github.pagehelper.PageInfo;
import com.lz.base.util.base.PageData;
import com.lz.base.util.base.ResultInvoke;
import com.lz.base.util.exception.ExceptionHelper;
import com.lz.member.bean.request.MemberRequest;
import com.lz.member.bean.vo.MemberVO;
import com.lz.member.service.MemberService;
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
@RequestMapping("/memberController")
@CrossOrigin
@Slf4j
public class MemberController {
    @Resource(name="memberServiceImpl")
    private MemberService memberService;

    /**
     * 获取会员信息列表
     * @param param
     * @return
     */
    @RequestMapping("/getMemberList")
    @ResponseBody
    public Object getMemberList(@RequestBody MemberRequest param){
        Object obj;
        try {
            PageInfo<MemberVO> memberList = memberService.getMemberList(param);
            obj= new PageData(memberList.getTotal(),memberList.getList());
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
    @RequestMapping("/getMemberInfo")
    @ResponseBody
    public Object getMemberInfo(MemberRequest param){
        Object obj;
        try {
            MemberVO memberInfo = memberService.getMemberInfo(param);
            obj= ResultInvoke.success(memberInfo);
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
    @RequestMapping("/insertMember")
    @ResponseBody
    public Object insertMember(MemberRequest param){
        Object obj;
        try {
            Integer k = memberService.insertMember(param);
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
    @RequestMapping("/updateMember")
    @ResponseBody
    public Object updateMember(MemberRequest param){
        Object obj;
        try {
            Integer k = memberService.updateMember(param);
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
    @RequestMapping("/deleteMember")
    @ResponseBody
    public Object deleteMember(MemberRequest param){
        Object obj;
        try {
            Integer k = memberService.deleteMember(param);
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
