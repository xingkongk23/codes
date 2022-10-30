package com.baizhi.fallback;

import com.baizhi.clients.ProductConfigClient;
import com.baizhi.entity.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ProductConfigClientFallBack implements ProductConfigClient {

    @Override
    public String showMsg() {
        String msg="方法showMsg被降级";
        return msg;
    }

    @Override
    public Map<String, Object> findById(String id) {
        Map<String, Object> map=new HashMap<>();
        map.put("接收到的信息",id);
        map.put("方法","findById被降级11111");
        return map;
    }

    @Override
    public Map<String, Object> findStudent(StudentEntity po) {
        Map<String, Object> map=new HashMap<>();
        map.put("接收到的信息",po);
        map.put("方法","findStudent被降级");
        return map;
    }

    @Override
    public String testBreak(Integer id) {
        String msg="方法testBreak被降级，参数："+id;
        return msg;
    }
}
