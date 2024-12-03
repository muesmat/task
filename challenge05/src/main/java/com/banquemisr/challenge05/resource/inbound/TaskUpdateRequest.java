package com.banquemisr.challenge05.resource.inbound;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class TaskUpdateRequest {
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;	
	
	@Pattern(regexp = "^(TODO|SCHEDULED|DONE)$")
	@JsonProperty("status")	
	private String status;	
	
	@Pattern(regexp = "^(HIGH|MEDIUM|LOW)$")
	@JsonProperty("priority")	
	private String priority;	
	
	@JsonProperty("dueDate")
	private Timestamp dueDate;
}
