package top.vchao.dream.v1.modules.message.service;

/**
 * 消息发送/邮件发送 服务
 */
public interface MessageService {

    /**
     * 发送纯文本 邮件
     *
     * @param toEmail 收件邮箱
     * @param subject 邮件主题
     * @param content 邮件正文
     */
    void sendEmail(String toEmail, String subject, String content);
}
