package com.example.bookstoreSystem.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "userEntity")
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "firstName", nullable = true)
	private String firstName;
	
	@Column(name = "lastName", nullable = true)
	private String lastName;
	
	@Column(name = "phoneNumber", nullable = true)
	private String phoneNumber;
	
	@Column(name = "dateOfBirth", nullable = true)
	private LocalDate dateOfBirth;
	
	@Column(name = "address", nullable = true)
	private String address;
	
	@Column(name = "city", nullable = true)
	private String city;
	
	@Column(name = "profileImageName", nullable = true)
	private String profileImageName;
	
	@Column(name = "activated", nullable = true)
	private boolean activated;
	
	@Column(name = "enabled", nullable = true)
	private boolean enabled;
	
	@Column(name = "firstLogin", nullable = true)
	private boolean firstLogin;
	
	@Column(name = "type", nullable = true)
	private String type;
	
	@Column(name = "last_password_reset_date", nullable = true)
    private Timestamp lastPasswordResetDate;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "userAuthority", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "authorityId", referencedColumnName = "id"))
	private List<Authority> authorities;
	
	@JsonBackReference(value = "user_movement")
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Customer customer;
	
	@JsonBackReference(value = "systemAdmin-movement")
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookstoreSystemAdministrator bookstoreSystemAdministrator;
	
	@JsonBackReference(value = "bookstoreAdmin-movement")
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BookstoreAdministrator bookstoreAdministrator;
	
	public User() {
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public void setEnabled(boolean authorized) {
		this.enabled = authorized;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Timestamp getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getUsername() {
		return this.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BookstoreSystemAdministrator getBookstoreSystemAdministrator() {
		return bookstoreSystemAdministrator;
	}

	public void setBookstoreSystemAdministrator(BookstoreSystemAdministrator bookstoreSystemAdministrator) {
		this.bookstoreSystemAdministrator = bookstoreSystemAdministrator;
	}

	public BookstoreAdministrator getBookstoreAdministrator() {
		return bookstoreAdministrator;
	}

	public void setBookstoreAdministrator(BookstoreAdministrator bookstoreAdministrator) {
		this.bookstoreAdministrator = bookstoreAdministrator;
	}

	public String getProfileImageName() {
		return profileImageName;
	}

	public void setProfileImageName(String profileImageName) {
		this.profileImageName = profileImageName;
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
}