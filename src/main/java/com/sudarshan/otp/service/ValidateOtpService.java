package com.sudarshan.otp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.otp.entities.UserDetails;
import com.sudarshan.otp.repositories.OtpRepInterface;

@Service
public class ValidateOtpService {
	
	@Autowired
	OtpRepInterface otpRepInterface;
	
	public boolean validateOtp(String email, int otpVal) {
		
		Optional<UserDetails> userDetails = otpRepInterface.findById(email);
		if(userDetails.isPresent()) {
			if((userDetails.get().getOtp() == otpVal)) {
				return true;
			}
		}
		return false;
	}
}
