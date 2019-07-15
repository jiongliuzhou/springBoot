package com.lz.member.mapper.provider;

import com.lz.member.bean.request.MemberRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 用户管理SQL提供类
 * @create 2019/5/21
 * @since 1.0.0
 */
@Slf4j
public class UserProvider {
    private static final String TABLE_NAME="LZ_MEMBER";
    /**
     * 获取查询用户列表sql
     * @param param
     * @return
     */
    public String getUserList(MemberRequest param){
        SQL sql=new SQL();
        sql.SELECT("MEMBER_ID memberId","MEMBER_NAME memberName","EMAIL email","PHONE phone")
                .FROM(TABLE_NAME);
        sql.WHERE("STATUS=0");
        if(param.getMemberName()!=null && !"".equals(param.getMemberName())){
            sql.WHERE("MEMBER_NAME=#{memberName}");
        }
        return sql.toString();
    }

    /**
     * 获取查询用户详情sql
     * @param param
     * @return
     */
    public String getUserInfo(@Param("param") MemberRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.SELECT("MEMBER_ID memberId","MEMBER_NAME memberName","EMAIL email","PHONE phone")
                .FROM(TABLE_NAME)
                .WHERE("STATUS=0")
                .WHERE("MEMBER_ID=#{param.memberId}");
        return sql.toString();
    }

    /**
     * 获取新增用户sql
     * @param param
     * @return
     */
    public String insertUser(MemberRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.INSERT_INTO(TABLE_NAME)
                .INTO_COLUMNS("MEMBER_ID","MEMBER_NAME","EMAIL","PHONE","CREATE_TIME","STATUS")
                .INTO_VALUES("#{memberId}","#{memberName}","#{email}","#{phone}","#{createTime}","#{status}");
        return sql.toString();
    }

    /**
     * 获取修改用户sql
     * @param param
     * @return
     */
    public String updateUser(MemberRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.UPDATE(TABLE_NAME)
                .SET("MEMBER_NAME=#{memberName}","EMAIL=#{email}","PHONE=#{phone}","UPDATE_TIME=#{updateTime}")
                .WHERE("MEMBER_ID=#{memberId}");
        return sql.toString();
    }

    /**
     * 获取删除用户sql
     * @param param
     * @return
     */
    public String deleteUser(MemberRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.DELETE_FROM(TABLE_NAME)
                .WHERE("MEMBER_ID=#{memberId}");
        return sql.toString();
    }
}
