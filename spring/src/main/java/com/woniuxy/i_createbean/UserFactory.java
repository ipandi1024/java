package com.woniuxy.i_createbean;

public class UserFactory {
	public static User getUser() {
		User user = new User();
		user.setId(444);
		user.setName("ÑÏáÔ");
		return user;
	}
	
	public User getUser2() {
		User user = new User();
		user.setId(444);
		user.setName("²Ü²Ù");
		return user;
	}
}
