package com.lz.dubbo.mapper.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

/**
 * 获取系统用户信息
 * @author lz
 * @create 2019/7/24
 * @since 1.0.0
 */
@Slf4j
public class SysUserProvider {
    /**
     * 获取系统用户信息
     * @param userName
     * @return
     */
    public String getSysUserInfo(String userName){
        log.debug(userName);
        SQL sql=new SQL();
        sql.SELECT("USER_ID userId","USERNAME userName","PASSWORD password","PHONE phone")
                .FROM("SYS_USER")
                .WHERE("STATUS=0")
                .WHERE("USERNAME=#{userName}");
        return sql.toString();
    }
}
