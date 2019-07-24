package com.lz.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lz.api.bean.vo.UserInfo;
import com.lz.api.service.SysUserApiService;
import com.lz.dubbo.config.TargetDataSource;
import com.lz.dubbo.mapper.SysUserMapper;

import javax.annotation.Resource;

/**
 * 获取系统用户信息
 * @author lz
 * @create 2019/7/24
 * @since 1.0.0
 */
@Service
public class SysUserApiServiceImpl implements SysUserApiService{
    @Resource
    private SysUserMapper sysUserMapper;
    /**
     * 获取系统用户信息
     * @param userName
     * @return
     */
    @TargetDataSource(name="base")
    @Override
    public UserInfo getSysUserInfo(String userName) {
        return sysUserMapper.getSysUserInfo(userName);
    }
}
