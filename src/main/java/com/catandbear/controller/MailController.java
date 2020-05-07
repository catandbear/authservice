package com.catandbear.controller;

import java.util.Date;

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
	    message.setSubject("这是一封测试邮件");
	    message.setFrom("1510161612@qq.com");
	    message.setTo("25xxxxx755@qq.com");
	    message.setCc("37xxxxx37@qq.com");
	    message.setBcc("14xxxxx098@qq.com");
	    message.setSentDate(new Date());
	    message.setText("这是测试邮件的正文");
	    mailSender.send(message);


		return "ok";
	}
}
