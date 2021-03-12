package com.sudarshan.otp.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.otp.entities.UserDetails;
import com.sudarshan.otp.repositories.OtpRepInterface;

@Service
public class GenerateOtpService {
	
	@Autowired
	OtpRepInterface otpRepInterface;
	
	public int generateOtp(String email) {
		int len = 5;
        String numbers = "123456789"; 
        String numbers0 = "0123456789"; 
        Random rndm_method = new Random(); 
        char[] otp = new char[len]; 
        otp[0] = numbers.charAt(rndm_method.nextInt(numbers.length())); 
        for (int i = 1; i < len; i++) { 
            otp[i] = numbers0.charAt(rndm_method.nextInt(numbers0.length())); 
        }
        int otpVal = Integer.parseInt(String.valueOf(otp));
        Optional<UserDetails> userDetails = otpRepInterface.findById(email);
        if(userDetails.isPresent()) {
        	otpRepInterface.save(new UserDetails(email, otpVal, 1));
            return otpVal;
        }
        else {
        	return -1;
        }	
	}
}
