package com.woniu.feignclient.controller;

import com.woniu.feignclient.service.UserinfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className:UserinfoController
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/22 11:26
 * @Version:1.0
 **/
@RestController
public class UserinfoController {
    @Resource
    private UserinfoService userinfoService;
    @GetMapping("/findAll")
    public List findAll(){
        return userinfoService.findAll();
    }
}
