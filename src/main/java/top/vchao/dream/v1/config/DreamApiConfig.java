package top.vchao.dream.v1.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration
@Data
@ConfigurationProperties(prefix = "dream-api")
public class DreamApiConfig {

    @Value("${show-hello:true}")
    private boolean showHello;

    @Value("${access-strategy:none}")
    private String accessStrategy;

    public boolean isBlackStrategy() {
        return "black".equals(accessStrategy);
    }

    public boolean isWhiteStrategy() {
        return "white".equals(accessStrategy);
    }

    public boolean isNoneStrategy() {
        return !isBlackStrategy() && !isWhiteStrategy();
    }
}
