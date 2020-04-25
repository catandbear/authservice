package com.catandbear.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catandbear.vo.AuthReturn;
import com.catandbear.vo.AuthUser;

@RestController
@CrossOrigin(origins="*")
public class LoginController {

	@GetMapping("login")
	public AuthReturn authUnamePwd(@RequestBody(required=false) AuthUser authUser,
			HttpServletResponse resp) {
		
		AuthReturn ar = new AuthReturn();
		ar.setIsAuth(false);
		ar.setToken("");
		
		if (authUser!=null) {
			
			System.out.println("input json: " + authUser.toString());
			
			String token = getRandomString(16);
			System.out.println("token : " + token);
			
			if (authUser.getUsername()=="root") {
				Cookie userCookie=new Cookie("ULOGIN","admin"); 
				userCookie.setMaxAge(7*24*60*60);    //设置cookie的最大生命周期为一周
				userCookie.setPath("/");    //设置路径为全路径（这样写的好处是同一项目下的页面都可以访问该cookie）
				resp.addCookie(userCookie);   //response是HttpServletResponse类型
				
				ar.setIsAuth(true);
				ar.setToken(token);
				
			} else if (authUser.getUsername()=="yhyancy") {
				Cookie userCookie=new Cookie("ULOGIN","user"); 
				userCookie.setMaxAge(7*24*60*60);    //设置cookie的最大生命周期为一周
				userCookie.setPath("/");    //设置路径为全路径（这样写的好处是同一项目下的页面都可以访问该cookie）
				resp.addCookie(userCookie);   //response是HttpServletResponse类型
				ar.setIsAuth(true);
				ar.setToken(token);
			}
		}
		
		
		return ar;
	}
	
	@PostMapping("login")
	public AuthReturn authUnamePwdPost(@RequestBody(required=false) AuthUser authUser,
			HttpServletResponse resp) {
		AuthReturn ar = new AuthReturn();
		Cookie userCookie;
		ar.setIsAuth(false);
		ar.setToken("");
		
		if (authUser!=null) {
			
			System.out.println("input json: " + authUser.toString());
			
			String token = getRandomString(16);
			System.out.println("token : " + token);
			
			if (authUser.getUsername()=="root") {
				userCookie=new Cookie("ULOGIN","admin"); 
				userCookie.setMaxAge(7*24*60*60);    //设置cookie的最大生命周期为一周
				userCookie.setPath("/");    //设置路径为全路径（这样写的好处是同一项目下的页面都可以访问该cookie）
				resp.addCookie(userCookie);   //response是HttpServletResponse类型
				
				ar.setIsAuth(true);
				ar.setToken(token);
				
			} else if (authUser.getUsername()=="yhyancy") {
				userCookie=new Cookie("ULOGIN","user"); 
				userCookie.setMaxAge(7*24*60*60);    //设置cookie的最大生命周期为一周
				userCookie.setPath("/");    //设置路径为全路径（这样写的好处是同一项目下的页面都可以访问该cookie）
				resp.addCookie(userCookie);   //response是HttpServletResponse类型
				ar.setIsAuth(true);
				ar.setToken(token);
			}
		}
		
		
		return ar;
	}
	
	 public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
}
