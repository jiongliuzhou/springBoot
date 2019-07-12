package com.lz.authentication.bean;

import lombok.Data;

import java.util.List;

/**
 * 角色
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Data
public class SysRole {
    private Long id;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色拥有的权限
     */
    private List<SysPermission> permissionList;
    public SysRole() {
    }

    public SysRole(String roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }
}
