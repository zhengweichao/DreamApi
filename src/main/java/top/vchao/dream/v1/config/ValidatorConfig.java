package top.vchao.dream.v1.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * hibernate 的校验模式
 */
@Configuration
public class ValidatorConfig {
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast", "true")  // 快速失败返回模式
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}