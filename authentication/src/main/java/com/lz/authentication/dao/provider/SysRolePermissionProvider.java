package com.lz.authentication.dao.provider;

import com.lz.authentication.bean.request.RolePermissionRequest;
import com.lz.authentication.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 系统角色权限
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Slf4j
public class SysRolePermissionProvider {
    /**
     * 获取查询角色权限列表sql
     * @param param
     * @return
     */
    public String getRolePermissionList(RolePermissionRequest param){
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT p.PERMISSION_ID permissionId,p.PERMISSION_NAME permissionName FROM "+Constants.SYS_ROLE_PERMISSION.getKey()+" rp" +
                " ,"+Constants.SYS_PERMISSION.getKey()+" p where rp.PERMISSION_ID=p.PERMISSION_ID ");
        if(param.getRoleId()!=null && !"".equals(param.getRoleId())){
            sb.append(" AND rp.ROLE_ID=#{roleId}");
        }
        return sb.toString();
    }

    /**
     * 获取查询角色权限详情sql
     * @param param
     * @return
     */
    public String getRolePermissionInfo(@Param("param") RolePermissionRequest param){
        log.debug(param.toString());
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT p.PERMISSION_ID permissionId,p.PERMISSION_NAME permissionName FROM "+Constants.SYS_ROLE_PERMISSION.getKey()+" rp" +
                " ,"+Constants.SYS_PERMISSION.getKey()+" p where rp.PERMISSION_ID=p.PERMISSION_ID AND rp.id=#{param.id}");
        return sb.toString();
    }

    /**
     * 获取新增角色权限sql
     * @param param
     * @return
     */
    public String insertRolePermission(RolePermissionRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.INSERT_INTO(Constants.SYS_ROLE_PERMISSION.getKey())
                .INTO_COLUMNS("ID","PERMISSION_ID","ROLE_ID","CREATE_TIME")
                .INTO_VALUES("#{id}","#{permissionId}","#{roleId}","#{createTime}");
        return sql.toString();
    }

    /**
     * 获取修改角色权限sql
     * @param param
     * @return
     */
    public String updateRolePermission(RolePermissionRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.UPDATE(Constants.SYS_ROLE_PERMISSION.getKey())
                .SET("PERMISSION_ID=#{permissionId}","ROLE_ID=#{roleId}","UPDATE_TIME=#{updateTime}")
                .WHERE("id=#{id}");
        return sql.toString();
    }

    /**
     * 获取删除角色权限sql
     * @param param
     * @return
     */
    public String deleteRolePermission(RolePermissionRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.DELETE_FROM(Constants.SYS_ROLE_PERMISSION.getKey());
        if(param.getId()!=null && !"".equals(param.getId())){
            sql.WHERE("id=#{id}");
        }

        if(param.getRoleId()!=null && !"".equals(param.getRoleId())){
            sql.WHERE("ROLE_ID=#{roleId}");
        }

        return sql.toString();
    }
}
