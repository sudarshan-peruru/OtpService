package com.sudarshan.otp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudarshan.otp.entities.UserDetails;

public interface OtpRepInterface extends JpaRepository<UserDetails, String>{
	
}
