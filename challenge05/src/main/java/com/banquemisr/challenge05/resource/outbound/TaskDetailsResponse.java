package com.banquemisr.challenge05.resource.outbound;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
public class TaskDetailsResponse {
	@NotNull
	private Long id;
	
	@NotBlank
	private String title;
	
	private String description;	
	
	@NotBlank
	private String status;
	
	@NotBlank
	private String priority;	
	
	@NotNull
	private Timestamp dueDate;
	
}
