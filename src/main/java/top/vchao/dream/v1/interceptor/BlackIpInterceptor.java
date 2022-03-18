package top.vchao.dream.v1.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.vchao.dream.v1.exception.BlackIpException;
import top.vchao.dream.v1.util.IpUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 黑名单拦截器
 */
@Order(0)
@Aspect
@Component
public class BlackIpInterceptor {

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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //判断是否为黑名单用户
        String ip = IpUtil.getIpAddress(request);
        if (isBlackIp(ip)) {
            // 黑名单，则直接抛出异常
            throw new BlackIpException();
        } else {
            // 不是黑名单，走接口返回
            return point.proceed();
        }
    }


    /**
     * 查看 IP 是否在黑名单中
     */
    public boolean isBlackIp(String ip) {
        //  TODO 此处仅用作测试功能，后续会将黑名单 ip 维护在 redis 中
        return "192.168.1.195".equals(ip);
    }

}
