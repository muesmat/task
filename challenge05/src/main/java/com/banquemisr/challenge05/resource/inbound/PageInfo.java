package com.banquemisr.challenge05.resource.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo {
	
	@JsonProperty("offset")
	private Integer offset = 0;
	
	@JsonProperty("pageSize")
	private Integer pageSize = 10;
		
	
	

}
