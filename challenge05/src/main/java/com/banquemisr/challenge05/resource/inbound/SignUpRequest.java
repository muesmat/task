package com.banquemisr.challenge05.resource.inbound;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class SignUpRequest {
	
	@NotBlank
	@JsonProperty("firstName")
	private String firstName;

	@NotBlank
	@JsonProperty("lastName")
	private String lastName;

	@NotBlank
	@Email
	@JsonProperty("email")
	private String email;

	@NotBlank
	@Size(min = 10, max = 100)
	@JsonProperty("password")
	private String password;

	@NotBlank
	@Pattern(regexp = "^(ADMIN|USER)$")
	@JsonProperty("role")
	private String role;
	
}
