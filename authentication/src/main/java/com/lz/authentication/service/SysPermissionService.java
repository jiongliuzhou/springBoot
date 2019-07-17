package com.lz.authentication.service;


import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.PermissionRequest;
import com.lz.authentication.bean.vo.SysPermission;

/**
 *  权限管理
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
public interface SysPermissionService {

    /**
     * 获取权限列表（分页）
     * @param param
     * @return
     */
    PageInfo<SysPermission> getPermissionList(PermissionRequest param);

    /**
     * 获取权限信息详情
     * @param param
     * @return
     */
    SysPermission getPermissionInfo(PermissionRequest param);

    /**
     * 增加权限信息
     * @param param
     * @return
     */
    Integer insertPermission(PermissionRequest param);

    /**
     * 修改权限信息
     * @param param
     * @return
     */
    Integer updatePermission(PermissionRequest param);

    /**
     * 删除权限信息
     * @param param
     * @return
     */
    Integer deletePermission(PermissionRequest param);
}
