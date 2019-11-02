package com.gnnu.stu_sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.gnnu")
@EnableEurekaClient
@MapperScan(basePackages = "com.gnnu.dao")
public class StuSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuSsoApplication.class, args);
    }

}
