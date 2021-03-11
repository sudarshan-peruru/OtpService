package com.sudarshan.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sudarshan.otp.service.GenerateOtpService;
import com.sudarshan.otp.service.ValidateOtpService;

@RestController
@RequestMapping(value = "/otp")
public class OtpController {
	
	
	@Autowired
	GenerateOtpService generateOtpService;
	@Autowired
	ValidateOtpService validateOtpService;
	
	
	@GetMapping(value = "/generateOtp")
	public int getOtp(@RequestParam String email) {
		System.out.println(email);	
		return generateOtpService.generateOtp(email);
	}
	
	@GetMapping(value = "/validateOtp")
	public Boolean validateOtp(@RequestParam String email, @RequestParam int otpVal) {
		return validateOtpService.validateOtp(email, otpVal);
	}
}
