package com.lz.authentication.dao;

import com.lz.authentication.bean.request.RoleRequest;
import com.lz.authentication.bean.vo.SysRole;
import com.lz.authentication.dao.provider.SysRoleProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  系统角色管理
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Mapper
public interface SysRoleMapper {
    /**
     * 获取角色列表
     * @param param
     * @return
     */
    @SelectProvider(type = SysRoleProvider.class,method = "getRoleList")
    @Results({
            @Result(property = "roleId",column = "id"),
            @Result(property = "permissionList",javaType=List.class,column = "roleId",
                    many = @Many(select = "com.lz.authentication.dao.SysPermissionMapper.getPermissionByRoleId"))})
    List<SysRole> getRoleList(RoleRequest param);

    /**
     * 获取用户角色列表
     * @param userId
     * @return
     */
    @SelectProvider(type = SysRoleProvider.class,method = "getUserRoleById")
    @Results({
            @Result(property = "roleId",column = "id"),
            @Result(property = "permissionList",javaType=List.class,column = "roleId",
                    many = @Many(select = "com.lz.authentication.dao.SysPermissionMapper.getPermissionByRoleId"))})
    List<SysRole> getUserRoleById(String userId);

    /**
     * 获取角色详情
     * @param param
     * @return
     */
    @SelectProvider(type = SysRoleProvider.class,method = "getRoleInfo")
    SysRole getRoleInfo(@Param("param") RoleRequest param);

    /**
     * 增加角色信息
     * @param param
     * @return
     */
    @InsertProvider(type = SysRoleProvider.class,method = "insertRole")
    Integer insertRole(RoleRequest param);

    /**
     * 修改角色信息
     * @param param
     * @return
     */
    @UpdateProvider(type = SysRoleProvider.class,method = "updateRole")
    Integer updateRole(RoleRequest param);

    /**
     * 删除角色信息
     * @param param
     * @return
     */
    @DeleteProvider(type = SysRoleProvider.class,method = "deleteRole")
    Integer deleteRole(RoleRequest param);
}
