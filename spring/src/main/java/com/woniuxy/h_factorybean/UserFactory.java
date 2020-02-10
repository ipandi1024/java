package com.woniuxy.h_factorybean;

import org.springframework.beans.factory.FactoryBean;

@SuppressWarnings("rawtypes")
public class UserFactory implements FactoryBean {

	@Override
	public Object getObject() throws Exception {
		User user = new User();
		user.setId(222);
		user.setName("Œ∫÷“œÕ");
		return user;
	}
	
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
}
