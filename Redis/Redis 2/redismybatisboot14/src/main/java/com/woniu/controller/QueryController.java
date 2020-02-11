package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.entity.Car;
import com.woniu.entity.Gl;
import com.woniu.entity.Userinfo;
import com.woniu.mapper.CarMapper;
import com.woniu.mapper.GlMapper;
import com.woniu.mapper.UserinfoMapper;

@Controller
public class QueryController {
	@Resource
	private UserinfoMapper userinfoMapper;
	@Resource
	private CarMapper carMapper;
	@Resource
	private GlMapper glMapper;
	
	@RequestMapping("/find2")
	public String find2() {
		Userinfo info = userinfoMapper.selectByPrimaryKey(2);
		System.out.println(info.getUname()+" "+info.getCars().get(0).getCname());
		return null;
	}
	
	@RequestMapping("/findgl")
	public String findgl() {
		List<Gl> list = glMapper.selectByExample(null);
		for (Gl gl : list) {
			System.out.println(gl);
		}
		return null;
	}
	
	@RequestMapping("/updatecar")
	public String updatecar() {
		Car car = carMapper.selectByPrimaryKey(1);
		car.setCname("老年代步车");
		carMapper.updateByPrimaryKey(car);
		return null;
	}
}
