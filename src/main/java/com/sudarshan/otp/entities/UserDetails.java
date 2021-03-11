package com.sudarshan.otp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class UserDetails {
	@Id
	private String email;
	private int otp;
	public String getEmail() {
		return email;
	}
	
	public UserDetails() {
		super();
	}

	public UserDetails(String email, int otp) {
		super();
		this.email = email;
		this.otp = otp;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
}
