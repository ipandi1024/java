package com.woniu.rediscache.controller;

import com.woniu.rediscache.entity.Car;
import com.woniu.rediscache.entity.Person;
import com.woniu.rediscache.mapper.CarMapper;
import com.woniu.rediscache.mapper.PersonMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className:PersonController
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/15 9:56
 * @Version:1.0
 **/
@RestController
public class PersonController {
    @Resource
    private PersonMapper personMapper;
    @Resource
    private CarMapper carMapper;

    @GetMapping("/findAll")
    public String findAll(){
        List<Person> list = personMapper.selectByExample(null);
        for (Person p:list) {
            System.out.println(p);
        }
        return "ok";
    }

    @GetMapping("/updateCar")
    public String updateCar(){
        Car car = carMapper.selectByPrimaryKey(1);
        car.setCname("马车");
        carMapper.updateByPrimaryKey(car);
        return "ok";
    }
}
