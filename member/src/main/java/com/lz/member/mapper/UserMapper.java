package com.lz.member.mapper;

import com.lz.member.bean.request.MemberRequest;
import com.lz.member.bean.vo.MemberVO;
import com.lz.member.mapper.provider.UserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  用户管理mapper
 * @create 2019/5/21
 * @since 1.0.0
 */
@Mapper
public interface UserMapper {
    /**
     * 获取用户列表
     * @param param
     * @return
     */
    @SelectProvider(type = UserProvider.class,method = "getUserList")
    List<MemberVO> getUserList(MemberRequest param);

    /**
     * 获取用户详情
     * @param param
     * @return
     */
    @SelectProvider(type = UserProvider.class,method = "getUserInfo")
    MemberVO getUserInfo(@Param("param") MemberRequest param);

    /**
     * 增加用户信息
     * @param param
     * @return
     */
    @InsertProvider(type = UserProvider.class,method = "insertUser")
    Integer insertUser(MemberRequest param);

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    @UpdateProvider(type = UserProvider.class,method = "updateUser")
    Integer updateUser(MemberRequest param);

    /**
     * 删除用户信息
     * @param param
     * @return
     */
    @DeleteProvider(type = UserProvider.class,method = "deleteUser")
    Integer deleteUser(MemberRequest param);
}
