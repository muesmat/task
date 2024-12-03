package com.banquemisr.challenge05.controller.exception;

public class UserAlreadyRegisteredException extends RuntimeException {
	 
	private static final long serialVersionUID = 1L;

	public UserAlreadyRegisteredException(String message) {
	        super(message);
	    }
}
