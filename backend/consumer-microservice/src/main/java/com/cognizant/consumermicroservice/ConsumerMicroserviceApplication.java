package com.cognizant.consumermicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerMicroserviceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumerMicroserviceApplication.class);

	public static void main(String[] args) {
		logger.debug("ConsumerMicroserviceApplication");
		SpringApplication.run(ConsumerMicroserviceApplication.class, args);
	}

}

