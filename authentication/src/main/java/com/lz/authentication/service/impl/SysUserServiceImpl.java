package com.lz.authentication.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.UserRequest;
import com.lz.authentication.bean.vo.SysUser;
import com.lz.authentication.dao.SysUserMapper;
import com.lz.authentication.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Service("sysUserServiceImpl")
@Transactional
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 根据用户名获取系统用户信息
     * @param username
     * @return
     */
    @Override
    public SysUser getUserByName(String username) {
        //获取用户信息
        UserRequest request=new UserRequest();
        request.setUserName(username);
        List<SysUser> userList = sysUserMapper.getUserList(request);
        SysUser sysUser=null;
        if(!(userList!=null && !userList.isEmpty())){
            return sysUser;
        }
        sysUser=userList.get(0);
        return sysUser;
    }

    /**
     * 获取用户列表
     * @param param
     * @return
     */
    @Override
    public PageInfo<SysUser> getUserList(UserRequest param){
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        return new PageInfo<>(sysUserMapper.getUserList(param));
    }

    /**
     * 获取用户信息详情
     * @param param
     * @return
     */
    @Override
    public SysUser getUserInfo(UserRequest param){
        return sysUserMapper.getUserInfo(param);
    }

    /**
     * 增加用户信息
     * @param param
     * @return
     */
    @Override
    public Integer insertUser(UserRequest param){
        return sysUserMapper.insertUser(param);
    }

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    @Override
    public Integer updateUser(UserRequest param){
        return sysUserMapper.updateUser(param);
    }

    /**
     * 删除用户信息
     * @param param
     * @return
     */
    @Override
    public Integer deleteUser(UserRequest param){
        return sysUserMapper.deleteUser(param);
    }
}
