package com.lz.authentication.dao.provider;

import com.lz.authentication.bean.request.RoleRequest;
import com.lz.authentication.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 系统角色
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Slf4j
public class SysRoleProvider {
    /**
     * 获取查询角色列表sql
     * @param param
     * @return
     */
    public String getRoleList(RoleRequest param){
        SQL sql=new SQL();
        sql.SELECT("ROLE_ID roleId","ROLE_NAME roleName")
                .FROM(Constants.SYS_ROLE.getKey());
        sql.WHERE("0=0");
        if(param.getRoleName()!=null && !"".equals(param.getRoleName())){
            sql.WHERE("ROLE_NAME=#{RoleName}");
        }
        return sql.toString();
    }

    /**
     * 获取查询角色详情sql
     * @param param
     * @return
     */
    public String getRoleInfo(@Param("param") RoleRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.SELECT("ROLE_ID roleId","ROLE_NAME roleName")
                .FROM(Constants.SYS_ROLE.getKey())
                .WHERE("ROLE_ID=#{param.roleId}");
        return sql.toString();
    }

    /**
     * 获取新增角色sql
     * @param param
     * @return
     */
    public String insertRole(RoleRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.INSERT_INTO(Constants.SYS_ROLE.getKey())
                .INTO_COLUMNS("ROLE_ID","ROLE_NAME","CREATE_TIME")
                .INTO_VALUES("#{roleId}","#{roleName}","#{createTime}");
        return sql.toString();
    }

    /**
     * 获取修改角色sql
     * @param param
     * @return
     */
    public String updateRole(RoleRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.UPDATE(Constants.SYS_ROLE.getKey())
                .SET("ROLE_NAME=#{roleName}","UPDATE_TIME=#{updateTime}")
                .WHERE("ROLE_ID=#{roleId}");
        return sql.toString();
    }

    /**
     * 获取删除角色sql
     * @param param
     * @return
     */
    public String deleteRole(RoleRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.DELETE_FROM(Constants.SYS_ROLE.getKey())
                .WHERE("ROLE_ID=#{roleId}");
        return sql.toString();
    }
}
