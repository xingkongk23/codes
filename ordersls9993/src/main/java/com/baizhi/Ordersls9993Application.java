package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //开启consul 可有可无
public class Ordersls9993Application {
    public static void main(String[] args) {
        SpringApplication.run(Ordersls9993Application.class, args);
    }
}
