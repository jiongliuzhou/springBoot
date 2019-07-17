package com.lz.authentication.service;


import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.RoleRequest;
import com.lz.authentication.bean.vo.SysRole;

/**
 *  角色管理
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
public interface SysRoleService {

    /**
     * 获取角色列表（分页）
     * @param param
     * @return
     */
    PageInfo<SysRole> getRoleList(RoleRequest param);

    /**
     * 获取角色信息详情
     * @param param
     * @return
     */
    SysRole getRoleInfo(RoleRequest param);

    /**
     * 增加角色信息
     * @param param
     * @return
     */
    Integer insertRole(RoleRequest param);

    /**
     * 修改角色信息
     * @param param
     * @return
     */
    Integer updateRole(RoleRequest param);

    /**
     * 删除角色信息
     * @param param
     * @return
     */
    Integer deleteRole(RoleRequest param);
}
