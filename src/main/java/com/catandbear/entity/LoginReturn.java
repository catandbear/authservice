package com.catandbear.entity;

public class LoginReturn {

	private String token;
	private int isAuth;
	private String uType;
	
	public LoginReturn(String token, int isAuth, String uType) {
		super();
		this.token = token;
		this.isAuth = isAuth;
		this.uType = uType;
	}


	public int getIsAuth() {
		return isAuth;
	}


	public void setIsAuth(int isAuth) {
		this.isAuth = isAuth;
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
	
	
	
}
