package com.banquemisr.challenge05;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Challenge05Application {

	public static void main(String[] args) {
		 TimeZone.setDefault(TimeZone.getTimeZone("GMT+02:00"));
		SpringApplication.run(Challenge05Application.class, args);
	}

}
