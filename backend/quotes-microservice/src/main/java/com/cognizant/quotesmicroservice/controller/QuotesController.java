package com.cognizant.quotesmicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.quotesmicroservice.QuotesMicroserviceApplication;
import com.cognizant.quotesmicroservice.exception.AuthorizationException;
import com.cognizant.quotesmicroservice.feign.AuthorizeClient;
import com.cognizant.quotesmicroservice.service.QuotesService;

import io.swagger.annotations.ApiOperation;

@RestController
public class QuotesController {

	@Autowired
	QuotesService service;
	
	@Autowired
	AuthorizeClient authorizeClient;
	
	private static final Logger logger = LoggerFactory.getLogger(QuotesController.class);
	
	@GetMapping("/getQuotesForPolicy/{bValue}/{pValue}")
	@ApiOperation(notes ="get quotes for policy based on business value, property value", value="get quotes for policy")
	public String getQuotesForPolicy(@PathVariable("bValue") double bValue,@PathVariable("pValue") double pValue, @RequestHeader("Authorization") String token) throws AuthorizationException {
		System.out.println("LOG AUTH CHECK: pValue" + pValue);
		System.out.println("LOG AUTH CHECK: bValue" + bValue);
		System.out.println("LOG AUTH CHECK: bValue" + bValue);
		return "ok";
		/*
		if(authorizeClient.authorize(token)) {
			logger.debug("Get Quotes ");
			return service.getQuotesForPolicy(bValue, pValue);
		}else {
			logger.debug("Access Denied");
			throw new AuthorizationException("Access Denied");
		}
		*/
	}
	

	@GetMapping("/health-check")
	public ResponseEntity<?> healthCheck(){
		return new ResponseEntity<>("Authorization Working",HttpStatus.OK);
	}
}
