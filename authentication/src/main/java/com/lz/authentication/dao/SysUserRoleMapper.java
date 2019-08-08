package com.lz.authentication.dao;

import com.lz.authentication.bean.request.UserRoleRequest;
import com.lz.authentication.bean.vo.SysRole;
import com.lz.authentication.dao.provider.SysUserRoleProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  系统用户管理
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Mapper
public interface SysUserRoleMapper {
    /**
     * 获取用户列表
     * @param param
     * @return
     */
    @SelectProvider(type = SysUserRoleProvider.class,method = "getUserRoleList")
    List<SysRole> getUserRoleList(UserRoleRequest param);

    /**
     * 获取用户详情
     * @param param
     * @return
     */
    @SelectProvider(type = SysUserRoleProvider.class,method = "getUserRoleInfo")
    SysRole getUserRoleInfo(@Param("param") UserRoleRequest param);

    /**
     * 增加用户信息
     * @param param
     * @return
     */
    @InsertProvider(type = SysUserRoleProvider.class,method = "insertUserRole")
    Integer insertUserRole(UserRoleRequest param);

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    @UpdateProvider(type = SysUserRoleProvider.class,method = "updateUserRole")
    Integer updateUserRole(UserRoleRequest param);

    /**
     * 删除用户信息
     * @param param
     * @return
     */
    @DeleteProvider(type = SysUserRoleProvider.class,method = "deleteUserRole")
    Integer deleteUserRole(UserRoleRequest param);
}
