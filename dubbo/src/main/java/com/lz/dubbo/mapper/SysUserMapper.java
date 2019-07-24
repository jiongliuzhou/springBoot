package com.lz.dubbo.mapper;

import com.lz.api.bean.vo.UserInfo;
import com.lz.dubbo.mapper.provider.SysUserProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

/**
 *  获取系统用户信息mapper
 * @create 2019/5/21
 * @since 1.0.0
 */
@Mapper
public interface SysUserMapper {
    /**
     * 获取系统用户信息
     * @param userName
     * @return
     */
    @SelectProvider(type = SysUserProvider.class,method = "getSysUserInfo")
    UserInfo getSysUserInfo(String userName);

}
