package ${package.Other}${entity}.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import top.vchao.dream.v1.pojo.request.PageRequest;

/**
 * ${table.comment!}请求体
 */
@Getter
@Setter
public class ${entity}Request extends PageRequest implements Serializable {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>
    <#if field.propertyName?contains("createTime") || field.propertyName?contains("updateTime") >
    <#-- 忽略字段 -->
    <#elseif field.logicDeleteField>
    <#-- 逻辑删除字段 -->
    <#else>
    <#-- 普通字段 -->
        <#if field.comment!?length gt 0>
    /**
     * ${field.comment}
     */
        </#if>
        <#if field.keyFlag>
        <#-- 主键 -->
    @NotNull(message = "请输入id", groups = {delete.class, update.class, detail.class})
    @Min(value = 1, message = "请输入合法id", groups = {delete.class, update.class, detail.class})
    private ${field.propertyType} ${field.propertyName};
        <#else>
        <#-- 普通字段 -->
            <#if field.propertyType == "String">
    @NotBlank(message = "请输入${field.comment}", groups = {add.class})
            <#else>
    @NotNull(message = "请输入${field.comment}", groups = {add.class})
            </#if>
    private ${field.propertyType} ${field.propertyName};
        </#if>

    </#if>
</#list>
<#------------  END 字段循环遍历  ---------->
}