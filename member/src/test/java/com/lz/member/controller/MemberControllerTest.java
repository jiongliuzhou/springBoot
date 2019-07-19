package com.lz.member.controller;

import com.github.pagehelper.PageInfo;
import com.lz.base.util.json.JsonHelper;
import com.lz.member.bean.request.MemberRequest;
import com.lz.member.bean.vo.MemberVO;
import com.lz.member.service.MemberService;
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
public class MemberControllerTest {
    @Resource(name="memberServiceImpl")
    private MemberService memberService;

    /**
     * 获取会员列表
     */
    @Test
    public void getMemberList(){
        MemberRequest param=new MemberRequest();
        PageInfo<MemberVO> memberList = memberService.getMemberList(param);
        String json = JsonHelper.toJSON(memberList);
        log.debug(json);
    }

    /**
     * 获取会员信息详情
     */
    @Test
    public void getMemberInfo(){
        MemberRequest param=new MemberRequest();
        param.setMemberId("611a9d0c92c94fb1b68714a905368fbf");
        MemberVO memberInfo = memberService.getMemberInfo(param);
        String json = JsonHelper.toJSON(memberInfo);
        log.debug("===========================:"+json);
    }

    /**
     * 新增会员
     */
    @Test
    public void insertMember(){
        MemberRequest param=new MemberRequest();
        param.setMemberName("member");
        param.setMemberPassword("member");
        param.setEmail("874545@qq.com");
        param.setPhone("13512475145");
        Integer k = memberService.insertMember(param);
        log.debug(k.toString());
    }

    /**
     * 修改会员
     */
    @Test
    public void updateMember(){
        MemberRequest param=new MemberRequest();
        param.setMemberId("ac4b908340624b26adc674192164c25f");
        param.setMemberName("member1");
        param.setMemberPassword("member1");
        param.setEmail("874545@qq.com");
        param.setPhone("13512475145");
        Integer k = memberService.updateMember(param);
        log.debug(k.toString());
    }

    /**
     * 删除会员
     */
    @Test
    public void deleteMember(){
        MemberRequest param=new MemberRequest();
        param.setMemberId("ac4b908340624b26adc674192164c25f");
        Integer k = memberService.deleteMember(param);
        log.debug(k.toString());
    }
}
