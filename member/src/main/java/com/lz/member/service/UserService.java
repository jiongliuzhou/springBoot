package com.lz.member.service;

import com.github.pagehelper.PageInfo;
import com.lz.member.bean.request.MemberRequest;
import com.lz.member.bean.vo.MemberVO;

/**
 *  用户管理业务层接口
 * @create 2019/5/21
 * @since 1.0.0
 */
public interface UserService {
    /**
     * 获取用户列表
     * @param param
     * @return
     */
    PageInfo<MemberVO> getUserList(MemberRequest param);

    /**
     * 获取用户详情
     * @param param
     * @return
     */
    MemberVO getUserInfo(MemberRequest param);

    /**
     * 增加用户信息
     * @param param
     * @return
     */
    Integer insertUser(MemberRequest param);

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    Integer updateUser(MemberRequest param);

    /**
     * 删除用户信息
     * @param param
     * @return
     */
    Integer deleteUser(MemberRequest param);
}
