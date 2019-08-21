package com.lz.email.bean;

import lombok.Data;

/**
 * 发件参数
 * @author lz
 * @create 2019/8/21
 * @since 1.0.0
 */
@Data
public class SendEmailRequest {
    /**
     * 收件人
     */
    private String receiver;

    /**
     * 标题
     */
    private String title;

    /**
     * 发送内容
     */
    private String content;
}
