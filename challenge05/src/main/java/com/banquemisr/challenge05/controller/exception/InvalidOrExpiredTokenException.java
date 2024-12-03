package com.banquemisr.challenge05.controller.exception;

public class InvalidOrExpiredTokenException extends RuntimeException {
	 
	private static final long serialVersionUID = 1L;

	public InvalidOrExpiredTokenException(String message) {
	        super(message);
	}
}
