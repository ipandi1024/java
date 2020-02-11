package com.woniu.feignclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient("http://PROVIDER/") //这个值就是你提供者的实例名称
public interface UserinfoService {
    @GetMapping("findAll")
    public List findAll();
}
