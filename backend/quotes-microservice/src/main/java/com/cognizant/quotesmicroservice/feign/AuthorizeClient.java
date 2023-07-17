package com.cognizant.quotesmicroservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="authorization-microservice",url="http://localhost:8085")
public interface AuthorizeClient {
	@PostMapping("/authorize")
	public boolean authorize(@RequestHeader("Authorization") String token);
}
