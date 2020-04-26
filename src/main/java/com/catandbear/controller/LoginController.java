package com.catandbear.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catandbear.entity.LoginReturn;
import com.catandbear.util.LoginUtil;
import com.catandbear.entity.User;
import com.catandbear.services.UserMock;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	UserMock userMock;
	
	@GetMapping("login")
	public LoginReturn authUnamePwdGet(@RequestBody(required = false) User authUser, HttpServletResponse resp) {
		return this.authUnamePwd(authUser, resp);
	}

	@PostMapping("login")
	public LoginReturn authUnamePwd(@RequestBody(required = false) User authUser, HttpServletResponse resp) {

		if (authUser == null) {
			return new LoginReturn();
		}
		
		User user = userMock.validateUserInfo(authUser.userName);
		
		System.out.println(user.toString());
		System.out.println("input json: " + authUser.toString());

		Cookie userCookie = new Cookie("ULOGIN", "admin");
		userCookie.setMaxAge(7 * 24 * 60 * 60);
		userCookie.setPath("/");
		resp.addCookie(userCookie);
		
		String token = LoginUtil.getRandomString(16);
		System.out.println("token : " + token);
		
		boolean isAuth = true;
		String uType = "admin";
		
		return new LoginReturn(token,isAuth, uType);
	}
	
	
	
}
