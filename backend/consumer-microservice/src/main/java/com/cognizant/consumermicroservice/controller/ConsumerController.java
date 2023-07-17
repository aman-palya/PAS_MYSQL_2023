package com.cognizant.consumermicroservice.controller;

import java.util.List;

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

import com.cognizant.consumermicroservice.ConsumerMicroserviceApplication;
import com.cognizant.consumermicroservice.exception.AuthorizationException;
import com.cognizant.consumermicroservice.feign.AuthorizeClient;
import com.cognizant.consumermicroservice.model.Consumer;
import com.cognizant.consumermicroservice.model.Property;
import com.cognizant.consumermicroservice.service.ConsumerService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
public class ConsumerController {

	@Autowired
	ConsumerService service;
	
	@Autowired
	AuthorizeClient auth;
	
	@Autowired
	AuthorizationException exp;
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

	@PostMapping("/createConsumerBusiness")
	@ApiOperation(notes ="creates the consumer business", value="create consumer business")
	public ResponseEntity<?> createConsumerBusiness(@RequestBody Consumer consumer, @RequestHeader("Authorization") String token) throws AuthorizationException {
		
			if(auth.authorize(token)) {
				logger.debug("Creating Consumer Business");
				return service.createConsumerBusiness(consumer);
			}else {
				logger.error("Access Denied");
				return exp.throwAuthorizationException("Access Denied");
			}
	}
	
	@PostMapping("/updateConsumerBusiness")
	@ApiOperation(notes ="updates consumer business details", value="updates consumer business")
	public ResponseEntity<?>  updateConsumerBusiness(@RequestBody Consumer consumer,@RequestHeader("Authorization") String token) throws AuthorizationException{
		if(auth.authorize(token)) {
			logger.debug("Update Consumer Business");
			return service.updateConsumerBusiness(consumer);
		}else {
			logger.error("Access Denied");
			return exp.throwAuthorizationException("Access Denied");
		}
	}
	
	@PostMapping("/createBusinessProperty")
	@ApiOperation(notes ="create business property based on consumer and business", value="create business property")
	public ResponseEntity<?> createBusinessProperty(@RequestParam("id") Long id,@RequestBody Property property,@RequestHeader("Authorization") String token) throws AuthorizationException {
		if(auth.authorize(token)) {	
			logger.debug("Creating business property");
			return service.createBusinessProperty(id, property);
		}else {
			logger.error("Access Denied");
			return exp.throwAuthorizationException("Access Denied");
		}
		
		//return "Property Not Eligible";
	}
	
	@PostMapping("/updateBusinessProperty")
	@ApiOperation(notes ="updates the business property details", value ="update business property")
	public ResponseEntity<?> updateBusinessProperty(@RequestParam("id") Long id,@RequestBody Property property,@RequestHeader("Authorization") String token) throws AuthorizationException {
		if(auth.authorize(token)) {
			logger.debug("Updating business property");
			return service.updateBusinessProperty(id, property);
		}else {
			logger.error("Access Denied");
			return exp.throwAuthorizationException("Access Denied");
		}
	}
	
	@GetMapping("/viewConsumerBusiness")
	@ApiOperation(notes ="view the consumer business based on id", value ="view consumer business")
	public List<Consumer> viewAllConsumerBusiness(@RequestHeader("Authorization") String token) throws AuthorizationException{
		if(auth.authorize(token)) {
			logger.debug("View Consumer Business");
			return service.viewAllConsumerBusiness();
		}else {
			logger.error("Access Denied");
			exp.throwAuthorizationException("Access Denied");
			return null;
		}
		
	}
	
	/*@GetMapping("/viewConsumerBusiness")
	@ApiOperation(notes ="view the consumer business based on id", value ="view consumer business")
	public String viewAllConsumerBusiness(@RequestHeader("Authorization") String token) throws AuthorizationException{
		return "Check";
	}*/
	
	@GetMapping("/viewConsumerBusiness/{id}")
	@ApiOperation(notes ="view the consumer business based on id", value ="view consumer business")
	public Consumer viewConsumerBusiness(@PathVariable("id") Long id,@RequestHeader("Authorization") String token) throws AuthorizationException{
		if(auth.authorize(token)) {
			logger.debug("View Consumer Business");
			return service.viewConsumerBusiness(id);
		}else {
			logger.error("Access Denied");
			exp.throwAuthorizationException("Access Denied");
			return null;
		}
		
	}
	
	
	@GetMapping("/viewConsumerProperty/{pid}")
	@ApiOperation(notes ="view consumer property based on id", value ="view consumer property")
	public Property viewConsumerProperty (@PathVariable("pid") int pid,@RequestHeader("Authorization") String token) throws AuthorizationException {
		if(auth.authorize(token)) {
			logger.debug("View Consumer Property");
			return service.viewConsumerProperty(pid);
		}else {
			logger.error("Access Denied");
			exp.throwAuthorizationException("Access Denied");
			return null;
		}
	}
	

	@GetMapping("/health-check")
	public ResponseEntity<?> healthCheck(){
		return new ResponseEntity<>("Authorization Working",HttpStatus.OK);
	}
}
