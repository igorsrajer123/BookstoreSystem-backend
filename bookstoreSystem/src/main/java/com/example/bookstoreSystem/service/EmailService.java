package com.example.bookstoreSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.bookstoreSystem.model.Customer;
import com.example.bookstoreSystem.model.User;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Async
	public void sendConfirmationEmail(String email) throws MailException, InterruptedException { 
		System.out.println("Mail is sending...");
		
		User myUser = userService.findOneByEmail(email);
		Customer myCustomer = customerService.findOneByUserId(myUser.getId());
		String path = "http://localhost:8080/activateAccount/" + myUser.getId();
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("isapsw123@gmail.com");
		msg.setFrom(environment.getProperty("spring.mail.username"));
		msg.setSubject("Account Activation <3");
		msg.setText("Confirm you Bookstore System account by clicking the link: " + path);
	
		javaMailSender.send(msg);
		customerService.save(myCustomer);
		System.out.println("Email sent!");
	}
}
