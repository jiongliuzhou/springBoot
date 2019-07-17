package com.lz.authentication.dao;

import com.lz.authentication.bean.request.RolePermissionRequest;
import com.lz.authentication.bean.vo.SysPermission;
import com.lz.authentication.dao.provider.SysRolePermissionProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  系统角色权限管理
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Mapper
public interface SysRolePermissionMapper {
    /**
     * 获取角色权限列表
     * @param param
     * @return
     */
    @SelectProvider(type = SysRolePermissionProvider.class,method = "getRolePermissionList")
    List<SysPermission> getRolePermissionList(RolePermissionRequest param);

    /**
     * 获取角色权限详情
     * @param param
     * @return
     */
    @SelectProvider(type = SysRolePermissionProvider.class,method = "getRolePermissionInfo")
    SysPermission getRolePermissionInfo(@Param("param") RolePermissionRequest param);

    /**
     * 增加角色权限信息
     * @param param
     * @return
     */
    @InsertProvider(type = SysRolePermissionProvider.class,method = "insertRolePermission")
    Integer insertRolePermission(RolePermissionRequest param);

    /**
     * 修改角色权限信息
     * @param param
     * @return
     */
    @UpdateProvider(type = SysRolePermissionProvider.class,method = "updateRolePermission")
    Integer updateRolePermission(RolePermissionRequest param);

    /**
     * 删除角色权限信息
     * @param param
     * @return
     */
    @DeleteProvider(type = SysRolePermissionProvider.class,method = "deleteRolePermission")
    Integer deleteRolePermission(RolePermissionRequest param);
}
