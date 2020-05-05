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
import com.catandbear.data.UserInfoDB;
import com.catandbear.data.mapper.UserInfoMapper;
import com.catandbear.jwt.token.TokenTool;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	UserInfoMapper userMapper;

	@PostMapping("login")
	public LoginReturn authUnamePwd(@RequestBody(required = true) UserInfo authUser, HttpServletResponse resp,
			HttpServletRequest req) {
		// Parameter verification
		if (authUser == null) {
			// 0 -> user not found
			return new LoginReturn("", "", 0, "");
		}

		System.out.println("input user info: " + authUser.toString());
		
		UserInfoDB authUserDb = userMapper.selectUserByName(authUser);

		if (!authUserDb.getPassword().equals(authUser.getPassWord())) {
			// -1 -> user password incorrect
			return new LoginReturn("", "", -1, "");
		} else {

			// generate token
			String token = TokenTool.getToken(authUserDb);
			System.out.println("output user info: " + authUserDb.toString());
			System.out.println("token " + token);
			return new LoginReturn(token, authUserDb.getUser_name(), 1, authUserDb.getUser_type());
		}

	}

}
