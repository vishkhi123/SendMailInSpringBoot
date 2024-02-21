package com.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mail.modal.MailStructure;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	
	public void sendEmail(String toMail,MailStructure mailStructure)
	{
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setSubject(mailStructure.getSubject());
		simpleMailMessage.setText(mailStructure.getMessage());
		simpleMailMessage.setFrom(fromMail);
		simpleMailMessage.setTo(toMail);
		javaMailSender.send(simpleMailMessage);
	}
	
	
	
}
