package top.vchao.dream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        // 项目启动成功后执行
        System.out.println("==================================================================");
        System.out.println("       Dream Api  start successful ! ");
        System.out.println("       验证接口：http://localhost:8080/v1/hello");
        System.out.println("       接口文档：http://localhost:8080/swagger-ui/index.html");
        System.out.println("==================================================================");
    }

}