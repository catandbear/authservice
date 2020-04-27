package com.catandbear.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catandbear.entity.LoginReturn;
import com.catandbear.util.LoginUtil;
import com.catandbear.entity.User;
import com.catandbear.services.UserMock;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	UserMock userMock;
	
	@PostMapping("login")
	public LoginReturn authUnamePwd(@RequestBody(required=true) User authUser, HttpServletResponse resp, HttpServletRequest req) {
		System.out.println(authUser.toString());
		// 非正常登录
		User user = userMock.validateUserInfo(authUser.getUserName());
		if (user == null) {
			// 应该跳转到注册页
			return new LoginReturn("", 0, "");
		}else if (!user.getPassWord().equals(authUser.getPassWord())) {
			// 应重新登陆
			return new LoginReturn("", -1, "");
		}
		
		// 正常登录
		// generate token and cookie
		String token = LoginUtil.getRandomString(16);
		
		Cookie userCookie = new Cookie("UNAME", user.getUserName());
//		userCookie.setMaxAge(7 * 24 * 60 * 60);
		userCookie.setPath("/");
//		userCookie.setDomain("localhost");
		resp.addCookie(userCookie);
		
		return new LoginReturn(token, 1, user.getUserType());
	}
	
	
	
}
