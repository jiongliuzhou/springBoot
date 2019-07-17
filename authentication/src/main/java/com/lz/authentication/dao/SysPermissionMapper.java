package com.lz.authentication.dao;

import com.lz.authentication.bean.request.PermissionRequest;
import com.lz.authentication.bean.vo.SysPermission;
import com.lz.authentication.dao.provider.SysPermissionProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  系统权限管理
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Mapper
public interface SysPermissionMapper {
    /**
     * 获取权限列表
     * @param param
     * @return
     */
    @SelectProvider(type = SysPermissionProvider.class,method = "getPermissionList")
    List<SysPermission> getPermissionList(PermissionRequest param);

    /**
     * 获取权限详情
     * @param param
     * @return
     */
    @SelectProvider(type = SysPermissionProvider.class,method = "getPermissionInfo")
    SysPermission getPermissionInfo(@Param("param") PermissionRequest param);

    /**
     * 增加权限信息
     * @param param
     * @return
     */
    @InsertProvider(type = SysPermissionProvider.class,method = "insertPermission")
    Integer insertPermission(PermissionRequest param);

    /**
     * 修改权限信息
     * @param param
     * @return
     */
    @UpdateProvider(type = SysPermissionProvider.class,method = "updatePermission")
    Integer updatePermission(PermissionRequest param);

    /**
     * 删除权限信息
     * @param param
     * @return
     */
    @DeleteProvider(type = SysPermissionProvider.class,method = "deletePermission")
    Integer deletePermission(PermissionRequest param);
}
