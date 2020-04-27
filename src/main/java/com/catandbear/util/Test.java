package com.catandbear.util;

public class Test {

	private static String s = "123123";
	public static void main(String[] args) {
		change();
		System.out.println(s);
	}
	
	public static void change() {
		s = "asdfsadf";
	}
}
