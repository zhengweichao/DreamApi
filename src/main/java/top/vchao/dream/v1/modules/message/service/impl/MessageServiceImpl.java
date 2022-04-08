package top.vchao.dream.v1.modules.message.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import top.vchao.dream.v1.modules.message.service.MessageService;

import javax.annotation.Resource;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String fromEmail;


    @Override
    public void sendEmail(String toEmail, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail); // 邮件发送者
        message.setTo(toEmail); // 邮件接受者
        message.setSubject(subject); // 主题
        message.setText(content); // 内容

        mailSender.send(message);
    }

}
