package com.catandbear.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("mail")
	public String tst() {
		
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("didida_cjy@163.com");
		message.setTo("yizheng1991@hotmail.com");
		message.setSubject("您的验证码");
		message.setText("你好，你的验证码是： 1234");

		mailSender.send(message);
		System.out.println("email send done");


		return "ok";
	}
}
