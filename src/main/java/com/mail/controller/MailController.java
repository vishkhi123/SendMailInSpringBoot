package com.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.modal.MailStructure;
import com.mail.service.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private MailService mailService;
	
	@PostMapping("/send/{sendMail}")
	public ResponseEntity<String> send(@RequestBody MailStructure mailStructure,@PathVariable String sendMail)
	{
		this.mailService.sendEmail(sendMail, mailStructure);
		return new ResponseEntity<String>("Mail Sent SucceessFully!!", HttpStatus.OK);
				
	}
	
}
