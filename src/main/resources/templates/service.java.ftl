package ${package.Service};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import ${package.Other}${entity}.request.${entity}Request;

/**
 * ${table.comment!} 服务类
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    Page<${entity}> page(${entity}Request request);

    ${entity} detail(Integer id);

    void save(${entity}Request request);

    void remove(Integer id);

    void update(${entity}Request request);

}
</#if>
