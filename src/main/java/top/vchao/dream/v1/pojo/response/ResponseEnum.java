package top.vchao.dream.v1.pojo.response;

import lombok.Getter;

/**
 * 返回结果的枚举类
 */
@Getter
public enum ResponseEnum {
    // 成功
    SUCCESS(200, "success"),

    //============    请求错误    ==============
    // 参数校验错误
    ERROR_PARAM(400, "参数验证错误"),
    ERROR_PARAM_DATE(400, "时间参数不合规"),
    ERROR_NOT_ALLOW_DOMAIN(400, "该域名不允许进行查询"),

    // 鉴权失败
    LOGIN_VERIFY_FALL(401, "登录失效"),
    SIGN_ERROR(401, "签名错误或重复请求"),
    AUTH_FAILED(401, "权限验证失败"),
    ERROR_BOX_DOMAIN(401, "该域名已在开放规划中，请持续关注"),

    // 操作失败
    DATA_NOT(403, "没有相关数据"),
    DATA_CHANGE(403, "数据没有任何更改"),
    DATA_REPEAT(403, "数据已存在"),
    ACTION_ERROR(403, "操作失败"),
    FREQUENTLY_REQUEST(403, "请求过于频繁"),
    BLACK_IP(403, "您所在的网络已经被限制访问"),

    // 请求方式错误
    NOT_SUPPORT(405, "请求方式错误"),


    //============    服务器错误    ==============
    // 内部错误
    NOT_NETWORK(500, "系统繁忙，请稍后再试。"),
    NOT_KNOW(500, "未知错误"),
    ERROR(500, "系统内部错误，请联系管理员"),

    // 连接超时
    HTTP_CONNECTION_OVERTIME(504, "连接超时"),

    ;

    private final Integer code;

    private final String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
