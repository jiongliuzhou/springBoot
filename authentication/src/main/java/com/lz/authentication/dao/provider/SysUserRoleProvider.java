package com.lz.authentication.dao.provider;

import com.lz.authentication.bean.request.UserRoleRequest;
import com.lz.authentication.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 系统用户角色
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Slf4j
public class SysUserRoleProvider {
    /**
     * 获取查询用户角色列表sql
     * @param param
     * @return
     */
    public String getUserRoleList(UserRoleRequest param){
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT r.ROLE_ID roleId,ROLE_NAME roleName FROM "+Constants.SYS_ROLE.getKey()+" r" +
                " ,"+Constants.SYS_USER_ROLE.getKey()+" ur where ur.role_id=r.role_id ");
        if(param.getUserId()!=null && !"".equals(param.getUserId())){
            sb.append(" AND ur.USER_ID=#{userId}");
        }
        return sb.toString();
    }

    /**
     * 获取查询用户角色详情sql
     * @param param
     * @return
     */
    public String getUserRoleInfo(@Param("param") UserRoleRequest param){
        log.info(param.toString());
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT r.ROLE_ID roleId,ROLE_NAME roleName FROM "+Constants.SYS_ROLE.getKey()+" r" +
                ","+Constants.SYS_USER_ROLE.getKey()+" ur where ur.role_id=r.role_id AND ID=#{param.id}");
        return sb.toString();
    }

    /**
     * 获取新增用户角色sql
     * @param param
     * @return
     */
    public String insertUserRole(UserRoleRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.INSERT_INTO(Constants.SYS_USER_ROLE.getKey())
                .INTO_COLUMNS("ID","USER_ID","ROLE_ID","CREATE_TIME")
                .INTO_VALUES("#{id}","#{userId}","#{roleId}","#{createTime}");
        return sql.toString();
    }

    /**
     * 获取修改用户角色sql
     * @param param
     * @return
     */
    public String updateUserRole(UserRoleRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.UPDATE(Constants.SYS_USER_ROLE.getKey())
                .SET("USER_ID=#{userId}","ROLE_ID=#{roleId}","UPDATE_TIME=#{updateTime}")
                .WHERE("ID=#{id}");
        return sql.toString();
    }

    /**
     * 获取删除用户角色sql
     * @param param
     * @return
     */
    public String deleteUserRole(UserRoleRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.DELETE_FROM(Constants.SYS_USER_ROLE.getKey());
        if(param.getId()!=null && !"".equals(param.getId())){
            sql.WHERE("ID=#{id}");
        }
        if(param.getUserId()!=null && !"".equals(param.getUserId())){
            sql.WHERE("USER_ID=#{userId}");
        }
        return sql.toString();
    }
}
