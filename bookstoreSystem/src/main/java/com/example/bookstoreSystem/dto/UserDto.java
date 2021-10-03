package com.example.bookstoreSystem.dto;

import java.time.LocalDate;

import com.example.bookstoreSystem.model.User;

public class UserDto {

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private LocalDate dateOfBirth;
	private String address;
	private String city;
	private String profileImageName;
	private String type;
	private boolean firstLogin;
	private boolean enabled;
	
	public UserDto() {
		super();
	}
	
	public UserDto(User u) {
		this(u.getId(), u.getEmail(), u.getFirstName(), u.getLastName(), u.getAddress(), u.getCity(), u.getPhoneNumber(), u.getDateOfBirth(), u.getType(), u.getProfileImageName(), u.isFirstLogin(), u.isEnabled());
	}
	
	public UserDto(Long id, String email, String firstName, String lastName, String address, String city, String phoneNumber, LocalDate dateOfBirth, String type, String profileImageName, boolean firstLogin, boolean enabled) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.type = type;
		this.profileImageName = profileImageName;
		this.firstLogin = firstLogin;
		this.setEnabled(enabled);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getProfileImageName() {
		return profileImageName;
	}
	
	public void setProfileImageName(String profileImageName) {
		this.profileImageName = profileImageName;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
