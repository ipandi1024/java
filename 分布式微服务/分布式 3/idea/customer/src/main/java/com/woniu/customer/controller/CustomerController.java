package com.woniu.customer.controller;

import com.woniu.customer.entity.Userinfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className:CustomerController
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/20 11:02
 * @Version:1.0
 **/
@RestController
public class CustomerController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${user.userSericeURL}")
    private String userSericeURL;

    @GetMapping("/customer/findAll")
    public List findAll(){
        ResponseEntity entity = restTemplate.getForEntity(userSericeURL+"findAll", List.class);
        //get For Entity返回的数据是大于你getForoObject的
        //getForObject仅仅只返回要你的数据
        //getForEntity的body是你的数据
        //还包含了你当前整个请求状态，请求的数据的类型 和时间 和你的请求头和status code等等信息
        System.out.println(entity);
        return (List)entity.getBody();
    }
    @GetMapping("findById/{uid}")
    public Userinfo findById(@PathVariable Integer uid){
        return restTemplate.getForObject(userSericeURL+"findById?uid="+uid,Userinfo.class);
    }

    @GetMapping("findById1/{uid}")
    public Userinfo findById1(@PathVariable Integer uid){
        return restTemplate.getForObject(userSericeURL+"findById?uid={uid}", Userinfo.class,uid);
    }

    @GetMapping("findById2/{uid}")
    public Userinfo findById2(@PathVariable Integer uid){
        Map map = new HashMap();
        map.put(uid, uid);
        return restTemplate.getForObject(userSericeURL+"findById?uid={uid}", Userinfo.class,map);
    }
}
