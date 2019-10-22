package com.gnnu.stu_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StuGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuGatewayApplication.class, args);
    }

}
