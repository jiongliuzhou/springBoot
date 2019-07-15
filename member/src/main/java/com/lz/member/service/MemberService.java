package com.lz.member.service;

import com.github.pagehelper.PageInfo;
import com.lz.member.bean.request.MemberRequest;
import com.lz.member.bean.vo.MemberVO;

/**
 *  会员管理业务层接口
 * @create 2019/5/21
 * @since 1.0.0
 */
public interface MemberService {
    /**
     * 获取会员列表
     * @param param
     * @return
     */
    PageInfo<MemberVO> getMemberList(MemberRequest param);

    /**
     * 获取会员详情
     * @param param
     * @return
     */
    MemberVO getMemberInfo(MemberRequest param);

    /**
     * 增加会员信息
     * @param param
     * @return
     */
    Integer insertMember(MemberRequest param);

    /**
     * 修改会员信息
     * @param param
     * @return
     */
    Integer updateMember(MemberRequest param);

    /**
     * 删除会员信息
     * @param param
     * @return
     */
    Integer deleteMember(MemberRequest param);
}
