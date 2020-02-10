package com.woniuxy.q_mix3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class AppTest {
	
	@Resource
	private User u;
	
	@Resource
	private User u2;
	
	@Test
	public void test() throws Exception {
		System.out.println(u);
		System.out.println(u2);
	}
}
