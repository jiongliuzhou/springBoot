package com.lz.authentication.bean;

import lombok.Data;

import java.util.List;

/**
 * 用户
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Data
public class SysUser {
    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户角色
     */
    private List<SysRole> roleList;

    public SysUser(String username, String password) {
        this.userName = username;
        this.password = password;
    }
}
