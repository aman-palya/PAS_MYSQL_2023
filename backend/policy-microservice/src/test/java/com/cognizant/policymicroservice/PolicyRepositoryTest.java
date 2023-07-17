package com.cognizant.policymicroservice;

import javax.persistence.Column;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.policymicroservice.model.ConsumerPolicy;
import com.cognizant.policymicroservice.model.PolicyMaster;
import com.cognizant.policymicroservice.repository.ConsumerPolicyRepository;
import com.cognizant.policymicroservice.repository.PolicyMasterRepository;
import com.cognizant.policymicroservice.service.PolicyService;

import io.swagger.annotations.ApiModelProperty;

@SpringBootTest
@AutoConfigureMockMvc
public class PolicyRepositoryTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	PolicyService service;
	
	@Autowired
	ConsumerPolicyRepository repo;
	
	@Autowired
	PolicyMasterRepository mRepo;
	
	String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhaiIsImV4cCI6MTYzNzU4OTE5MSwiaWF0IjoxNjM3NTcxMTkxfQ.O9oZLwrX7zx6qCvrH4mq8d4jM2gEjgoHIokH6F288cdmZUgsm5KsSiIzClR_x8xAl2gO-a5RqZ5NgDtz_r_zPw";

	
	@Test
	void testCreateConsumerPolicyRepository() {
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
		ConsumerPolicy p = repo.save(consumerPolicy);
        Assert.assertNotNull(repo.findById(100));

	}
	
	@Test
	void testPolicyMasterRepo() {
		PolicyMaster m = new PolicyMaster();
		m.setId(100);
		m.setAssured_sum("100000");
		m.setBvalue(10.0);
		m.setPvalue(13.0);
		PolicyMaster master = mRepo.save(m);
		Assert.assertNotNull(master.getId());
	}
	
	
}
