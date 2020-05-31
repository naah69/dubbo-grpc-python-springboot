package com.naah69;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DubboGrpcProviderApplication
 *
 * @author naah
 * @date 2020-05-31 6:23 下午
 * @desc
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.naah69.service.impl")
public class DubboGrpcProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboGrpcProviderApplication.class, args);
    }
}
