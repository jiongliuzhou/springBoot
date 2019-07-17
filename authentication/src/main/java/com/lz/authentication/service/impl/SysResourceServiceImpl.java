package com.lz.authentication.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.authentication.bean.request.ResourceRequest;
import com.lz.authentication.bean.vo.SysResource;
import com.lz.authentication.dao.SysResourceMapper;
import com.lz.authentication.service.SysResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Service("sysResourceServiceImpl")
@Transactional
public class SysResourceServiceImpl implements SysResourceService {
    @Resource
    private SysResourceMapper sysResourceMapper;

    /**
     * 获取角色列表(分页)
     * @param param
     * @return
     */
    @Override
    public PageInfo<SysResource> getResourceList(ResourceRequest param){
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        return new PageInfo<>(sysResourceMapper.getResourceList(param));
    }

    /**
     * 获取角色信息详情
     * @param param
     * @return
     */
    @Override
    public SysResource getResourceInfo(ResourceRequest param){
        return sysResourceMapper.getResourceInfo(param);
    }

    /**
     * 增加角色信息
     * @param param
     * @return
     */
    @Override
    public Integer insertResource(ResourceRequest param){
        return sysResourceMapper.insertResource(param);
    }

    /**
     * 修改角色信息
     * @param param
     * @return
     */
    @Override
    public Integer updateResource(ResourceRequest param){
        return sysResourceMapper.updateResource(param);
    }

    /**
     * 删除角色信息
     * @param param
     * @return
     */
    @Override
    public Integer deleteResource(ResourceRequest param){
        return sysResourceMapper.deleteResource(param);
    }
}
