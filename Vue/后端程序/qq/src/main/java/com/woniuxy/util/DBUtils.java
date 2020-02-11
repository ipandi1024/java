package com.woniuxy.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.woniuxy.domain.User;

public class DBUtils {

	public static int seed = 4;
	
	public static List<User> list = new ArrayList<>();
	
	static {
		list.add(new User(1, "张珊珊", new Date(), 1000d));
		list.add(new User(2, "张珊珊", new Date(), 1000d));
		list.add(new User(3, "张珊珊", new Date(), 1000d));
	}
	
	
}
