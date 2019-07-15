package com.lz.member.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.base.constant.ConstantStr;
import com.lz.base.util.date.DateHelper;
import com.lz.base.util.uuid.UUIDHelper;
import com.lz.member.bean.request.MemberRequest;
import com.lz.member.bean.vo.MemberVO;
import com.lz.member.mapper.UserMapper;
import com.lz.member.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户管理业务层实现类
 * @create 2019/5/21
 * @since 1.0.0
 */
@Service(value="userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 获取用户信息列表
     * @param param
     * @return
     */
    public PageInfo<MemberVO> getUserList(MemberRequest param) {
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        return new PageInfo<>(userMapper.getUserList(param));
    }

    /**
     * 获取用户信息详情
     * @param param
     * @return
     */
    public MemberVO getUserInfo(MemberRequest param) {
        return userMapper.getUserInfo(param);
    }

    /**
     * 增加用户信息
     * @param param
     * @return
     */
    public Integer insertUser(MemberRequest param) {
        param.setMemberId(UUIDHelper.get32UUID());
        param.setCreateTime(DateHelper.getNow());
        param.setStatus(ConstantStr.FAIL_CODE.getKey());
        return userMapper.insertUser(param);
    }

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    public Integer updateUser(MemberRequest param) {
        param.setUpdateTime(DateHelper.getNow());
        return userMapper.updateUser(param);
    }

    /**
     * 删除用户信息
     * @param param
     * @return
     */
    public Integer deleteUser(MemberRequest param) {
        return userMapper.deleteUser(param);
    }

}
