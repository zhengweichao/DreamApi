package top.vchao.dream.message;

import com.github.jaemon.dinger.DingerSender;
import com.github.jaemon.dinger.core.entity.DingerRequest;
import com.github.jaemon.dinger.core.entity.enums.MessageSubType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;

/**
 * 消息发送测试类
 */
@SpringBootTest
public class MessageTest {

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    /**
     * 发送邮件
     * @throws MailException 发送邮件失败
     */
    @Test
    public void sendMail() throws MailException {
        // 主题
        String subject = "邮箱主题";
        // 内容
        String content = "邮箱内容";
        // 收件邮箱
        String toEmail = "game@vchao.top";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail); // 邮件发送者
        message.setTo(toEmail); // 邮件接受者
        message.setSubject(subject); // 主题
        message.setText(content); // 内容

        mailSender.send(message);
    }

    @Resource
    private DingerSender dingerSender;

    /**
     * 发送钉钉消息
     */
    @Test
    public void sendDingDing() {
        // 发送text类型消息
        dingerSender.send(
                MessageSubType.TEXT,
                DingerRequest.request("Hello World, Hello Dinger")
        );
    }
}
