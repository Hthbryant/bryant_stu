package com.gnnu.web_stu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.gnnu")
@EnableEurekaClient
@MapperScan(basePackages = "com.gnnu.dao")
@EnableFeignClients(basePackages = "com.gnnu.feign")
public class WebStuApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebStuApplication.class, args);
    }

}
