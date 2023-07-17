package com.cognizant.quotesmicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.cognizant.quotesmicroservice"})
@EnableFeignClients
public class QuotesMicroserviceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(QuotesMicroserviceApplication.class);

	public static void main(String[] args) {
		logger.debug("QuotesMicroserviceApplication");
		SpringApplication.run(QuotesMicroserviceApplication.class, args);
	}

}
