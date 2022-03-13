package top.vchao.dream.v1.modules.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vchao.dream.v1.pojo.response.ResponseData;

/**
 * 验证模块
 */
@RestController
@RequestMapping(path = "/v1")
public class HelloController {

    /**
     * 验证是否可以访问
     */
    @GetMapping("/hello")
    public ResponseData hello() {
        return ResponseData.success("v1 版本接口访问成功");
    }

}
