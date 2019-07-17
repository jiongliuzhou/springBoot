package com.lz.authentication.service;


import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.UserRequest;
import com.lz.authentication.bean.vo.SysUser;

/**
 *  用户管理
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
public interface SysUserService {
    /**
     * 获取用户信息
     * @param username
     * @return
     */
    SysUser getUserByName(String username);

    /**
     * 获取用户列表
     * @param param
     * @return
     */
    PageInfo<SysUser> getUserList(UserRequest param);

    /**
     * 获取用户信息详情
     * @param param
     * @return
     */
    SysUser getUserInfo(UserRequest param);

    /**
     * 增加用户信息
     * @param param
     * @return
     */
    Integer insertUser(UserRequest param);

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    Integer updateUser(UserRequest param);

    /**
     * 删除用户信息
     * @param param
     * @return
     */
    Integer deleteUser(UserRequest param);
}
