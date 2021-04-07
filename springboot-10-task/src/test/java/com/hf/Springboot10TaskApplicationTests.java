package com.hf;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Slf4j
@SpringBootTest
class Springboot10TaskApplicationTests {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    /**
     * 简单邮件的设置与发送
     *
     * @param
     * @return void
     * @author xiehongfei
     * @date 2021/4/7 14:50
     */
    @Test
    void contextLoads() {
        // 邮件设置
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知-今晚开会");
        message.setText("Springboot-mail测试");
        message.setTo("1775925790@qq.com");
        message.setFrom("841192493@qq.com");

        javaMailSender.send(message);
    }

    /**
     * 复杂邮件的构造与发送
     *
     * @param
     * @return void
     * @author xiehongfei
     * @date 2021/4/7 14:51
     */
    @Test
    public void test02() {
        MimeMessage mimeMessage = null;
        MimeMessageHelper mimeMessageHelper = null;
        try {
            // 1、创建一个复杂的消息邮件
            mimeMessage = javaMailSender.createMimeMessage();
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            //2、邮件设置
            mimeMessageHelper.setSubject("通知今晚开会");
            mimeMessageHelper.setText("<h1>开会Test</h1>", true);
            mimeMessageHelper.setTo("1775925790@qq.com");
            mimeMessageHelper.setFrom("841192493@qq.com");

            //上传文件
            mimeMessageHelper.addAttachment("超市库存管理系统设计与实现(1).docx", new File("E:\\文档文件\\软件工程\\超市库存管理系统设计与实现(1).docx"));
            mimeMessageHelper.addAttachment("doodles.png",new File("E:\\文档文件\\各种图片\\网站背景图\\doodles.png"));
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("send mail error: " + e);
        }
    }
}
