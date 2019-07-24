package com.lz.api.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户信息
 * @author lz
 * @create 2019/7/24
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable{
    private static final long serialVersionUID = 3101630166989175538L;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
}
