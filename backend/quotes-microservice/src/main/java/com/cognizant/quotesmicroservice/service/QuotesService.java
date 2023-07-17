package com.cognizant.quotesmicroservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.quotesmicroservice.controller.QuotesController;
import com.cognizant.quotesmicroservice.model.QuotesMaster;
import com.cognizant.quotesmicroservice.repository.QuotesMasterRepository;

@Service
public class QuotesService {

	@Autowired
	QuotesMasterRepository quotesRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(QuotesService.class);

	public String getQuotesForPolicy(double bValue, double pValue) {
		logger.debug("Get Quotes Service");
		QuotesMaster quotes = quotesRepo.findByBusinessValueAndPropertyValue(bValue, pValue);
		return quotes.getQuotes();
	}
	
}
