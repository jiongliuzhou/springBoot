package com.lz.member.bean.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *  页面返回bean
 * @create 2019/5/21
 * @since 1.0.0
 */
@Data
@ToString
@NoArgsConstructor
public class MemberVO {
    /**
     * 编号
     */
    private String memberId;
    /**
     * 用户名
     */
    private String memberName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String phone;

    /**
     * 密码
     */
    private String memberPassword;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 状态
     */
    private String status;
}
