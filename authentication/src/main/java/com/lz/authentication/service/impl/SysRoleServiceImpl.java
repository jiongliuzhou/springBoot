package com.lz.authentication.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.RoleRequest;
import com.lz.authentication.bean.vo.SysRole;
import com.lz.authentication.dao.*;
import com.lz.authentication.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Service("sysRoleServiceImpl")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    /**
     * 获取角色列表(分页)
     * @param param
     * @return
     */
    @Override
    public PageInfo<SysRole> getRoleList(RoleRequest param){
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        return new PageInfo<>(sysRoleMapper.getRoleList(param));
    }

    /**
     * 获取角色信息详情
     * @param param
     * @return
     */
    @Override
    public SysRole getRoleInfo(RoleRequest param){
        return sysRoleMapper.getRoleInfo(param);
    }

    /**
     * 增加角色信息
     * @param param
     * @return
     */
    @Override
    public Integer insertRole(RoleRequest param){
        return sysRoleMapper.insertRole(param);
    }

    /**
     * 修改角色信息
     * @param param
     * @return
     */
    @Override
    public Integer updateRole(RoleRequest param){
        return sysRoleMapper.updateRole(param);
    }

    /**
     * 删除角色信息
     * @param param
     * @return
     */
    @Override
    public Integer deleteRole(RoleRequest param){
        return sysRoleMapper.deleteRole(param);
    }
}
