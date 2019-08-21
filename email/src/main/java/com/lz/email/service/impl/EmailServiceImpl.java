package com.lz.email.service.impl;

import com.lz.email.bean.SendEmailRequest;
import com.lz.email.service.EmailService;
import com.lz.email.util.EmailUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *  邮件发送服务
 * @author lz
 * @create 2019/8/21
 * @since 1.0.0
 */
@Service("emailServiceImpl")
public class EmailServiceImpl implements EmailService{
    /**
     * 邮件发送
     * @param request
     */
    @Override
    @Async("taskExecutor")
    public void sendEmailOnlyText(SendEmailRequest request) throws Exception{
        // 异步执行
        Thread.sleep(1000);
        String textBody =request.getContent();
        // 发送文本邮件
        EmailUtil.sendEmailOnlyText(request.getReceiver(),request.getTitle(),textBody);
    }

    @Override
    @Async("taskExecutor")
    public void sendEmail(SendEmailRequest request) throws Exception{
        // 异步执行
        Thread.sleep(1000);
        String textBody =request.getContent();
        // 发送复杂邮件:文本+图片+附件
        EmailUtil.sendEmail(request.getReceiver(),request.getTitle(),textBody);
    }
}
