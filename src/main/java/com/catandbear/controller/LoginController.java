package com.catandbear.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catandbear.data.LoginReturn;
import com.catandbear.data.UserInfo;
import com.catandbear.data.mapper.UserInfoMapper;
import com.catandbear.jwt.token.TokenTool;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	UserInfoMapper userMapper;
	
	@PostMapping("login")
	public LoginReturn authUnamePwd(@RequestBody(required=true) UserInfo authUser, HttpServletResponse resp, HttpServletRequest req) {
		System.out.println("hello");
		//  Parameter verification
		UserInfo user = userMapper.selectUserByName(authUser.getUserName());
		
		if (user == null) {
			// 0 -> user not found 
			return new LoginReturn("", "", 0, "");
		}else if (!user.getPassWord().equals(authUser.getPassWord())) {
			// -1 -> user password incorrect
			return new LoginReturn("", "", -1, "");
		}
		
		// generate token and cookie
		String token = TokenTool.getToken(user);
		System.out.println("user " + user.toString());
		System.out.println("token " + token);
		return new LoginReturn(token, user.getUserName(), 1, user.getUserType());
	}
	
	
	
}
