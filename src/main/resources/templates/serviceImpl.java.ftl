package ${package.ServiceImpl};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.hutool.core.bean.BeanUtil;

import ${package.Other}${entity}.request.${entity}Request;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
 * ${table.comment!} 服务实现类
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public Page<${entity}> page(${entity}Request request) {
        Page<${entity}> pageInfo = new Page<>(request.getPage(), request.getSize());
        return this.page(pageInfo);
    }

    @Override
    public ${entity} detail(Integer id) {
        return this.getById(id);
    }

    @Override
    public void save(${entity}Request request) {
        ${entity} bean = new ${entity}();
        BeanUtil.copyProperties(request, bean);
        this.save(bean);
    }

    @Override
    public void remove(Integer id) {
        this.removeById(id);
    }

    @Override
    public void update(${entity}Request request) {
        ${entity} bean = new ${entity}();
        BeanUtil.copyProperties(request, bean);
        this.updateById(bean);
    }

}
</#if>
