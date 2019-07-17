package com.lz.authentication.service.impl;

import com.lz.authentication.bean.request.RolePermissionRequest;
import com.lz.authentication.bean.request.UserRequest;
import com.lz.authentication.bean.request.UserRoleRequest;
import com.lz.authentication.bean.vo.SysPermission;
import com.lz.authentication.bean.vo.SysRole;
import com.lz.authentication.bean.vo.SysUser;
import com.lz.authentication.dao.SysRolePermissionMapper;
import com.lz.authentication.dao.SysUserMapper;
import com.lz.authentication.dao.SysUserRoleMapper;
import com.lz.authentication.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

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
        //获取用户角色信息
        UserRoleRequest userRoleRequest=new UserRoleRequest();
        userRoleRequest.setUserId(sysUser.getUserId());
        List<SysRole> userRoleList = sysUserRoleMapper.getUserRoleList(userRoleRequest);
        if(!(userRoleList!=null && !userRoleList.isEmpty())){
            return sysUser;
        }
        //获取角色权限信息
        for (SysRole s:userRoleList){
            RolePermissionRequest rolePermissionRequest=new RolePermissionRequest();
            rolePermissionRequest.setRoleId(s.getRoleId());
            List<SysPermission> rolePermissionList = sysRolePermissionMapper.getRolePermissionList(rolePermissionRequest);
            s.setPermissionList(rolePermissionList);
        }
        sysUser.setRoleList(userRoleList);
        return sysUser;
    }
}
