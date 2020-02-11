package com.woniuxy.c_dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

/*
 使用Mybatis自动生成dao层， 有以下几个必须：
 1. 必须创建一个接口，该接口的名字必须与子配置文件UserMapper.xml同名（但是没有xml）
 2. 以前我们说UserMapper.xml子配置文件中的mapper元素的namespace是可以随便写的，
  	但是建议叫做UserMapper的包路径
 	现在，namespace就必须写成UserMapper的包路径了！ 也就是当前接口的包路径。
 3. 该接口中的方法名，必须与UserMapper.xml子配置文件中的语句的id相同
	该接口中的方法的参数，必须与UserMapper.xml子配置文件中的语句的parameterType相同
  	该接口中的方法的返回值，必须与UserMapper.xml子配置文件中的语句的resultType相匹配（不是相同）
  4. 该接口中的任何方法，禁止使用方法重载！！ 你懂得！！
*/

public interface UserMapper {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	List<User> findAll();
	User findOne(Integer id);
}
