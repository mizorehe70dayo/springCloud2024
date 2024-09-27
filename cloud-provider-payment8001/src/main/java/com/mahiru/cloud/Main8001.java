package com.mahiru.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author mahiru
 * @version v1.0.0
 * @className Main8001
 * @description 端口8001启动类
 * @date 2024/09/25 18:15
 **/
@SpringBootApplication
@MapperScan("com.mahiru.cloud.mapper")
@EnableDiscoveryClient
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}
