package com.catandbear.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailMan {

	
	private JavaMailSender mailSender;
	
	@Autowired
	public MailMan(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sender(String sendToAddress, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("didida_cjy@163.com");
		message.setTo(sendToAddress);
		message.setSubject(subject);
		message.setText(text);

		mailSender.send(message);
		System.out.println("email send done");

	}
	
	
}
