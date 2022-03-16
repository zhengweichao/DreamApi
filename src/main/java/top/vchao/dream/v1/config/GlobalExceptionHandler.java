package top.vchao.dream.v1.config;

import cn.hutool.core.util.StrUtil;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.vchao.dream.v1.pojo.response.ErrorResponseData;
import top.vchao.dream.v1.pojo.response.ResponseEnum;

import java.util.List;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 请求参数缺失异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ErrorResponseData missParamException(MissingServletRequestParameterException e) {
        String parameterType = e.getParameterType();
        String parameterName = e.getParameterName();
        String message = StrUtil.format(">>> 缺少请求的参数{}，类型为{}", parameterName, parameterType);
        return new ErrorResponseData(ResponseEnum.ERROR_PARAM.getCode(), message);
    }

    /**
     * 拦截参数校验错误异常,JSON传参
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseData methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String argNotValidMessage = getArgNotValidMessage(e.getBindingResult());
        return new ErrorResponseData(ResponseEnum.ERROR_PARAM.getCode(), argNotValidMessage);
    }

    @ExceptionHandler(BindException.class)
    public ErrorResponseData mBindException(BindException e) {
        String argNotValidMessage = getArgNotValidMessage(e.getBindingResult());
        return new ErrorResponseData(ResponseEnum.ERROR_PARAM.getCode(), argNotValidMessage);
    }

    /**
     * 获取请求参数不正确的提示信息
     * <p>
     * 多个信息，拼接成用逗号分隔的形式
     */
    private String getArgNotValidMessage(BindingResult bindingResult) {
        if (bindingResult == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();

        //多个错误用逗号分隔
        List<ObjectError> allErrorInfos = bindingResult.getAllErrors();
        for (ObjectError error : allErrorInfos) {
            stringBuilder.append(",").append(error.getDefaultMessage());
        }
        //最终把首部的逗号去掉
        return StrUtil.removePrefix(stringBuilder.toString(), ",");
    }

    /**
     * 拦截数据库连接错误
     */
    @ExceptionHandler(CannotGetJdbcConnectionException.class)
    public ErrorResponseData cannotGetJdbcConnectionException(CannotGetJdbcConnectionException e) {
        return new ErrorResponseData(ResponseEnum.ERROR.getCode(), e.getLocalizedMessage());
    }

}