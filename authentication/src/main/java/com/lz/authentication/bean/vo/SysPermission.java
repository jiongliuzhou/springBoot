package com.lz.authentication.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *  权限
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {
    /**
     * 编号
     */
    private String permissionId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 资源列表
     */
    private List<SysResource> resourceList;
}
