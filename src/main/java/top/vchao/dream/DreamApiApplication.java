package top.vchao.dream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class DreamApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DreamApiApplication.class, args);
    }

}
