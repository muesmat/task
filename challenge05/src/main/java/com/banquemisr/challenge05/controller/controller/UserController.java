package com.banquemisr.challenge05.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquemisr.challenge05.controller.service.UserService;
import com.banquemisr.challenge05.resource.inbound.LoginRequest;
import com.banquemisr.challenge05.resource.inbound.SignUpRequest;
import com.banquemisr.challenge05.resource.outbound.LoginResponse;
import com.banquemisr.challenge05.resource.outbound.SignUpResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<SignUpResponse> createUser(@RequestBody @Valid SignUpRequest signUpRequest) {		
		SignUpResponse signUpResponse = userService.createUser(signUpRequest);	
		return ResponseEntity.ok(signUpResponse);
	}
	
	@PostMapping("/users/login")
	public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {		
		LoginResponse loginResponse = userService.login(loginRequest);	
		return ResponseEntity.ok(loginResponse);
	}


	

}
