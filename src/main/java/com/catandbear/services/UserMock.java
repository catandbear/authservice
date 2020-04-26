package com.catandbear.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.catandbear.entity.User;

@Repository
public class UserMock {

	private static Map<String, User> users = new HashMap<>();
	
	static {
		users.put("root", new User("root", "123456","admin"));
		users.put("admin", new User("admin", "123456", "admin"));
		users.put("dlyhua", new User("dlyhua","yuanyuan", "user"));
		users.put("yzcaodl", new User("yzcaodl", "ibmcaoyizheng", "user"));
	}
	
	public User validateUserInfo(String uname) {
		return users.get(uname);
	}
}
