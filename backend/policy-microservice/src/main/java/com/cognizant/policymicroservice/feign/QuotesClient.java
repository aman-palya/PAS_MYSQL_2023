package com.cognizant.policymicroservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="quotes-microservice",url="http://localhost:8082")
public interface QuotesClient {
	@GetMapping("/getQuotesForPolicy/{bValue}/{pValue}")
	public String getQuotesForPolicy(@PathVariable("bValue") double bValue,@PathVariable("pValue") double pValue, @RequestHeader("Authorization") String token); 
}
