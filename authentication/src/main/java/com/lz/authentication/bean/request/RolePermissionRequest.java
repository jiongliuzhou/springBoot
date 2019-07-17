package com.lz.authentication.bean.request;

import com.lz.base.util.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色权限信息
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionRequest extends BaseRequest{
    /**
     * 编号
     */
    private String id;
    /**
     * 权限编号
     */
    private String permissionId;

    /**
     * 角色编号
     */
    private String roleId;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

}
