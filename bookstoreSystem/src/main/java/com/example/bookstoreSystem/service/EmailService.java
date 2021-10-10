package com.example.bookstoreSystem.service;

import java.util.ArrayList;
import java.util.List;
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
import com.example.bookstoreSystem.model.Delivery;
import com.example.bookstoreSystem.model.DeliveryItem;
import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.repository.BookRepository;
import com.example.bookstoreSystem.repository.OtherProductRepository;

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
	
	@Autowired
	private DeliveryService deliveryService;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OtherProductRepository otherProductRepository;
	
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
	
	@Async
	public void deliveryDeclined() throws  MailException, InterruptedException {
		System.out.println("Mail is sending...");
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("isapsw123@gmail.com");
		msg.setFrom(environment.getProperty("spring.mail.username"));
		msg.setSubject("Delivery Request Declined :(");
		msg.setText("We inform you that your delivery from Bookstore++ has been declined by our system administrator!");
	
		javaMailSender.send(msg);
		System.out.println("Email sent!");
	}
	
	@Async
	public void deliveryAccepted(Long id) throws  MailException, InterruptedException {
		System.out.println("Mail is sending...");
		
		Delivery myDelivery = deliveryService.findOneById(id);
		List<DeliveryItem> items = myDelivery.getDeliveryItems();
		List<String> itemNames = new ArrayList<String>();
		for(DeliveryItem i : items) {
			if(i.getBook() == null)
				itemNames.add(otherProductRepository.findOneById(i.getOtherProduct().getId()).getName());
			
			if(i.getOtherProduct() == null)
				itemNames.add(bookRepository.findOneById(i.getBook().getId()).getName());
		}
		
		String text = "We inform you that your delivery from Bookstore++ has been accepted.\n"
				+ "Your items will arrive in the next 7 work days.\n"
				+ "Items:\n";
		
		for(int i = 0; i < itemNames.size(); i++) 
			text += i+1 + ". " + itemNames.get(i) + "\n";
		
		text += "\nFee: " + myDelivery.getPrice() + "din.\nThanks for shopping! :)";
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("isapsw123@gmail.com");
		msg.setFrom(environment.getProperty("spring.mail.username"));
		msg.setSubject("Delivery Request Accepted :)");
		msg.setText(text);
	
		javaMailSender.send(msg);
		System.out.println("Email sent!");
	}
}
