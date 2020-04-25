package com.catandbear.controller;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catandbear.vo.AuthReturn;
import com.catandbear.vo.AuthUser;

@RestController
@CrossOrigin(origins="*")
public class LoginController {
	
	@PostMapping("login")
	public AuthReturn authUnamePwd(@RequestBody(required=false) AuthUser authUser,
			HttpServletResponse resp) {
		AuthReturn ar = new AuthReturn();
		Cookie userCookie = null;
		String token = getRandomString(16);
		ar.setIsAuth(false);
		ar.setToken("");
		
		if (authUser!=null) {
			
			System.out.println("input json: " + authUser.toString());
			
			
			System.out.println("token : " + token);
			
			if ("root".equals(authUser.getUsername())) {
				userCookie=new Cookie("ULOGIN","admin"); 
				userCookie.setMaxAge(7*24*60*60);
				userCookie.setPath("/");   
				resp.addCookie(userCookie); 
				
				ar.setIsAuth(true);
				ar.setToken(token);
				
			} else if ("yhyancy".equals(authUser.getUsername())) {
				userCookie=new Cookie("ULOGIN","user"); 
				userCookie.setMaxAge(7*24*60*60); 
				userCookie.setPath("/");
				resp.addCookie(userCookie);
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
