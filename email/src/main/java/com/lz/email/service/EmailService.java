package com.lz.email.service;

import com.lz.email.bean.SendEmailRequest;

/**
 * 邮件发送
 * @author lz
 * @create 2019/8/21
 * @since 1.0.0
 */
public interface EmailService {
    /**
     * 邮件发送
     * @param request
     */
    void sendEmailOnlyText(SendEmailRequest request) throws Exception;

    /**
     * 邮件发送
     * @param request
     */
    void sendEmail(SendEmailRequest request) throws Exception;
}
