package com.woniuxy.s_aop2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class AppTest {

	@Resource
	private ICalc c;
	
	@Resource
	private ICalc c2;
	
	@Test
	public void test() throws Exception {
		c.add(11, 22);
		c.sub(22, 33);
//		System.out.println("====================================");
//		c2.add(1, 2);
	}
	
}
