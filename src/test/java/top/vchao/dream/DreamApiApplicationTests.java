package top.vchao.dream;

import com.github.jaemon.dinger.DingerSender;
import com.github.jaemon.dinger.core.entity.DingerRequest;
import com.github.jaemon.dinger.core.entity.enums.MessageSubType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DreamApiApplicationTests {


    @Resource
    private DingerSender dingerSender;
    @Test
    void contextLoads() {
        // 发送text类型消息
        dingerSender.send(
                MessageSubType.TEXT,
                DingerRequest.request("Hello World, Hello Dinger")
        );

    }

}
