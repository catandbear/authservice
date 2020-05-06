package com.catandbear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catandbear.data.entity.SignupEntity;
import com.catandbear.data.entity.UserInfoDB;
import com.catandbear.data.mapper.UserInfoMapper;

@RestController
public class SignupController {

	@Autowired
	UserInfoMapper userInfoMapper;
	
	@PostMapping("signup")
	public String signUp(@RequestBody(required = true) SignupEntity signupEntity) {
		System.out.println(signupEntity.toString());
		
		UserInfoDB userInfoDB = formatUserInfo(signupEntity);
		userInfoMapper.addUser(userInfoDB);
		
		
		
		return "ok";
	}
	
	private UserInfoDB formatUserInfo(SignupEntity signupEntity) {
		return new UserInfoDB(0, signupEntity.getUsername(), signupEntity.getPasswordsGroup().getPassword(), signupEntity.getUsertype(), signupEntity.getEmail(), signupEntity.getMobile(), "N");
	}
}
