package com.lz.authentication.dao.provider;

import com.lz.authentication.bean.request.UserRequest;
import com.lz.authentication.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 系统用户
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Slf4j
public class SysUserProvider {
    /**
     * 获取查询用户列表sql
     * @param param
     * @return
     */
    public String getUserList(UserRequest param){
        SQL sql=new SQL();
        sql.SELECT("USER_ID id","USER_ID userId","USERNAME userName","PASSWORD password","PHONE phone")
                .FROM(Constants.SYS_USER.getKey());
        sql.WHERE("STATUS=0");
        if(param.getUserName()!=null && !"".equals(param.getUserName())){
            sql.WHERE("USERNAME=#{userName}");
        }
        return sql.toString();
    }

    /**
     * 获取查询用户详情sql
     * @param param
     * @return
     */
    public String getUserInfo(@Param("param") UserRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.SELECT("USER_ID userId","USERNAME userName","PASSWORD password","PHONE phone")
                .FROM(Constants.SYS_USER.getKey())
                .WHERE("STATUS=0")
                .WHERE("USER_ID=#{param.userId}");
        return sql.toString();
    }

    /**
     * 获取新增用户sql
     * @param param
     * @return
     */
    public String insertUser(UserRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.INSERT_INTO(Constants.SYS_USER.getKey())
                .INTO_COLUMNS("USER_ID","USERNAME","PHONE","PASSWORD","CREATE_TIME","STATUS")
                .INTO_VALUES("#{userId}","#{userName}","#{password}","#{phone}","#{createTime}","#{status}");
        return sql.toString();
    }

    /**
     * 获取修改用户sql
     * @param param
     * @return
     */
    public String updateUser(UserRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.UPDATE(Constants.SYS_USER.getKey())
                .SET("USER_NAME=#{userName}","PASSWORD=#{password}","PHONE=#{phone}","UPDATE_TIME=#{updateTime}")
                .WHERE("USER_ID=#{userId}");
        return sql.toString();
    }

    /**
     * 获取删除用户sql
     * @param param
     * @return
     */
    public String deleteUser(UserRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.DELETE_FROM(Constants.SYS_USER.getKey())
                .WHERE("USER_ID=#{userId}");
        return sql.toString();
    }
}
