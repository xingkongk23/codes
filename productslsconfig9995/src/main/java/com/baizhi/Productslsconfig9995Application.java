package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients   //开启openfeign支持
@EnableCircuitBreaker  //用来开启断路器
public class Productslsconfig9995Application {

    public static void main(String[] args) {
        SpringApplication.run(Productslsconfig9995Application.class, args);
    }

}
