package com.baizhi.controller;

import com.baizhi.clients.ProductConfigClient;
import com.baizhi.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductslsConfigController {

    @Autowired
    private ProductConfigClient productConfigClient;

    //测试get方式调用传递参数
    @GetMapping("/userConfig/test1")
    public Map<String,Object> test1(String id){
        Map<String, Object> msg = productConfigClient.findById(id);
        return msg;//http://localhost:9990/userConfig/test1?id=1111
    }

    //测试get方式调用传递参数
    @GetMapping("/userConfig/test2")
    public String test2(){
        String msg = productConfigClient.showMsg();
        return msg;//http://localhost:9990/userConfig/test2
    }
    @GetMapping("/userConfig/test3")
    public Map<String,Object> findStudent(StudentEntity po){
        Map<String,Object> msg= productConfigClient.findStudent(po);
        return  msg;//http://localhost:9990/userConfig/test3?name=111&sex=男&phone=13111111111111
    }

    /**
     * 测试服务熔断方法
     * */
    @GetMapping("/userConfig/test4")
    public String testBreak(@RequestParam Integer id){
        String msg =productConfigClient.testBreak(id);
        return msg;//http://localhost:9990/userConfig/test4?id=1
    }
}
