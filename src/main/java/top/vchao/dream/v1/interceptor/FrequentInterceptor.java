package top.vchao.dream.v1.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.vchao.dream.v1.data.FrequentIpData;
import top.vchao.dream.v1.exception.BlackIpException;
import top.vchao.dream.v1.exception.FrequentException;
import top.vchao.dream.v1.util.IpUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * IP频繁访问策略拦截器
 * (后续可优化为redis实现，此处仅为简单实现)
 */
@Order(1)
@Aspect
@Component
@Slf4j
public class FrequentInterceptor {

    @Resource
    FrequentIpData frequentIpData;

    /**
     * 定义拦截器规则
     */
    @Pointcut("execution(* top.vchao.dream..*Controller.*(..))")
    public void pointCut() {
    }

    /**
     * 拦截器具体实现
     */
    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 更新IP列表
        frequentIpData.updateFilterList();

        // 未设置IP访问策略 -> 则不做处理
        // 获取用户IP
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String ip = IpUtil.getIpAddress(request);

        // 判断是否是已经被限制的IP
        // 被限制 ---> 抛出异常
        if (frequentIpData.isLimitedIP(ip)) {
            throw new FrequentException();
        }

        // 增加访问记录
        frequentIpData.addAccessLog(ip);

        // 判断是否 访问频繁
        // 频繁 ---> 抛出异常
        if (frequentIpData.isFrequent(ip)) {
            throw new BlackIpException();
        }

        return point.proceed();
    }

}
