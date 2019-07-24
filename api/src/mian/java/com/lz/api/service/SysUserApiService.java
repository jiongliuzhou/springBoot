package com.lz.api.service;

import com.lz.api.bean.vo.UserInfo;

/**
 * 获取系统用户信息
 * @author lz
 * @create 2019/7/24
 * @since 1.0.0
 */
public interface SysUserApiService {
    /**
     * 获取系统用户信息
     * @param userName
     * @return
     */
    UserInfo getSysUserInfo(String userName);
}
