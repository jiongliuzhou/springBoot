package com.lz.authentication.dao;

import com.lz.authentication.bean.request.ResourceRequest;
import com.lz.authentication.bean.vo.SysResource;
import com.lz.authentication.dao.provider.SysResourceProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  系统资源管理
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Mapper
public interface SysResourceMapper {
    /**
     * 获取资源列表
     * @param param
     * @return
     */
    @SelectProvider(type = SysResourceProvider.class,method = "getResourceList")
    List<SysResource> getResourceList(ResourceRequest param);

    /**
     * 获取资源列表
     * @param permissionId
     * @return
     */
    @SelectProvider(type = SysResourceProvider.class,method = "getResourceByPermissionId")
    List<SysResource> getResourceByPermissionId(String permissionId);

    /**
     * 获取资源详情
     * @param param
     * @return
     */
    @SelectProvider(type = SysResourceProvider.class,method = "getResourceInfo")
    SysResource getResourceInfo(@Param("param") ResourceRequest param);

    /**
     * 增加资源信息
     * @param param
     * @return
     */
    @InsertProvider(type = SysResourceProvider.class,method = "insertResource")
    Integer insertResource(ResourceRequest param);

    /**
     * 修改资源信息
     * @param param
     * @return
     */
    @UpdateProvider(type = SysResourceProvider.class,method = "updateResource")
    Integer updateResource(ResourceRequest param);

    /**
     * 删除资源信息
     * @param param
     * @return
     */
    @DeleteProvider(type = SysResourceProvider.class,method = "deleteResource")
    Integer deleteResource(ResourceRequest param);
}
