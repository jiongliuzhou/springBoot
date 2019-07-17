package com.lz.authentication.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户角色
     */
    private List<SysRole> roleList;
}
