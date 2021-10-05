package com.example.bookstoreSystem.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Async
	public void sendConfirmationEmail(String email) throws MailException, InterruptedException { 
		System.out.println("Mail is sending...");
		
		User myUser = userService.findOneByEmail(email);
		Customer myCustomer = customerService.findOneByUserId(myUser.getId());
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("isapsw123@gmail.com");
		msg.setFrom(environment.getProperty("spring.mail.username"));
		msg.setSubject("Account Activation <3");
		msg.setText("Confirm you Bookstore System account by clicking on the link: " + "http://localhost:8080/activateAccount/" + myUser.getId());
	
		javaMailSender.send(msg);
		customerService.save(myCustomer);
		System.out.println("Email sent!");
	}
	
	@Async
	public void sendPasswordRestartEmail(String email) throws MailException, InterruptedException { 
		System.out.println("Mail is sending...");
		
		String temporaryPassword = UUID.randomUUID().toString().replace("-", "");
		String hashedPassword = passwordEncoder.encode(temporaryPassword);
		
		while(hashedPassword.contains("/"))
			hashedPassword = passwordEncoder.encode(temporaryPassword);
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("isapsw123@gmail.com");
		msg.setFrom(environment.getProperty("spring.mail.username"));
		msg.setSubject("Account Password Restart");
		msg.setText("Your temporary password is: " + temporaryPassword + "\nPlease confirm it by clicking on the link: " + "http://localhost:8080/restartPassword/" + email + "/" + hashedPassword);
	
		javaMailSender.send(msg);
		System.out.println("Email sent!");
	}
	
	@Async
	public void accountDisabledNotification() throws  MailException, InterruptedException { 
		System.out.println("Mail is sending...");
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("isapsw123@gmail.com");
		msg.setFrom(environment.getProperty("spring.mail.username"));
		msg.setSubject("Account Disabled :(");
		msg.setText("We are sorry to inform you that your Bookstore++ user account has been disabled temporarily by our administrator. :(");
	
		javaMailSender.send(msg);
		System.out.println("Email sent!");
	}
	
	@Async
	public void accountEnabledNotification() throws  MailException, InterruptedException { 
		System.out.println("Mail is sending...");
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("isapsw123@gmail.com");
		msg.setFrom(environment.getProperty("spring.mail.username"));
		msg.setSubject("Account Enabled :)");
		msg.setText("We inform you that your Bookstore++ user account has been enabled by our administrator. :)");
	
		javaMailSender.send(msg);
		System.out.println("Email sent!");
	}
}
