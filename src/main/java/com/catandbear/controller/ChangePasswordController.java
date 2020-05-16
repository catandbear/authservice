package com.catandbear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catandbear.data.entity.ReturnedEntity;
import com.catandbear.data.entity.UserInfoDB;
import com.catandbear.data.entity.changepw.InputEntity;
import com.catandbear.data.mapper.UserInfoMapper;

@RestController
@CrossOrigin("*")
public class ChangePasswordController {

	private UserInfoMapper userMapper;
	
	@Autowired
	private ChangePasswordController(UserInfoMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@PostMapping("/changepwd")
	private ReturnedEntity changeit(@RequestBody(required = true) InputEntity entity) {
		System.out.println(entity.toString());
		UserInfoDB userInfo = userMapper.selectUserByName(entity.getUsername());
		// no user found
		if (userInfo==null) {
			return new ReturnedEntity("failed"); 
		}
		
		// user password incorrect or user is inactive
		System.out.println(userInfo.toString());
		if (!entity.getOldpassword().equals(userInfo.getPassword())||!userInfo.getConfirmed().equals("Y")) {
			return new ReturnedEntity("failed");
		}
		
		// jump to logic
		userInfo.setPassword(entity.getPasswordsgroup().getPassword());
		userMapper.updatePassword(userInfo);
		
		return new ReturnedEntity("ok");
	}
	
}
