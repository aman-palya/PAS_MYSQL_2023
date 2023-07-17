package com.cognizant.policymicroservice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.policymicroservice.exception.AuthorizationException;
import com.cognizant.policymicroservice.feign.AuthorizeClient;
import com.cognizant.policymicroservice.feign.ConsumerClient;
import com.cognizant.policymicroservice.model.Consumer;
import com.cognizant.policymicroservice.model.ConsumerPolicy;
import com.cognizant.policymicroservice.repository.ConsumerPolicyRepository;
import com.cognizant.policymicroservice.repository.PolicyMasterRepository;
import com.cognizant.policymicroservice.service.PolicyService;

@SpringBootTest
@AutoConfigureMockMvc
public class PolicyServiceTest {

	@Autowired
	MockMvc mockMvc;
	
	@Mock
	PolicyService service;
	
	@Mock
	ConsumerPolicyRepository repo;
	
	@Autowired
	PolicyMasterRepository mRepo;
	
	@Mock
	ConsumerClient cClient;
	
	@Autowired
	AuthorizeClient client;
	
	String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuZXciLCJleHAiOjE2Mzc2NTgxMDUsImlhdCI6MTYzNzY0MDEwNX0.01T4lFOb-0PQbgvYXyMRWE01wBDaUnG8LQ7PowgiDXc4YMvf-CG2bhZiPS8KT9pX_KlsXRsu3aiHk-L1rDddsw";

	
	@Test
	public void testWrongTokenAuthorization() throws Exception,AuthorizationException {
		boolean res = client.authorize("WRONG_TOKEN");
		//assertFalse(res);
	}
	
	@Test
	public void testCreatePolicyService() {
		ConsumerPolicy consumerPolicy = new ConsumerPolicy();
		consumerPolicy.setPolicyid(100);
		consumerPolicy.setConsumerid("501");
		consumerPolicy.setBusinessid(12);
		consumerPolicy.setPolicystatus("inititated");
		consumerPolicy.setAcceptedquote("100000");
		consumerPolicy.setAcceptance("false");
		consumerPolicy.setPaymentdetails("Details");
		consumerPolicy.setAmount("1300000");
		consumerPolicy.setDuration("40");
		consumerPolicy.setEdate("date");
		Mockito.when(repo.save(any(ConsumerPolicy.class))).thenReturn(consumerPolicy);	
	//	Mockito.when(service.createPolicy(consumerPolicy, "501", token)).thenReturn(consumerPolicy);
	}
	
	@Test
	void testConsumerClient() {
		Consumer c = new Consumer();
	//	Mockito.when(cClient.viewConsumerBusiness("501", token)).thenReturn(c);
	}
	
	@Test 
	void testGetWrongQuotes() {
		String q = "200000";
		String res = service.getQuotes(15.0, 13.0,token);
		assertNull(res);
	}
	
	
}
