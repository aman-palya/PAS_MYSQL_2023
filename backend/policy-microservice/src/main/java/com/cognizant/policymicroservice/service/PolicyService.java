package com.cognizant.policymicroservice.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.policymicroservice.controller.PolicyController;
import com.cognizant.policymicroservice.feign.ConsumerClient;
import com.cognizant.policymicroservice.feign.QuotesClient;
import com.cognizant.policymicroservice.model.Consumer;
import com.cognizant.policymicroservice.model.ConsumerPolicy;
import com.cognizant.policymicroservice.model.IssueRequest;
import com.cognizant.policymicroservice.model.PolicyDetailsResponse;
import com.cognizant.policymicroservice.model.PolicyMaster;
import com.cognizant.policymicroservice.repository.ConsumerPolicyRepository;
import com.cognizant.policymicroservice.repository.PolicyMasterRepository;

@Service
public class PolicyService {

	@Autowired
	ConsumerPolicyRepository consumerPolicyRepo;
	
	@Autowired
	PolicyMasterRepository policyMasterRepo;
	
	@Autowired
	ConsumerClient consumerClient;
	
	@Autowired
	QuotesClient quotesClient;
	
	private static final Logger logger = LoggerFactory.getLogger(PolicyService.class);
	
	@Transactional
	public ConsumerPolicy createPolicy(ConsumerPolicy policy,Long id,String token) {
		logger.debug("Create Policy Service");
		Consumer consumer = consumerClient.viewConsumerBusiness(id,token);
		double bValue = consumer.getBusiness().getBusinessValue();
		double pValue = consumer.getProperty().getPropertyValue();
		String availableQuotes = quotesClient.getQuotesForPolicy(bValue,pValue,token);
		ConsumerPolicy consumerPolicy = new ConsumerPolicy();
		consumerPolicy.setPolicyid(policy.getPolicyid());
		consumerPolicy.setConsumerid(consumer.getId());
		consumerPolicy.setBusinessid(policy.getBusinessid());
		consumerPolicy.setPolicystatus("inititated");
		consumerPolicy.setAcceptedquote(policy.getAcceptedquote());
		consumerPolicy.setAcceptance(policy.getAcceptance());
		consumerPolicy.setPaymentdetails(availableQuotes);
		consumerPolicy.setAmount(policy.getAmount());
		consumerPolicy.setDuration(policy.getDuration());
		consumerPolicy.setEdate(policy.getEdate());
		consumerPolicyRepo.save(consumerPolicy);
		return consumerPolicy;
	}
	
	@Transactional
	public ConsumerPolicy issuePolicy(IssueRequest request) {
		logger.debug("Issue Policy Service");
		ConsumerPolicy policy = consumerPolicyRepo.findByConsumeridAndBusinessid(request.getConsumerid(), request.getBusinessid());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime date = LocalDateTime.now();
		policy.setPolicystatus("Issued");
		policy.setPolicyid(request.getPolicyid());
		policy.setEdate(dtf.format(date));
		policy.setAcceptance("Accepted");
		policy.setAcceptedquote(request.getAcceptedQuote());
		consumerPolicyRepo.save(policy);
		return policy;
		
	}
	
	@Transactional
	public ConsumerPolicy viewPolicy(Long consumerid) {
		logger.debug("View Policy Service");
		ConsumerPolicy c = consumerPolicyRepo.findByConsumerid(consumerid);
		return c;
	}
	
	@Transactional
	public String getQuotes(double bValue, double pValue,String token) {
		logger.debug("Get quotes Service");
		return quotesClient.getQuotesForPolicy(bValue, pValue,token);
	}
	 
}
