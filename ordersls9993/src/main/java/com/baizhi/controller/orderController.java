package com.baizhi.controller;

import com.baizhi.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class orderController {


    @Value("${server.port}")
    private String port;

    @GetMapping("/ordersls/showMsg")
    public String showMsg(){
        String msg ="全部商品"+port;
        return  msg;
    }
    @GetMapping("/ordersls/findById")
    public Map<String,Object> findById(@RequestParam("id") String id){
        Map<String, Object> map =new HashMap<>();
        map.put("商品id",id);
        map.put("商品名称","无骨鸡爪");
        map.put("端口",port);
        return map;
    }

    @PostMapping("/ordersls/findStudent")
    public Map<String,Object> findStudent(@RequestBody StudentEntity po){
        Map<String, Object> map =new HashMap<>();
        map.put("接收到的信息",po);
        map.put("端口",port);
        return map;
    }

    @GetMapping("/ordersls/break")
    public String testBreak(@RequestParam Integer id){
        if(id<0){
            throw new RuntimeException("非法参数,id不能小于0");
        }
        return "访问成功,当前查询的id为: "+id+",端口为:"+port;
    }
}
