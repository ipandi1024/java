package com.woniu.provider.controller;

import com.woniu.provider.entity.Userinfo;
import com.woniu.provider.service.UserinfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className:UserinfoController
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/20 10:11
 * @Version:1.0
 **/
@RestController
public class UserinfoController {
    @Resource
    private UserinfoService userinfoService;
    private int count;

    @GetMapping("/findAll")
    public List findAll(){
        count++;
        System.out.println("俺提供者被访问了"+count+"次");
        return userinfoService.findAll();
    }
    @GetMapping("/findById")
    public Userinfo findById(Integer uid){
        return userinfoService.findById(uid);
    }
}
