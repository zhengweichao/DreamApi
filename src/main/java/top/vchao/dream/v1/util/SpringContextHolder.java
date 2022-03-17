package top.vchao.dream.v1.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringContextHolder implements ApplicationContextAware {

    /**
     * 以静态变量保存 ApplicationContext,可在任意代码中取出 ApplicationContext.
     */
    private static ApplicationContext context;

    /**
     * 实现 ApplicationContextAware 接口的 context 注入函数, 将其存入静态变量.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.context = applicationContext;
    }

    /**
     * 获取 applicationContext
     */
    public ApplicationContext getApplicationContext() {
        return context;
    }

    /**
     * 通过 name获取 Bean.
     */
    public static Object getBean(String name) {
        return context.getBean(name);
    }

    /**
     * 通过 class获取 Bean.
     */
    public static <T> Map<String, T> getBeans(Class<T> clazz) {
        return context.getBeansOfType(clazz);
    }

    /**
     * 通过 class 获取 Bean.
     */
    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    /**
     * 通过 name,以及 Clazz 返回指定的 Bean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }
}
