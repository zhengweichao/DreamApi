package top.vchao.dream.v1.pojo.response;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pagination {
    /**
     * 第几页
     */
    private Integer page = 1;

    /**
     * 每页条数
     */
    private Integer size = 20;

    /**
     * 总记录数
     */
    private Integer total = 0;

    public <T> Pagination(Page<T> page) {
        this.setTotal(Convert.toInt(page.getTotal()));
        this.setPage(Convert.toInt(page.getCurrent()));
        this.setSize(Convert.toInt(page.getSize()));
    }
}
