package com.woniuxy.i_createbean;

public class UserFactory {
	public static User getUser() {
		User user = new User();
		user.setId(444);
		user.setName("����");
		return user;
	}
	
	public User getUser2() {
		User user = new User();
		user.setId(444);
		user.setName("�ܲ�");
		return user;
	}
}
