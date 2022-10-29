package com.baizhi.controller;

import com.baizhi.clients.ProductClient;
import com.baizhi.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class UserslsController {

    @Autowired
    private ProductClient productClient;

    //测试get方式调用传递参数
    @GetMapping("/user/test1")
    public Map<String,Object> test1(String id){
        Map<String, Object> msg = productClient.findById(id);
        return msg;//http://localhost:9990/user/test1?id=1111
    }

    //测试get方式调用传递参数
    @GetMapping("/user/test2")
    public String test2(){
        String msg = productClient.showMsg();
        return msg;//http://localhost:9990/user/test2
    }
    @GetMapping("/user/test3")
    public Map<String,Object> findStudent(StudentEntity po){
        Map<String,Object> msg= productClient.findStudent(po);
        return  msg;//http://localhost:9990/user/test3?name=111&sex=男&phone=13111111111111
    }

    /**
     * 测试服务熔断方法
     * */
    @GetMapping("/user/test4")
    public String testBreak(@RequestParam Integer id){
        String msg =productClient.testBreak(id);
        return msg;//http://localhost:9990/user/test4?id=1
    }
}
