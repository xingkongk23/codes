package com.baizhi.controller;

import com.baizhi.entity.StudentEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class ProductslsController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/productConfig/showMsg")
    public String showMsg(){
        String msg ="全部商品"+port;
        return  msg;
    }
    @GetMapping("/productConfig/findById")
    public Map<String,Object> findById(@RequestParam("id")String id){
        Map<String, Object> map =new HashMap<>();
        map.put("商品id",id);
        map.put("商品名称","无骨鸡爪");
        map.put("端口",port);
        return map;
    }

    @PostMapping("/productConfig/findStudent")
    public Map<String,Object> findStudent(@RequestBody StudentEntity po){
        Map<String, Object> map =new HashMap<>();
        /*map.put("姓名",po.getName());
        map.put("性别",po.getSex());
        map.put("电话",po.getPhone());*/
        map.put("接收到的信息",po);
        map.put("端口",port);
        return map;
    }

    @GetMapping("/productConfig/break")
    //@HystrixCommand(fallbackMethod = "testBreakFallBack")
    @HystrixCommand(defaultFallback = "defaultFallBack")
    public String testBreak(@RequestParam  Integer id){
        if(id<0){
            throw new RuntimeException("非法参数,id不能小于0");
        }
        return "访问成功,当前查询的id为: "+id+",端口为:"+port;
    }
    public String defaultFallBack(){
        return "当前服务不可用,触发熔断!"+port;
    }
}
