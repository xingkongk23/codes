package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //开启consul 可有可无
@EnableCircuitBreaker  //用来开启断路器
public class Productsls9991Application {

    public static void main(String[] args) {
        SpringApplication.run(Productsls9991Application.class, args);
    }

}
