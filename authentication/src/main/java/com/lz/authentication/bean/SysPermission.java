package com.lz.authentication.bean;

import lombok.Data;

/**
 *  权限
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Data
public class SysPermission {
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限字符串
     */
    private String code;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * URL
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父菜单ID
     */
    private Long pid;
}
