package com.sudarshan.otp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.otp.entities.UserDetails;
import com.sudarshan.otp.repositories.OtpRepInterface;

@Service
public class ValidateRegistrationOtpService {
	@Autowired
	OtpRepInterface otpRepInterface;
	
	public int validateRegistrationOtp(String email, int otpVal) {
		Optional<UserDetails> userDetails = otpRepInterface.findById(email);
		
		if(userDetails.isPresent()) {
			if(userDetails.get().getVerified() == 0) {
				if(userDetails.get().getOtp() == otpVal) {
					otpRepInterface.save(new UserDetails(email, otpVal, 1));
					return 1;
				}else {
					return -3;	// given otp is inValid
				}
			}else {
				return -2;	// given email id is already verified
			}
		}else {
			return -1;	// given email id is not present
		}
	}
}
