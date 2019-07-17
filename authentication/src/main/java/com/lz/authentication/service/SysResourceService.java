package com.lz.authentication.service;


import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.ResourceRequest;
import com.lz.authentication.bean.vo.SysResource;

/**
 *  资源管理
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
public interface SysResourceService {

    /**
     * 获取资源列表（分页）
     * @param param
     * @return
     */
    PageInfo<SysResource> getResourceList(ResourceRequest param);

    /**
     * 获取资源信息详情
     * @param param
     * @return
     */
    SysResource getResourceInfo(ResourceRequest param);

    /**
     * 增加资源信息
     * @param param
     * @return
     */
    Integer insertResource(ResourceRequest param);

    /**
     * 修改资源信息
     * @param param
     * @return
     */
    Integer updateResource(ResourceRequest param);

    /**
     * 删除资源信息
     * @param param
     * @return
     */
    Integer deleteResource(ResourceRequest param);
}
