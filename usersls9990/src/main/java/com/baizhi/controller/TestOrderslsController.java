package com.baizhi.controller;

import com.baizhi.clients.OrderslsClient;
import com.baizhi.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 测试服务降级
 * */
@RestController
public class TestOrderslsController {
    @Autowired
    private OrderslsClient orderslsClient;

    //测试get方式调用传递参数
    @GetMapping("/user2/test1")
    public Map<String,Object> test1(String id){
        Map<String, Object> msg = orderslsClient.findById(id);
        return msg;//http://localhost:9990/user2/test1?id=1111
    }

    //测试get方式调用传递参数
    @GetMapping("/user2/test2")
    public String test2(){
        String msg = orderslsClient.showMsg();
        return msg;//hhttp://localhost:9990/user2/test2
    }
    @GetMapping("/user2/test3")
    public Map<String,Object> findStudent(StudentEntity po){
        Map<String,Object> msg= orderslsClient.findStudent(po);
        return  msg;//http://localhost:9990/user2/test3?name=111&sex=男&phone=13111111111111
    }

    @GetMapping("/user2/test4")
    public String testBreak(@RequestParam Integer id){
        String msg =orderslsClient.testBreak(id);
        return msg;//http://localhost:9990/user2/test4?id=-1
    }
}
