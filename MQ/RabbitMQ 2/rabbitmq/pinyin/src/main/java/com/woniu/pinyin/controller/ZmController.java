package com.woniu.pinyin.controller;

import com.woniu.pinyin.mapper.ZuimingMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className:ZmController
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/28 12:35
 * @Version:1.0
 **/
@RestController
public class ZmController {
    @Resource
    private ZuimingMapper zuimingMapper;

    @GetMapping("/findZm")
    public List findZm(String zm){
        return zuimingMapper.findZm(zm);
    }
}
