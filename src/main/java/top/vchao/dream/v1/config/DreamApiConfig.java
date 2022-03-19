package top.vchao.dream.v1.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Configuration
@Data
@ConfigurationProperties(prefix = "dream-api")
public class DreamApiConfig {

    @Value("${show-hello:true}")
    private boolean showHello;

    @Value("${access-strategy:none}")
    private String accessStrategy;

    @Value("${white-list:null}")
    private List<String> whiteList;

    public boolean isBlackStrategy() {
        return "black".equals(accessStrategy);
    }

    public boolean isWhiteStrategy() {
        return "white".equals(accessStrategy);
    }

    public boolean isNoneStrategy() {
        return !isBlackStrategy() && !isWhiteStrategy();
    }

    /**
     * 查看 IP 是否在白名单中
     */
    public boolean isWhiteIp(String ip) {
        if (whiteList.size() == 0) {
            return false;
        }
        return whiteList.contains(ip);
    }
}
