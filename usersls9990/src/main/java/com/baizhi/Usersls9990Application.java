package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient//开启consul
@EnableFeignClients//开启openFeign
@EnableCircuitBreaker  //用来开启断路器
public class Usersls9990Application {

    public static void main(String[] args) {
        SpringApplication.run(Usersls9990Application.class, args);
    }

}
