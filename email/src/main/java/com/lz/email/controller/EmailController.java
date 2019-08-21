package com.lz.email.controller;

import com.lz.base.util.base.ResultInvoke;
import com.lz.base.util.exception.ExceptionHelper;
import com.lz.email.bean.SendEmailRequest;
import com.lz.email.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 邮件发送
 * @author lz
 * @create 2019/8/21
 * @since 1.0.0
 */
@RestController
@RequestMapping("/emailController")
@Slf4j
public class EmailController {
    @Resource(name="emailServiceImpl")
    private EmailService emailService;

    /**
     * 文本邮件发送
     * @param request
     * @return
     */
    @RequestMapping("/sendEmailOnlyText")
    public Object sendEmailOnlyText(@RequestBody SendEmailRequest request){
        Object obj= ResultInvoke.success();
        try {
            emailService.sendEmailOnlyText(request);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj=ResultInvoke.fail();
        }
        return obj;
    }

    /**
     * 文本邮件发送
     * @param request
     * @return
     */
    @RequestMapping("/sendEmail")
    public Object sendEmail(@RequestBody SendEmailRequest request){
        Object obj= ResultInvoke.success();
        try {
            emailService.sendEmail(request);
        }catch (Exception e){
            log.error(ExceptionHelper.dealException(e));
            obj=ResultInvoke.fail();
        }
        return obj;
    }
}
