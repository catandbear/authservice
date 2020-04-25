package com.catandbear.controller;

import javax.servlet.http.Cookie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catandbear.vo.AuthUser;

@RestController
public class LoginController {

	@GetMapping("login")
	public String authUnamePwd(@RequestBody(required=false) AuthUser authUser) {
		System.out.println("input json: " + authUser.toString());
		
		Cookie cookie = new Cookie("ULOGIN", "");
		
		return "ok";
	}
}
