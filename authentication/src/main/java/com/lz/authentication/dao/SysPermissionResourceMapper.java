package com.lz.authentication.dao;

import com.lz.authentication.bean.request.PermissionResourceRequest;
import com.lz.authentication.bean.vo.SysResource;
import com.lz.authentication.dao.provider.SysPermissionResourceProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  系统权限资源管理
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Mapper
public interface SysPermissionResourceMapper {
    /**
     * 获取权限资源列表
     * @param param
     * @return
     */
    @SelectProvider(type = SysPermissionResourceProvider.class,method = "getPermissionResourceList")
    List<SysResource> getPermissionResourceList(PermissionResourceRequest param);

    /**
     * 获取权限资源详情
     * @param param
     * @return
     */
    @SelectProvider(type = SysPermissionResourceProvider.class,method = "getPermissionResourceInfo")
    SysResource getPermissionResourceInfo(@Param("param") PermissionResourceRequest param);

    /**
     * 增加权限资源信息
     * @param param
     * @return
     */
    @InsertProvider(type = SysPermissionResourceProvider.class,method = "insertPermissionResource")
    Integer insertPermissionResource(PermissionResourceRequest param);

    /**
     * 修改权限资源信息
     * @param param
     * @return
     */
    @UpdateProvider(type = SysPermissionResourceProvider.class,method = "updatePermissionResource")
    Integer updatePermissionResource(PermissionResourceRequest param);

    /**
     * 删除权限资源信息
     * @param param
     * @return
     */
    @DeleteProvider(type = SysPermissionResourceProvider.class,method = "deletePermissionResource")
    Integer deletePermissionResource(PermissionResourceRequest param);
}
