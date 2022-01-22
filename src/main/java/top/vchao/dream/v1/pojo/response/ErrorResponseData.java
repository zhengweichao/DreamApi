package top.vchao.dream.v1.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 失败响应结果
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ErrorResponseData extends ResponseData {

    public ErrorResponseData(Integer code, String message) {
        super(code, message);
    }

    public ErrorResponseData(ResponseEnum responseEnum) {
        super(responseEnum);
    }
}
