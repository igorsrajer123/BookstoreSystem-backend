package com.example.bookstoreSystem.controller;

import java.io.IOException;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.authentication.JwtAuthenticationRequest;
import com.example.bookstoreSystem.model.Customer;
import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.model.UserTokenState;
import com.example.bookstoreSystem.security.TokenUtils;
import com.example.bookstoreSystem.service.LoginService;
import com.example.bookstoreSystem.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserTokenState> login(@RequestBody JwtAuthenticationRequest request, HttpServletResponse response) throws AuthenticationException, IOException{
		User myUser = new User(request.getUsername(), request.getPassword());
		myUser = loginService.login(myUser);
		
		if(myUser == null) return new ResponseEntity<UserTokenState>(HttpStatus.NOT_FOUND);
		
		final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		User user = (User) authentication.getPrincipal();
		String token = tokenUtils.generateToken(user.getUsername());
		int expires = tokenUtils.getExpiredIn();
		
		return ResponseEntity.ok(new UserTokenState(token, expires));
	}
	
	@GetMapping(value = "/getCurrentUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getCurrentUser(HttpServletRequest request) {
		String myToken = tokenUtils.getToken(request);
		String email = tokenUtils.getUsernameFromToken(myToken);
		User myUser = userService.findOneByEmail(email);
		
		if(myUser == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(myUser, HttpStatus.OK);
	}
	
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> register(@RequestBody Customer customer) throws Exception {
		Customer myCustomer = loginService.register(customer);
		
		if(myCustomer == null) return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Customer>(myCustomer, HttpStatus.OK);
	}
	
	@PostMapping(value = "/changePassword", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> changePass(@RequestBody String[] data, HttpServletRequest request) {
		String myToken = tokenUtils.getToken(request);
		String email = tokenUtils.getUsernameFromToken(myToken);
		User myUser = userService.findOneByEmail(email);
		
		if(myUser == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		myUser.setPassword(passwordEncoder.encode(data[0]));
		myUser.setFirstLogin(false);
		myUser = userService.save(myUser);
		
		return new ResponseEntity<User>(myUser, HttpStatus.OK);
	}
}
