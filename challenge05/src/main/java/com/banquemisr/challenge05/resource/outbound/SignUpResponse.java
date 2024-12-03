package com.banquemisr.challenge05.resource.outbound;


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
public class SignUpResponse {
	
	@NotBlank
	@JsonProperty("firstName")
	private String firstName;

	@NotBlank
	@JsonProperty("lastName")
	private String lastName;

	@NotBlank
	@Email
	@Size(min = 10, max = 100)
	@JsonProperty("email")
	private String email;

	@NotBlank
	@JsonProperty("role")
	private String role;
	
}
