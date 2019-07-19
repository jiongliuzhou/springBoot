package com.lz.member.service;

import com.lz.base.util.date.DateHelper;
import com.lz.base.util.json.JsonHelper;
import com.lz.base.util.uuid.UUIDHelper;
import com.lz.member.bean.request.MemberRequest;
import com.lz.member.bean.vo.MemberVO;
import com.lz.member.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员管理service测试
 * @author lz
 * @create 2019/7/19
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MemberServiceImplTest {
    @Resource
    private MemberMapper memberMapper;

    /**
     * 获取会员列表
     */
    @Test
    public void getMemberList(){
        MemberRequest param=new MemberRequest();
        List<MemberVO> memberList = memberMapper.getMemberList(param);
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
        MemberVO memberInfo = memberMapper.getMemberInfo(param);
        String json = JsonHelper.toJSON(memberInfo);
        log.debug(json);
    }

    /**
     * 新增会员
     */
    @Test
    public void insertMember(){
        MemberRequest param=new MemberRequest();
        param.setMemberId(UUIDHelper.get32UUID());
        param.setStatus("0");
        param.setCreateTime(DateHelper.getNow());
        param.setMemberName("member");
        param.setMemberPassword("member");
        param.setEmail("874545@qq.com");
        param.setPhone("13512475145");
        Integer k = memberMapper.insertMember(param);
        log.debug(k.toString());
    }

    /**
     * 修改会员
     */
    @Test
    public void updateMember(){
        MemberRequest param=new MemberRequest();
        param.setMemberId("f31a68d1457e48ecaeecbf59300c3ecd");
        param.setUpdateTime(DateHelper.getNow());
        param.setMemberName("member1");
        param.setMemberPassword("member1");
        param.setEmail("874545@qq.com");
        param.setPhone("13512475145");
        Integer k = memberMapper.updateMember(param);
        log.debug(k.toString());
    }

    /**
     * 删除会员
     */
    @Test
    public void deleteMember(){
        MemberRequest param=new MemberRequest();
        param.setMemberId("f31a68d1457e48ecaeecbf59300c3ecd");
        Integer k = memberMapper.deleteMember(param);
        log.debug(k.toString());
    }
}
