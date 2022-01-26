package top.vchao.dream.v1.pojo.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 分页请求体
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageRequest extends BaseRequest {
    /**
     * 第几页
     */
    @Min(value = 1, message = "page不能小于1", groups = {page.class})
    private Integer page = 1;

    /**
     * 每页条数
     */
    @Max(value = 50, message = "size不能大于50", groups = {page.class})
    @Min(value = 1, message = "size不能小于1", groups = {page.class})
    private Integer size = 20;
}
