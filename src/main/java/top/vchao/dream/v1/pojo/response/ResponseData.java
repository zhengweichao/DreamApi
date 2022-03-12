package top.vchao.dream.v1.pojo.response;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * 成功返回 - 数据
     */
    public static <T> SuccessResponseData<T> success(T object) {
        return new SuccessResponseData<>(object);
    }

    /**
     * 成功返回 - 分页数据
     */
    public static <T> SuccessResponseData<PageResponse<T>> successPage(Page<T> page) {
        return new SuccessResponseData<>(new PageResponse<>(page));
    }

    /**
     * 成功返回 - 消息 和 数据
     */
    public static <T> SuccessResponseData<T> success(String message, T object) {
        return new SuccessResponseData<>(message, object);
    }

    /**
     * 默认失败返回
     */
    public static ResponseData error() {
        return new ResponseData(ResponseEnum.ERROR);
    }

}
