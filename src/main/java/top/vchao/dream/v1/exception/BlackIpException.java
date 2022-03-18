package top.vchao.dream.v1.exception;

/**
 * 黑名单访问 异常
 */
public class BlackIpException extends Exception {
    public BlackIpException() {
        super("黑名单IP限制访问");
    }
}