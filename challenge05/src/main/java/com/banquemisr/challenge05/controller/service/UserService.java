package com.banquemisr.challenge05.controller.service;

import com.banquemisr.challenge05.resource.inbound.LoginRequest;
import com.banquemisr.challenge05.resource.inbound.SignUpRequest;
import com.banquemisr.challenge05.resource.outbound.LoginResponse;
import com.banquemisr.challenge05.resource.outbound.SignUpResponse;

public interface UserService {
	
	public SignUpResponse createUser(SignUpRequest signUpRequest);
	public LoginResponse login(LoginRequest loginRequest);
}
