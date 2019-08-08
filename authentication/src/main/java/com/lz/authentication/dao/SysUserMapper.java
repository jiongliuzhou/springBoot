package com.lz.authentication.dao;

import com.lz.authentication.bean.request.UserRequest;
import com.lz.authentication.bean.vo.SysUser;
import com.lz.authentication.dao.provider.SysUserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  系统用户管理
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Mapper
public interface SysUserMapper {
    /**
     * 获取用户列表
     * @param param
     * @return
     */
    @SelectProvider(type = SysUserProvider.class,method = "getUserList")
    @Results({
            @Result(property = "userId",column = "id"),
            @Result(property = "roleList",javaType=List.class,column = "userId",
                    many = @Many(select = "com.lz.authentication.dao.SysRoleMapper.getUserRoleById"))})
    List<SysUser> getUserList(UserRequest param);


    /**
     * 获取用户详情
     * @param param
     * @return
     */
    @SelectProvider(type = SysUserProvider.class,method = "getUserInfo")
    @Results({
            @Result(property = "userId",column = "id"),
            @Result(property = "roleList",javaType=List.class,column = "userId",
                    many = @Many(select = "com.lz.authentication.dao.SysRoleMapper.getUserRoleById"))})
    SysUser getUserInfo(@Param("param") UserRequest param);

    /**
     * 增加用户信息
     * @param param
     * @return
     */
    @InsertProvider(type = SysUserProvider.class,method = "insertUser")
    Integer insertUser(UserRequest param);

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    @UpdateProvider(type = SysUserProvider.class,method = "updateUser")
    Integer updateUser(UserRequest param);

    /**
     * 删除用户信息
     * @param param
     * @return
     */
    @DeleteProvider(type = SysUserProvider.class,method = "deleteUser")
    Integer deleteUser(UserRequest param);
}
