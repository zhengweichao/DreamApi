package top.vchao.dream.v1.exception;

/**
 * 非白名单访问 异常
 */
public class NoWhiteIpException extends Exception {
    public NoWhiteIpException() {
        super("非白名单访问异常");
    }
}