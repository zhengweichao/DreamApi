package top.vchao.dream.safe;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.junit.jupiter.api.Test;

/**
 * 数据安全保护
 * 该功能为了保护数据库配置及数据安全，在一定的程度上控制开发人员流动导致敏感信息泄露。
 */
public class DataEncryptTest {


    /**
     * 加密数据
     */
    @Test
    public void encryptData() {

        // 环境文件中待加密的数据
        String data = "123456";
        // 生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();
        // 随机密钥加密结果
        // 加密配置 mpw: 开头紧接加密内容（ 非数据库配置专用 YML 中其它配置也是可以使用的 ）
        String result = AES.encrypt(data, randomKey);

        System.out.println("随机密钥 randomKey  ===>" + randomKey);
        System.out.println("加密数据 result     ===> mpw:" + result);

        // Jar 启动参数（ idea 设置 Program arguments , 服务器可以设置为启动环境变量 ） eg:  --mpw.key=d1104d7c3b616f0b

    }
}
