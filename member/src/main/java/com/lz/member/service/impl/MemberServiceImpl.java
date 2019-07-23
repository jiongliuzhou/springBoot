package com.lz.member.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.base.constant.ConstantStr;
import com.lz.base.util.date.DateHelper;
import com.lz.base.util.uuid.UUIDHelper;
import com.lz.member.bean.request.MemberRequest;
import com.lz.member.bean.vo.MemberVO;
import com.lz.member.mapper.MemberMapper;
import com.lz.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户管理业务层实现类
 * @create 2019/5/21
 * @since 1.0.0
 */
@Service(value="memberServiceImpl")
@Transactional
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberMapper memberMapper;

    /**
     * 获取用户信息列表
     * @param param
     * @return
     */
    public PageInfo<MemberVO> getMemberList(MemberRequest param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        return new PageInfo<>(memberMapper.getMemberList(param));
    }

    /**
     * 获取用户信息详情
     * @param param
     * @return
     */
    public MemberVO getMemberInfo(MemberRequest param) {
        return memberMapper.getMemberInfo(param);
    }

    /**
     * 增加用户信息
     * @param param
     * @return
     */
    public Integer insertMember(MemberRequest param) {
        param.setMemberId(UUIDHelper.get32UUID());
        param.setCreateTime(DateHelper.getNow());
        param.setStatus(ConstantStr.FAIL_CODE.getKey());
        return memberMapper.insertMember(param);
    }

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    public Integer updateMember(MemberRequest param) {
        param.setUpdateTime(DateHelper.getNow());
        return memberMapper.updateMember(param);
    }

    /**
     * 删除用户信息
     * @param param
     * @return
     */
    public Integer deleteMember(MemberRequest param) {
        return memberMapper.deleteMember(param);
    }

}
