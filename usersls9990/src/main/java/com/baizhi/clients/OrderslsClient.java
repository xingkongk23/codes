package com.baizhi.clients;


import com.baizhi.entity.StudentEntity;
import com.baizhi.fallback.OrderslsClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//测试openFeign服务调度
@FeignClient(value ="ordersls",fallback = OrderslsClientFallBack.class)
public interface OrderslsClient {

    //展示商品信息
    @GetMapping("/ordersls/showMsg")
    String showMsg();

    //测试openFeign传递参数
    @GetMapping("/ordersls/findById")
    Map<String,Object> findById(@RequestParam("id")String id);

    //测试openFeign传递对象
    @GetMapping("/ordersls/findStudent")
     Map<String,Object> findStudent(@RequestBody StudentEntity po);

    //测试服务熔断
    @GetMapping("/ordersls/break")
    public String testBreak(@RequestParam Integer id);
}
