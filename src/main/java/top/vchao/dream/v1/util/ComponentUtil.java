package top.vchao.dream.v1.util;

import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 组件工具类
 */
public class ComponentUtil {

    /**
     * 反注册 Controller
     *
     * @param controllerBeanName controller实例名称  eg. helloController
     */
    public static void unregisterController(String controllerBeanName) {
        RequestMappingHandlerMapping requestMappingHandlerMapping =
                SpringContextHolder.getBean(RequestMappingHandlerMapping.class);
        Object controller = SpringContextHolder.getBean(controllerBeanName);

        final Class<?> targetClass = controller.getClass();
        ReflectionUtils.doWithMethods(targetClass, method -> {
            Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
            try {
                Method createMappingMethod = RequestMappingHandlerMapping.class.
                        getDeclaredMethod("getMappingForMethod", Method.class, Class.class);
                createMappingMethod.setAccessible(true);
                RequestMappingInfo requestMappingInfo =
                        (RequestMappingInfo) createMappingMethod.invoke(requestMappingHandlerMapping, specificMethod, targetClass);
                if (requestMappingInfo != null) {
                    requestMappingHandlerMapping.unregisterMapping(requestMappingInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, ReflectionUtils.USER_DECLARED_METHODS);
    }

}
