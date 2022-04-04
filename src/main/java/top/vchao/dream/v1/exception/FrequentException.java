package top.vchao.dream.v1.exception;

/**
 * 频繁访问 异常
 */
public class FrequentException extends Exception {
    public FrequentException() {
        super("ip访问过于频繁");
    }

    public FrequentException(String message) {
        super(message);
    }
}