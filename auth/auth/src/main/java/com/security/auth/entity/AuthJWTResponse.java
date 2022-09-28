package com.security.auth.entity;

public class AuthJWTResponse {

	private User user;
	private String jwtToken;

	public AuthJWTResponse() {
		super();
	}

	public AuthJWTResponse(User user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
