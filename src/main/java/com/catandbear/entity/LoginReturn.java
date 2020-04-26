package com.catandbear.entity;

public class LoginReturn {

	public String token;
	public boolean isAuth;
	public String uType;
	
	
	
	public LoginReturn(String token, boolean isAuth, String uType) {
		super();
		this.token = token;
		this.isAuth = isAuth;
		this.uType = uType;
	}
	
	
	public LoginReturn() {
	}


	public String getuType() {
		return uType;
	}
	public void setuType(String uType) {
		this.uType = uType;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean getIsAuth() {
		return isAuth;
	}
	public void setIsAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}
	
	
}
