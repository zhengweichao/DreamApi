package top.vchao.dream.v1.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.vchao.dream.v1.config.DreamApiConfig;
import top.vchao.dream.v1.exception.BlackIpException;
import top.vchao.dream.v1.exception.NoWhiteIpException;
import top.vchao.dream.v1.util.IpUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * IP访问策略拦截器 （黑/白名单）
 */
@Order(0)
@Aspect
@Component
public class AccessStrategyInterceptor {

    @Resource
    DreamApiConfig dreamApiConfig;

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
        // 未设置IP访问策略 -> 则不做处理
        if (dreamApiConfig.isNoneStrategy()) {
            return point.proceed();
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = IpUtil.getIpAddress(request);

        // 黑名单策略 -> 禁止黑名单访问
        if (dreamApiConfig.isBlackStrategy()) {
            if (isBlackIp(ip)) {
                // 黑名单，则直接抛出异常
                throw new BlackIpException();
            }
        } else {
            // 白名单策略 -> 仅限白名单访问
            if (!isWhiteIp(ip)) {
                // 不在白名单，则直接抛出异常
                throw new NoWhiteIpException();
            }
        }
        return point.proceed();
    }


    /**
     * 查看 IP 是否在黑名单中
     */
    public boolean isBlackIp(String ip) {
        //  TODO 此处仅用作测试功能，后续会将黑名单 ip 维护在 redis 中
        return "192.168.1.195".equals(ip);
    }

    /**
     * 查看 IP 是否在白名单中
     */
    public boolean isWhiteIp(String ip) {
        //  TODO 此处仅用作测试功能
        return "127.0.0.1".equals(ip);
    }

}
