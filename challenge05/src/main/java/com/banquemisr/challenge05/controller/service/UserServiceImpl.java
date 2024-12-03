package com.banquemisr.challenge05.controller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.banquemisr.challenge05.config.JwtTokenProvider;
import com.banquemisr.challenge05.controller.exception.UserAlreadyRegisteredException;
import com.banquemisr.challenge05.controller.model.User;
import com.banquemisr.challenge05.controller.repository.UserRepository;
import com.banquemisr.challenge05.resource.inbound.LoginRequest;
import com.banquemisr.challenge05.resource.inbound.SignUpRequest;
import com.banquemisr.challenge05.resource.outbound.LoginResponse;
import com.banquemisr.challenge05.resource.outbound.SignUpResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public SignUpResponse createUser(SignUpRequest signUpRequest) {
		Optional<User> optionalUser = userRepository.findByEmail(signUpRequest.getEmail());

		if (optionalUser.isPresent()) {
			throw new UserAlreadyRegisteredException("An user already registered with this email.");
		}

		User user = new User();

		user.setFirstName(signUpRequest.getFirstName());
		user.setLastName(signUpRequest.getLastName());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(bCryptPasswordEncoder.encode(signUpRequest.getPassword()));
		user.setRole(signUpRequest.getRole());

		User savedUser = userRepository.save(user);

		return buildSignUpResponse(savedUser);
	}

	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		/*Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());

		if (optionalUser.isEmpty() || !optionalUser.get().getPassword().equals(loginRequest.getPassword())) {
			throw new InvalidCredentialsException("Invalid user email or password");
		}*/

		LoginResponse loginResponse = new LoginResponse();

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

	
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenProvider.generateToken(authentication);

		loginResponse.setToken(token);

		return loginResponse;
	}

	private SignUpResponse buildSignUpResponse(User user) {
		SignUpResponse signUpResponse = new SignUpResponse();

		signUpResponse.setFirstName(user.getFirstName());
		signUpResponse.setLastName(user.getLastName());
		signUpResponse.setEmail(user.getEmail());
		signUpResponse.setRole(user.getRole());

		return signUpResponse;

	}

}
