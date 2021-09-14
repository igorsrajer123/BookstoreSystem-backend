package com.example.bookstoreSystem.controller;

import java.io.IOException;

import javax.naming.AuthenticationException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreSystem.authentication.JwtAuthenticationRequest;
import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.model.UserTokenState;
import com.example.bookstoreSystem.security.TokenUtils;
import com.example.bookstoreSystem.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
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
}
