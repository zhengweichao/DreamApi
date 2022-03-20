package top.vchao.dream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@EnableScheduling
public class DreamApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DreamApiApplication.class, args);
    }

}
