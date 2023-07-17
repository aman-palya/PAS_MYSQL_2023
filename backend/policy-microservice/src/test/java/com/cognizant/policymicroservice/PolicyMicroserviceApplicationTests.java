package com.cognizant.policymicroservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.policymicroservice.model.Consumer;
import com.cognizant.policymicroservice.model.ConsumerPolicy;
import com.cognizant.policymicroservice.model.IssueRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiModelProperty;

@SpringBootTest
@AutoConfigureMockMvc
class PolicyMicroserviceApplicationTests {

	@Autowired
	MockMvc mvc;
	
	String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuZXciLCJleHAiOjE2Mzc2NTgxMDUsImlhdCI6MTYzNzY0MDEwNX0.01T4lFOb-0PQbgvYXyMRWE01wBDaUnG8LQ7PowgiDXc4YMvf-CG2bhZiPS8KT9pX_KlsXRsu3aiHk-L1rDddsw";
	
	@Test
	public void testCreatePolicyWithInvalidToken() throws Exception {
		
		String json = "{ 'pid':12, 'area':30.0, 'propertytype':'asfsdf', 'insurancetype':'asff', 'buildingtype':'asfdf', 'propertyValue':21432, 'costOfAsset':12442, 'salvageValue':1243, 'usefulLifeOfAsset':124, 'age':12, 'storey':12 }";
		this.mvc.perform(post("/createPolicy")
				.param("id", "500")
				.content(json)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "WRONG "+token))
				.andExpect(status().is(400));
	}
	

	@Test
	public void testCreatePolicyWithValidToken() throws Exception {
		Consumer c = new Consumer("C1","Customer",new Date(),"PAN","abc@test.com",10.0,"Agent","A1");
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
		String json = new ObjectMapper().valueToTree(consumerPolicy).toString();
		this.mvc.perform(post("/createPolicy")
				.content(json)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer "+token))
				.andExpect(status().is(400));

	}
	
	@Test
	void testIssuePolicyWithInvalidToken() throws Exception {
	String json = "{ 'pid':12, 'area':30.0, 'propertytype':'asfsdf', 'insurancetype':'asff', 'buildingtype':'asfdf', 'propertyValue':21432, 'costOfAsset':12442, 'salvageValue':1243, 'usefulLifeOfAsset':124, 'age':12, 'storey':12 }";
		
		this.mvc.perform(post("/issuePolicy")
				.content(json)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "WORNG "+token))
				.andExpect(status().is(400));
	}

	@Test
	public void testIssuePolicyWithValidToken() throws Exception {
		IssueRequest i = new IssueRequest();
		i.setPolicyid(100);
		i.setConsumerid("501");
		i.setBusinessid(1);
		i.setpDetails("Details");
		i.setAcceptedQuote("Quotes");
		String json = new ObjectMapper().valueToTree(i).toString();
		this.mvc.perform(post("/createPolicy")
				.content(json)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer "+token))
				.andExpect(status().is(400));

	}
	
	

}
