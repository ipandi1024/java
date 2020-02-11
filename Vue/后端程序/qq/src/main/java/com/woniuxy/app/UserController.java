package com.woniuxy.app;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.domain.User;
import com.woniuxy.util.DBUtils;

@RestController
@RequestMapping("users")
public class UserController {
	@GetMapping
	public List<User> findAll() {
		return DBUtils.list;
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		System.out.println("UserController.delete():" + id);
		
		List<User> list = DBUtils.list;
		
		// 在for-each循环的过程中，不能为正在迭代的集合做修改操作，否则会抛出：ConcurrentModificationException
		User delUser = null;
		for (User user : list) {
			if(id.equals(user.getId())) {
				delUser = user;
				break;
			}
		}
		list.remove(delUser);
	}
	
	@PostMapping
	public void save(@RequestBody User user) {
		user.setId(DBUtils.seed++);
		DBUtils.list.add(user);
	}
	
	
	@PutMapping
	public void update(@RequestBody User user) {
		List<User> list = DBUtils.list;
		for (User u : list) {
			if(user.getId().equals(u.getId())) {
				u.setName(user.getName());
				u.setBirthday(user.getBirthday());
				u.setMoney(user.getMoney());
				break;
			}
		}
	}
}
