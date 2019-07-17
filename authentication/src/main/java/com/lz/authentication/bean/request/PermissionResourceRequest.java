package com.lz.authentication.bean.request;

import com.lz.base.util.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限资源信息
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionResourceRequest extends BaseRequest{
    /**
     * 编号
     */
    private String id;
    /**
     * 资源编码
     */
    private String resourceId;

    /**
     * 权限编号
     */
    private String permissionId;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

}
