package com.cognizant.consumermicroservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="authorization-microservice",url="http://localhost:8085")
public interface AuthorizeClient {
	@PostMapping("/authorize")
	public boolean authorize(@RequestHeader("Authorization") String token);
	
}
