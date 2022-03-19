package top.vchao.dream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import top.vchao.dream.v1.config.DreamApiConfig;
import top.vchao.dream.v1.util.ComponentUtil;

import javax.annotation.Resource;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

    @Resource
    DreamApiConfig dreamApiConfig;

    @Override
    public void run(ApplicationArguments args) {
        // 项目启动成功后执行
        System.out.println("==================================================================");
        System.out.println("       Dream Api  start successful ! ");
        System.out.println("       验证接口：http://localhost:8080/v1/hello");
        System.out.println("       接口文档：http://localhost:8080/swagger-ui/index.html");

        // 如果设置了白名单访问策略，则输出白名单信息
        if (dreamApiConfig.isWhiteStrategy()) {
            System.out.println("       访问策略：白名单 - " + dreamApiConfig.getWhiteList().toString());
        } else if (dreamApiConfig.isBlackStrategy()) {
            System.out.println("       访问策略：黑名单");
        } else {
            System.out.println("       访问策略：未设置");
        }

        System.out.println("==================================================================");

        // 如果设置不显示 hello 接口，则进行关闭
        if (!dreamApiConfig.isShowHello()) {
            ComponentUtil.unregisterController("helloController");
        }
    }

}