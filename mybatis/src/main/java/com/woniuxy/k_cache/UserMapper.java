package com.woniuxy.k_cache;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
	
	User find(Integer id);
	User find2(Integer id);
	User find3(UserExample ue);
	
	List<User> find4(RowBounds rb);
	
	void update(User user);
}
