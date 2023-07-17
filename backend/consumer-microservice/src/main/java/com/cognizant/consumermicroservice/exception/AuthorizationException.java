package com.cognizant.consumermicroservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cognizant.consumermicroservice.controller.ConsumerController;

@Component
public class AuthorizationException extends Exception {

	private static final Logger logger = LoggerFactory.getLogger(AuthorizationException.class);
	
	public ResponseEntity<?> throwAuthorizationException(String msg) {
		logger.error("Access Denied");
		return new ResponseEntity<>("Access Denied",HttpStatus.FORBIDDEN);
	}
}
