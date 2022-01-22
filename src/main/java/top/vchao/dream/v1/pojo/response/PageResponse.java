package top.vchao.dream.v1.pojo.response;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果集
 */
@Data
public class PageResponse<T> {

    /**
     * 分页信息
     */
    private Pagination pagination;

    /**
     * 结果集
     */
    private List<T> list;

    /**
     * mybatis-plus page 转换
     */
    public PageResponse(Page<T> page) {
        this.setPagination(new Pagination(page));
        this.setList(page.getRecords());
    }

}