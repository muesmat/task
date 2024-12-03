package com.banquemisr.challenge05.resource.inbound;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class TaskCreateRequest {
	
	
	@NotBlank
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;
		
	@NotBlank
	@Pattern(regexp = "^(HIGH|MEDIUM|LOW)$")
	@JsonProperty("priority")
	private String priority;
	
	@NotNull
	@JsonProperty("dueDate")
	private Timestamp dueDate;
	
}
