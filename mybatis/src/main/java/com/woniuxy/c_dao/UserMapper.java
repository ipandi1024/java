package com.woniuxy.c_dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

/*
 ʹ��Mybatis�Զ�����dao�㣬 �����¼������룺
 1. ���봴��һ���ӿڣ��ýӿڵ����ֱ������������ļ�UserMapper.xmlͬ��������û��xml��
 2. ��ǰ����˵UserMapper.xml�������ļ��е�mapperԪ�ص�namespace�ǿ������д�ģ�
  	���ǽ������UserMapper�İ�·��
 	���ڣ�namespace�ͱ���д��UserMapper�İ�·���ˣ� Ҳ���ǵ�ǰ�ӿڵİ�·����
 3. �ýӿ��еķ�������������UserMapper.xml�������ļ��е�����id��ͬ
	�ýӿ��еķ����Ĳ�����������UserMapper.xml�������ļ��е�����parameterType��ͬ
  	�ýӿ��еķ����ķ���ֵ��������UserMapper.xml�������ļ��е�����resultType��ƥ�䣨������ͬ��
  4. �ýӿ��е��κη�������ֹʹ�÷������أ��� �㶮�ã���
*/

public interface UserMapper {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	List<User> findAll();
	User findOne(Integer id);
}
