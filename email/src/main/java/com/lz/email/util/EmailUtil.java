package com.lz.email.util;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * 邮件发送工具类
 * @author lz
 * @create 2019/8/21
 * @since 1.0.0
 */
public class EmailUtil {
    private EmailUtil(){
    }
    private static final String EMAIL_HOST="smtp.dse.cn";
    private static final String EMAIL_PROTOCOL="smtp";
    private static final String EMAIL_AUTH="true";
    private static final String EMAIL_SENDER="zhou_liu@dse.cn";
    private static final String EMAIL_SCRECT="liuzhou";
    private static final String EMAIL_NICK="啊我是一个小男孩";

    /**
     * 纯文本格式
     * @param receiver 收件人
     * @param title 邮件标题
     * @param body 邮件内容
     * @throws Exception
     */
    public static void sendEmailOnlyText(String receiver,String title,String body)throws Exception{
        Properties prop = new Properties();
        prop.setProperty("mail.host",EMAIL_HOST);
        prop.setProperty("mail.transport.protocol",EMAIL_PROTOCOL);
        prop.setProperty("mail.smtp.auth",EMAIL_AUTH);
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人
        ts.connect(EMAIL_HOST,EMAIL_SENDER,EMAIL_SCRECT);
        //4、创建邮件
        Message message = createEmailText(session,receiver,title,body);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    /**
     * 邮箱发送复杂格式
     */
    public static void sendEmail(String receiver,String title,String body) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host",EMAIL_HOST);
        prop.setProperty("mail.transport.protocol",EMAIL_PROTOCOL);
        prop.setProperty("mail.smtp.auth",EMAIL_AUTH);
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人
        ts.connect(EMAIL_HOST,EMAIL_SENDER,EMAIL_SCRECT);
        //4、创建邮件
        Message message = createEmail(session,receiver,title,body);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    private static MimeMessage createEmail(Session session,String receiver,String title,String body) throws Exception{
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        String nick = javax.mail.internet.MimeUtility.encodeText(EMAIL_NICK);
        message.setFrom(new InternetAddress(nick+"<"+EMAIL_SENDER+">"));
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        //邮件的标题
        message.setSubject(title);

        MimeMultipart mimeMultipart=new MimeMultipart();
        //文本内容
        MimeBodyPart text = new MimeBodyPart() ;
        text.setContent(body,"text/html;charset=UTF-8");
        mimeMultipart.addBodyPart(text);

        addAttach(mimeMultipart,"email/test.png");
        addAttach(mimeMultipart,"email/test.sql");

        //封装MimeMessage对象
        message.setContent(mimeMultipart);
        message.saveChanges();
        return message;
    }

    /**
     * 绑定附件
     * @param mimeMultipart
     * @param attachPath 附件路径
     * @throws Exception
     */
    private static void addAttach(MimeMultipart mimeMultipart,String attachPath) throws Exception{
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler file = new DataHandler(new FileDataSource(attachPath));
        attach.setDataHandler(file);
        attach.setFileName(file.getName());
        mimeMultipart.addBodyPart(attach);
    }

    /**
     * 创建文本邮件
     */
    private static MimeMessage createEmailText(Session session,String receiver,String title,String body)throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        String nick = javax.mail.internet.MimeUtility.encodeText(EMAIL_NICK);
        message.setFrom(new InternetAddress(nick+"<"+EMAIL_SENDER+">"));
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        //邮件的标题
        message.setSubject(title);
        //邮件的文本内容
        message.setContent(body, "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }
}
