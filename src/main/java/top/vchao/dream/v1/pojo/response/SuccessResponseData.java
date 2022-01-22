package top.vchao.dream.v1.pojo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 成功响应结果
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SuccessResponseData<T> extends ResponseData {

    private T data;

    public SuccessResponseData() {
        super(ResponseEnum.SUCCESS);
    }

    public SuccessResponseData(String message) {
        super(ResponseEnum.SUCCESS.getCode(), message);
    }

    public SuccessResponseData(T object) {
        super(ResponseEnum.SUCCESS);
        this.data = object;
    }

    public SuccessResponseData(String message, T object) {
        super(ResponseEnum.SUCCESS.getCode(), message);
        this.data = object;
    }
}
