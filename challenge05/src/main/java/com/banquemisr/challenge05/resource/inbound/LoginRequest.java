package com.banquemisr.challenge05.resource.inbound;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class LoginRequest {
	
	@NotBlank
	@Email
	@JsonProperty("email")
	private String email;

	@NotBlank
	@Size(min = 10, max = 100)
	@JsonProperty("password")
	private String password;
	
}
