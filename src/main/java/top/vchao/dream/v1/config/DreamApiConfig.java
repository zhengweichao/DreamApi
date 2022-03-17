package top.vchao.dream.v1.config;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@Getter
public class DreamApiConfig {

    @Value("${dream-api.show-hello:true}")
    private boolean showHello;

}
