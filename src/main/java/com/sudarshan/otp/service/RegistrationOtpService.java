package com.sudarshan.otp.service;

import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.otp.entities.UserDetails;
import com.sudarshan.otp.repositories.OtpRepInterface;

@Service
public class RegistrationOtpService {
	
	@Autowired
	OtpRepInterface otpRepInterface;
	
	public int registerOtp(String email) {
		final Pattern validRegexPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = validRegexPattern.matcher(email);
		if(!matcher.find()) {
			return -2;	// -2 for invalid email id
		}
		Optional<UserDetails> userDetailsOptional = otpRepInterface.findById(email);
		if(userDetailsOptional.isPresent()) {
			return -3;	// -3 for existing email id, already registered
		}
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
        otpRepInterface.save(new UserDetails(email, otpVal, 0));
        return otpVal;
	}
}
