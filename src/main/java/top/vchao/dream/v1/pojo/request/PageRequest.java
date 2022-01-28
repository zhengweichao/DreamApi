package top.vchao.dream.v1.pojo.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 分页请求体
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageRequest extends BaseRequest {
    /**
     * 第几页
     */
    @NotNull(message = "页码不能为空", groups = {page.class})
    @Min(value = 1, message = "页码不能小于1", groups = {page.class})
    private Integer page = 1;

    /**
     * 每页条数
     */
    @NotNull(message = "每页条数不能为空", groups = {page.class})
    @Max(value = 50, message = "每页条数不能大于50", groups = {page.class})
    @Min(value = 1, message = "每页条数不能小于1", groups = {page.class})
    private Integer size = 20;
}
