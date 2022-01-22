package top.vchao.dream.v1.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应结果数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    public ResponseData(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    /**
     * 默认成功返回
     */
    public static ResponseData success() {
        return new ResponseData(ResponseEnum.SUCCESS);
    }

    /**
     * 默认失败返回
     */
    public static ResponseData error() {
        return new ResponseData(ResponseEnum.ERROR);
    }

}
