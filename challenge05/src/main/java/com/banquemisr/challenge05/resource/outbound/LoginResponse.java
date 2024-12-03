package com.banquemisr.challenge05.resource.outbound;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class LoginResponse {
	
	@NotBlank
	@JsonProperty("token")
	private String token;
	
}
