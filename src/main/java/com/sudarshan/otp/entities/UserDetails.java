package com.sudarshan.otp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class UserDetails {
	@Id
	private String email;
	private int otp;
	private int verified;
	
	
	
	public int getVerified() {
		return verified;
	}
	public void setVerified(int verified) {
		this.verified = verified;
	}
	public UserDetails() {
		super();
	}
	public UserDetails(String email, int otp, int verified) {
		super();
		this.email = email;
		this.otp = otp;
		this.verified = verified;
	}
	
	public String getEmail() {
		return email;
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
