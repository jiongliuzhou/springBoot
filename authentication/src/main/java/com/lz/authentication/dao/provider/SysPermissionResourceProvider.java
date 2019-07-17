package com.lz.authentication.dao.provider;

import com.lz.authentication.bean.request.PermissionResourceRequest;
import com.lz.authentication.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 系统权限资源
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Slf4j
public class SysPermissionResourceProvider {
    /**
     * 获取查询权限资源列表sql
     * @param param
     * @return
     */
    public String getPermissionResourceList(PermissionResourceRequest param){
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT r.RESOURCE_ID resourceId,r.RESOURCE_NAME resourceName,r.URL url,r.PARENT_RESOURCE_ID parentResourceId " +
                " FROM "+Constants.SYS_PERMISSION_RESOURCE.getKey()+" pr,"+Constants.SYS_RESOURCE.getKey()+" r where " +
                " pr.RESOURCE_ID=r.RESOURCE_ID ");
        if(param.getPermissionId()!=null && !"".equals(param.getPermissionId())){
            sb.append(" AND pr.PERMISSION_ID=#{permissionId}");
        }
        return sb.toString();
    }

    /**
     * 获取查询权限资源详情sql
     * @param param
     * @return
     */
    public String getPermissionResourceInfo(@Param("param") PermissionResourceRequest param){
        log.info(param.toString());
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT r.RESOURCE_ID resourceId,r.RESOURCE_NAME resourceName,r.URL url,r.PARENT_RESOURCE_ID parentResourceId " +
                " FROM "+Constants.SYS_PERMISSION_RESOURCE.getKey()+" pr,"+Constants.SYS_RESOURCE.getKey()+" r where " +
                " pr.RESOURCE_ID=r.RESOURCE_ID AND pr.ID=#{param.id}");
        return sb.toString();
    }

    /**
     * 获取新增权限资源sql
     * @param param
     * @return
     */
    public String insertPermissionResource(PermissionResourceRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.INSERT_INTO(Constants.SYS_RESOURCE.getKey())
                .INTO_COLUMNS("ID","RESOURCE_ID","PERMISSION_ID","CREATE_TIME")
                .INTO_VALUES("#{id}","#{resourceId}","#{permissionId}","#{createTime}");
        return sql.toString();
    }

    /**
     * 获取修改权限资源sql
     * @param param
     * @return
     */
    public String updatePermissionResource(PermissionResourceRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.UPDATE(Constants.SYS_RESOURCE.getKey())
                .SET("RESOURCE_ID=#{resourceId}","PERMISSION_ID=#{permissionId}","UPDATE_TIME=#{updateTime}")
                .WHERE("ID=#{id}");
        return sql.toString();
    }

    /**
     * 获取删除权限资源sql
     * @param param
     * @return
     */
    public String deletePermissionResource(PermissionResourceRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.DELETE_FROM(Constants.SYS_RESOURCE.getKey());
        if(param.getId()!=null && !"".equals(param.getId())){
            sql.WHERE("ID=#{id}");
        }
        if(param.getPermissionId()!=null && !"".equals(param.getPermissionId())){
            sql.WHERE("PERMISSION_ID=#{permissionId}");
        }
        return sql.toString();
    }
}
