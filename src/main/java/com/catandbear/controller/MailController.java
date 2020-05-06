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

		message.setFrom("yizheng1991@hotmail.com");
		message.setTo("didida_cjy@163.com");
		message.setSubject("it is a test for spring boot");
		message.setText("你好，我是小黄，我正在测试发送邮件。");

		try {
			mailSender.send(message);
			System.out.println("小黄的测试邮件已发送。");

		} catch (Exception e) {
			System.out.println("小黄发送邮件时发生异常了！");

		}

		return "ok";
	}
}
