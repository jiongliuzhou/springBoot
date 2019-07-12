package com.lz.authentication.service;


import com.lz.authentication.bean.SysUser;

/**
 *  用户权限管理
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
public interface UserService {
    /**
     * 获取用户信息
     * @param username
     * @return
     */
    SysUser getUserByName(String username);
}
