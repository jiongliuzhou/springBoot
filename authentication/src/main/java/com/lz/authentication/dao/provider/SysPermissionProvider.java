package com.lz.authentication.dao.provider;

import com.lz.authentication.bean.request.PermissionRequest;
import com.lz.authentication.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 系统权限
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Slf4j
public class SysPermissionProvider {
    /**
     * 获取查询权限列表sql
     * @param param
     * @return
     */
    public String getPermissionList(PermissionRequest param){
        SQL sql=new SQL();
        sql.SELECT("PERMISSION_ID id","PERMISSION_ID permissionId","PERMISSION_NAME permissionName")
                .FROM(Constants.SYS_PERMISSION.getKey())
                .WHERE("0=0");
        if(param.getPermissionName()!=null && !"".equals(param.getPermissionName())){
            sql.WHERE("PERMISSION_NAME=#{permissionName}");
        }
        return sql.toString();
    }

    /**
     * 根据角色id获取权限id
     * @param roleId
     * @return
     */
    public String getPermissionByRoleId(String roleId){
        StringBuilder sb=new StringBuilder();
        sb.append("select p.PERMISSION_ID id,p.PERMISSION_ID permissionId,p.PERMISSION_NAME permissionName " +
                " from "+Constants.SYS_ROLE_PERMISSION.getKey()+" rp,"+Constants.SYS_PERMISSION.getKey()+" p " +
                " where rp.PERMISSION_ID=p.PERMISSION_ID and rp.ROLE_ID=#{roleId}");
        return sb.toString();
    }

    /**
     * 获取查询权限详情sql
     * @param param
     * @return
     */
    public String getPermissionInfo(@Param("param") PermissionRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.SELECT("PERMISSION_ID permissionId","PERMISSION_NAME permissionName")
                .FROM(Constants.SYS_PERMISSION.getKey())
                .WHERE("PERMISSION_ID=#{param.permissionId}");
        return sql.toString();
    }

    /**
     * 获取新增权限sql
     * @param param
     * @return
     */
    public String insertPermission(PermissionRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.INSERT_INTO(Constants.SYS_PERMISSION.getKey())
                .INTO_COLUMNS("PERMISSION_ID","PERMISSION_NAME","CREATE_TIME")
                .INTO_VALUES("#{permissionId}","#{permissionName}","#{createTime}");
        return sql.toString();
    }

    /**
     * 获取修改权限sql
     * @param param
     * @return
     */
    public String updatePermission(PermissionRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.UPDATE(Constants.SYS_PERMISSION.getKey())
                .SET("PERMISSION_NAME=#{permissionName}","UPDATE_TIME=#{updateTime}")
                .WHERE("PERMISSION_ID=#{ermissionId}");
        return sql.toString();
    }

    /**
     * 获取删除权限sql
     * @param param
     * @return
     */
    public String deletePermission(PermissionRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.DELETE_FROM(Constants.SYS_PERMISSION.getKey())
                .WHERE("PERMISSION_ID=#{permissionId}");
        return sql.toString();
    }
}
