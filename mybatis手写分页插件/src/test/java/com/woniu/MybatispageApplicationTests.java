package com.woniu;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.woniu.entity.Userinfo;
import com.woniu.mapper.UserinfoMapper;

@SpringBootTest
class MybatispageApplicationTests {
	@Resource
	private UserinfoMapper userinfoMapper;
	@Test
	void contextLoads() {
	}
	
	@Test
	public void test1() {
		List<Userinfo> list = userinfoMapper.selectByExample(null, new RowBounds(5, 5));
		for (Userinfo userinfo : list) {
			System.out.println(userinfo);
		}
//		userinfoMapper.selectByPrimaryKey(55);
	}
}
