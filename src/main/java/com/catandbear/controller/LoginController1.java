package com.catandbear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController1 {

	@GetMapping("login")
	public String query() {
		return "login";
	}
}
