package com.lz.authentication.bean.request;

import com.lz.base.util.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色信息
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleRequest extends BaseRequest{
    /**
     * 编号
     */
    private String id;
    /**
     * 角色编码
     */
    private String roleId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

}
