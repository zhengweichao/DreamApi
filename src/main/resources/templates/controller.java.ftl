package ${package.Controller};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

import top.vchao.dream.v1.pojo.request.BaseRequest;
import top.vchao.dream.v1.pojo.response.PageResponse;
import top.vchao.dream.v1.pojo.response.ResponseData;
import top.vchao.dream.v1.pojo.response.SuccessResponseData;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${package.Other}${entity}.request.${entity}Request;

import javax.annotation.Resource;

/**
 * ${table.comment!}接口
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/${version}<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Resource
    ${table.serviceName} ${table.serviceName?uncap_first};

    @GetMapping("/page")
    public SuccessResponseData<PageResponse<${entity}>> page(@Validated(BaseRequest.page.class)${entity}Request request) {
        Page<${entity}> page = ${table.serviceName?uncap_first}.page(request);
        return ResponseData.successPage(page);
    }

    @GetMapping("/detail")
    public SuccessResponseData<${entity}> detail(@Validated(BaseRequest.detail.class)${entity}Request request) {
        ${entity} bean = ${table.serviceName?uncap_first}.detail(request.getId());
        return ResponseData.success(bean);
    }

    @PostMapping("/add")
    public ResponseData add(@Validated(BaseRequest.add.class)${entity}Request request) {
        ${table.serviceName?uncap_first}.save(request);
        return ResponseData.success();
    }

    @DeleteMapping("/delete")
    public ResponseData delete(@Validated(BaseRequest.delete.class)${entity}Request request) {
        ${table.serviceName?uncap_first}.remove(request.getId());
        return ResponseData.success();
    }

    @PutMapping("/update")
    public ResponseData update(@Validated(BaseRequest.update.class)${entity}Request request) {
        ${table.serviceName?uncap_first}.update(request);
        return ResponseData.success();
    }

}
</#if>
