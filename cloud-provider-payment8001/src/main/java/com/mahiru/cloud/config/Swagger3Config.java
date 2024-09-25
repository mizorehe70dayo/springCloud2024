package com.mahiru.cloud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.ExternalDocumentation;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mahiru
 * @version v1.0.0
 * @className Swagger3Config
 * @description Swagger3配置类
 * @date 2024/09/25 21:04
 **/
@Configuration
public class Swagger3Config {
    @Bean
    public GroupedOpenApi payApi() {
        return GroupedOpenApi.builder()
                .group("支付微服务模块")
                .pathsToMatch("/pay/**")
                .build();
    }

    @Bean
    public GroupedOpenApi otherApi() {
        return GroupedOpenApi.builder()
                .group("其它微服务模块")
                .pathsToMatch("/other/**", "/others")
                .build();
    }

    @Bean
    public OpenAPI docsOpenApi() {
        return new OpenAPI()
                .info(new Info().title("cloud2024")
                        .description("通用设计rest")
                        .version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("www.mahiru.com")
                        .url("https://yiyan.baidu.com/"));
    }
}
