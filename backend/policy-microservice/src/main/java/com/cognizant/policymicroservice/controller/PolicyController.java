package com.cognizant.policymicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.policymicroservice.PolicyMicroserviceApplication;
import com.cognizant.policymicroservice.exception.AuthorizationException;
import com.cognizant.policymicroservice.feign.AuthorizeClient;
import com.cognizant.policymicroservice.model.ConsumerPolicy;
import com.cognizant.policymicroservice.model.IssueRequest;
import com.cognizant.policymicroservice.model.PolicyDetailsResponse;
import com.cognizant.policymicroservice.service.PolicyService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
public class PolicyController {

	@Autowired
	PolicyService service;
	
	@Autowired
	AuthorizeClient authorizeClient;
	
	private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);
	
	@PostMapping("/createPolicy")
	@ApiOperation(notes ="creates a new policy for the consumer", value ="creates a policy")
	public ConsumerPolicy createPolicy(@RequestBody ConsumerPolicy policy,@RequestParam("id") Long id, @RequestHeader("Authorization") String token) throws AuthorizationException {
		//if(authorizeClient.authorize(token)) {
		if(true) {
			logger.debug("Create Policy");
		  return service.createPolicy(policy, id,token);

		}else {
			logger.error("Access Denied");
			throw new AuthorizationException("Access Denied");
		}

	}
		

	
	@PostMapping("/issuePolicy")
	@ApiOperation(notes="issues the consumer's policy if it is accepted", value="issue policy" )
	public ConsumerPolicy issuePolicy(@RequestBody IssueRequest request,@RequestHeader("Authorization") String token) throws AuthorizationException {
		if(authorizeClient.authorize(token)) {
			logger.debug("Issue Policy");
			return service.issuePolicy(request);
		}else {
			logger.error("Access Denied");
			throw new AuthorizationException("Access Denied");
		}
	}
	
	@GetMapping("/viewPolicy/{cid}/{pid}")
    @ApiOperation(notes ="returns a particular consumer's policy details", value="display the policy")
	public ConsumerPolicy viewPolicy(@PathVariable("cid") Long cid,@RequestHeader("Authorization") String token) throws AuthorizationException{
		if(authorizeClient.authorize(token)) {
			logger.debug("View Policy");
			return service.viewPolicy(cid);
		}else {
			logger.error("Access Denied");
			throw new AuthorizationException("Access Denied");
		}
	}
	
	@GetMapping("/getQuotes/{bValue}/{pValue}/{pType}")
	@ApiOperation(notes ="returns quotes based on business value, property value and property type", value="display the quotes")
	public String getQuotes(@PathVariable("bValue") double bValue,@PathVariable("pValue") double pValue,@PathVariable("pType") String pType, @RequestHeader("Authorization") String token) throws AuthorizationException{
		if(authorizeClient.authorize(token)) {
			
		return service.getQuotes(bValue, pValue,token);
		}else {
			throw new AuthorizationException("Access Denied");
		}
	}
	

	@GetMapping("/health-check")
	public ResponseEntity<?> healthCheck(){
		return new ResponseEntity<>("Authorization Working",HttpStatus.OK);
	}
}
