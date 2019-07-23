package com.lz.authentication.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.PermissionRequest;
import com.lz.authentication.bean.vo.SysPermission;
import com.lz.authentication.dao.SysPermissionMapper;
import com.lz.authentication.service.SysPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Service("sysPermissionServiceImpl")
@Transactional
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;
    /**
     * 获取角色列表(分页)
     * @param param
     * @return
     */
    @Override
    public PageInfo<SysPermission> getPermissionList(PermissionRequest param){
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        return new PageInfo<>(sysPermissionMapper.getPermissionList(param));
    }

    /**
     * 获取角色信息详情
     * @param param
     * @return
     */
    @Override
    public SysPermission getPermissionInfo(PermissionRequest param){
        return sysPermissionMapper.getPermissionInfo(param);
    }

    /**
     * 增加角色信息
     * @param param
     * @return
     */
    @Override
    public Integer insertPermission(PermissionRequest param){
        return sysPermissionMapper.insertPermission(param);
    }

    /**
     * 修改角色信息
     * @param param
     * @return
     */
    @Override
    public Integer updatePermission(PermissionRequest param){
        return sysPermissionMapper.updatePermission(param);
    }

    /**
     * 删除角色信息
     * @param param
     * @return
     */
    @Override
    public Integer deletePermission(PermissionRequest param){
        return sysPermissionMapper.deletePermission(param);
    }
}
