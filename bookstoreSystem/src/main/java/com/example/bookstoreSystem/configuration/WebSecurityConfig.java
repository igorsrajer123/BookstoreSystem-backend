package com.example.bookstoreSystem.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.bookstoreSystem.authentication.RestAuthenticationEntryPoint;
import com.example.bookstoreSystem.authentication.TokenAuthenticationFilter;
import com.example.bookstoreSystem.security.TokenUtils;
import com.example.bookstoreSystem.service.LoginService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(loginService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
		.authorizeRequests().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
		.antMatchers("/register").permitAll().antMatchers("/login").permitAll()
		.antMatchers("/getCurrentUser").permitAll().antMatchers("/activateAccount/*").permitAll().antMatchers("/h2-console/**").permitAll()
		.antMatchers("/", "/*.html", "/favicon.ico","/*.js", "/*.css").permitAll()
		.anyRequest().authenticated().and()
		.cors().and()
		.addFilterBefore(new TokenAuthenticationFilter(tokenUtils, loginService),
				BasicAuthenticationFilter.class);

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(HttpMethod.POST, "/login", "/changePassword", "/sendAccountConfirmation");
		
		web.ignoring().antMatchers(HttpMethod.PUT, "/activateAccount/*");
		
		web.ignoring().antMatchers(HttpMethod.GET, "/getAllUsers", "/getUserByEmail/*", "/getUserById/*", "/getCurrentUser", "/activateAccount/*", "/getAllGenres",
												"/getGenreById/*", "/getGenreByName/*", "/getAllProducts", "/getProductById/*", "/getProductByName/*", "/getProductByCode/*", "/getProductsByType/*");
	}
}
