package top.vchao.dream.v1.pojo.request;

import lombok.Data;

@Data
public class BaseRequest {

    /**
     * 参数校验分组：增 - 增加
     */
    public @interface add {
    }

    /**
     * 参数校验分组：删 - 删除
     */
    public @interface delete {
    }

    /**
     * 参数校验分组：改 - 更新信息
     */
    public @interface update {
    }

    /**
     * 参数校验分组：查 - 列表
     */
    public @interface list {
    }

    /**
     * 参数校验分组：查 - 详情
     */
    public @interface detail {
    }

    /**
     * 参数校验分组：操作 - 导出等行为
     */
    public @interface action {
    }

}
