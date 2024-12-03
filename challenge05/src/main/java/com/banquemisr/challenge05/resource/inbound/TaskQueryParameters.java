package com.banquemisr.challenge05.resource.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class TaskQueryParameters extends PageInfo {
	
	@Size(min = 3)
	@JsonProperty("title")
	private String title;
	
	@Size(min = 6)
	@JsonProperty("description")
	private String description;
		
	@Pattern(regexp = "^(HIGH|MEDIUM|LOW)$")
	@JsonProperty("priority")
	private String priority;
	
	@Pattern(regexp = "^(TODO|SCHEDULED|DONE)$")
	@JsonProperty("status")	
	private String status;	
	

}
