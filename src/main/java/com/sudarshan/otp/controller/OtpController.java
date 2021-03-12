package com.sudarshan.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sudarshan.otp.service.GenerateOtpService;
import com.sudarshan.otp.service.RegistrationOtpService;
import com.sudarshan.otp.service.ValidateOtpService;
import com.sudarshan.otp.service.ValidateRegistrationOtpService;

@RestController
@RequestMapping(value = "/otp")
public class OtpController {
	
	
	@Autowired
	GenerateOtpService generateOtpService;
	@Autowired
	ValidateOtpService validateOtpService;
	@Autowired
	RegistrationOtpService registrationOtpService;
	@Autowired
	ValidateRegistrationOtpService validateRegistrationOtpService;
	
	
	@GetMapping(value = "/generateOtp")
	public int getOtp(@RequestParam String email) {
		System.out.println(email);	
		return generateOtpService.generateOtp(email);
	}
	
	@GetMapping(value = "/validateOtp")
	public Boolean validateOtp(@RequestParam String email, @RequestParam int otpVal) {
		return validateOtpService.validateOtp(email, otpVal);
	}
	
	@GetMapping(value = "/registrationOtp")
	public int registrationOtp(@RequestParam String email) {
		return registrationOtpService.registerOtp(email);
	}
	
	@GetMapping(value = "/registrationValidateOtp")
	public int name(@RequestParam String email, @RequestParam int otpVal) {
		return validateRegistrationOtpService.validateRegistrationOtp(email, otpVal);
	}
}
