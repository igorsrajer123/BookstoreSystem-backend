package com.example.bookstoreSystem.model;

public class UserTokenState {
	
	private String accessToken;
	private long expiresIn;

	public UserTokenState() {
		super();
	}

	public UserTokenState(String accessToken, long expiresIn) {
		super();
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}
}
