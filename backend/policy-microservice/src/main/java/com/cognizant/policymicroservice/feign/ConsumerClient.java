package com.cognizant.policymicroservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.policymicroservice.model.Consumer;

@FeignClient(name="consumer-microservice",url="http://localhost:8080")
public interface ConsumerClient {
	@GetMapping("/viewConsumerBusiness/{id}")
	public Consumer viewConsumerBusiness(@PathVariable("id") Long id,@RequestHeader("Authorization") String token);
}
