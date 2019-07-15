package com.lz.member.mapper;

import com.lz.member.bean.request.MemberRequest;
import com.lz.member.bean.vo.MemberVO;
import com.lz.member.mapper.provider.MemberProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  会员管理mapper
 * @create 2019/5/21
 * @since 1.0.0
 */
@Mapper
public interface MemberMapper {
    /**
     * 获取会员列表
     * @param param
     * @return
     */
    @SelectProvider(type = MemberProvider.class,method = "getMemberList")
    List<MemberVO> getMemberList(MemberRequest param);

    /**
     * 获取会员详情
     * @param param
     * @return
     */
    @SelectProvider(type = MemberProvider.class,method = "getMemberInfo")
    MemberVO getMemberInfo(@Param("param") MemberRequest param);

    /**
     * 增加会员信息
     * @param param
     * @return
     */
    @InsertProvider(type = MemberProvider.class,method = "insertMember")
    Integer insertMember(MemberRequest param);

    /**
     * 修改会员信息
     * @param param
     * @return
     */
    @UpdateProvider(type = MemberProvider.class,method = "updateMember")
    Integer updateMember(MemberRequest param);

    /**
     * 删除会员信息
     * @param param
     * @return
     */
    @DeleteProvider(type = MemberProvider.class,method = "deleteMember")
    Integer deleteMember(MemberRequest param);
}
