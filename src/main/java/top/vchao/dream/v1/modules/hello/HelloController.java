package top.vchao.dream.v1.modules.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vchao.dream.v1.modules.hello.entity.HelloMysqlInfo;
import top.vchao.dream.v1.pojo.response.ErrorResponseData;
import top.vchao.dream.v1.pojo.response.ResponseData;
import top.vchao.dream.v1.pojo.response.ResponseEnum;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.DatabaseMetaData;

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

    @Resource
    DataSource dataSource;

    /**
     * 验证是否可以访问 MySQL
     */
    @GetMapping("/hello/mysql")
    public ResponseData helloMysql() {
        try {
            DatabaseMetaData metaData = dataSource.getConnection().getMetaData();

            HelloMysqlInfo helloMysqlInfo = new HelloMysqlInfo();
            helloMysqlInfo.setUserName(metaData.getUserName());
            helloMysqlInfo.setUrl(metaData.getURL().split("\\?")[0]);
            helloMysqlInfo.setProductName(metaData.getDatabaseProductName());
            helloMysqlInfo.setProductVersion(metaData.getDatabaseProductVersion());

            return ResponseData.success("数据库连接成功!", helloMysqlInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponseData(ResponseEnum.ERROR.getCode(), "数据库连接失败，请检查项目配置!");
        }
    }

}
