package com.lz.authentication.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysResource {
    /**
     * 资源编码
     */
    private String resourceId;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 父资源编码
     */
    private String parentResourceId;
}
