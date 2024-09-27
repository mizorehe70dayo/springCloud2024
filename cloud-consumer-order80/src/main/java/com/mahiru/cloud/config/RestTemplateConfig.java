package com.mahiru.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author mahiru
 * @version v1.0.0
 * @className RestTemplateConfig
 * @description RestTemplateConfig配置类
 * @date 2024/09/26 15:49
 **/
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

