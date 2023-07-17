package com.cognizant.quotesmicroservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.quotesmicroservice.model.QuotesMaster;
import com.cognizant.quotesmicroservice.repository.QuotesMasterRepository;
import com.cognizant.quotesmicroservice.service.QuotesService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class QuotesMicroserviceApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	QuotesService service;
	
	@MockBean
	QuotesMasterRepository repo;
	
	@Mock
	QuotesMasterRepository quotesRepo;

	
	@Test
	void testGetQuotesForPolicy() {
		QuotesMaster m = new QuotesMaster(1,10,13,"QUOTES");

        Mockito.when(quotesRepo.save(any(QuotesMaster.class))).thenReturn(m);		

	}
	
	@Test
	void testGetQuotesById() {
		QuotesMaster m = new QuotesMaster(1,10,13,"QUOTES");
		Optional<QuotesMaster> po = Optional.of(m);
		Mockito.when(quotesRepo.findById(1)).thenReturn(po);
	}
	
	@Test
	void testGetQuotesByValue() {
		QuotesMaster m = new QuotesMaster(1,10,13,"QUOTES");
		QuotesMaster po = new QuotesMaster();
		Mockito.when(quotesRepo.findByBusinessValueAndPropertyValue(10, 13)).thenReturn(po);
	}
	
	@Test
	void testGetQuotesByWrongValueService() {
		QuotesMaster m = new QuotesMaster(1,10.0,13,"QUOTES");
		quotesRepo.save(m);
		String res = service.getQuotesForPolicy(12222.0, 13.0);
		assertNull(res);
	}
	
	@Test
	void testAttributes() {
		QuotesMaster m = new QuotesMaster();
		m.setId(1);
		m.setBusinessValue(10.0);
		m.setPropertyValue(13.0);
		m.setQuotes("QUOTES");
		assertNotNull(m.getId());
		assertNotNull(m.getBusinessValue());
		assertNotNull(m.getPropertyValue());
		assertNotNull(m.getQuotes());
	}
	
	
	String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmgiLCJleHAiOjE2Mzc1MzAwNDgsImlhdCI6MTYzNzUxMjA0OH0.pfhoW57uN9DfT4-0DuSdGJwOjZNsOqICdaCHskRfR54plBl_rlRQMt1yWtMqlOPdgYytLgROC_qb_FLY4B2aRw";
	@Test
	public void getQuotesForPolicy() throws Exception{
//		Mockito.when(service.getQuotesForPolicy(100.0, 200.0)).thenReturn("quotes");
		mockMvc.perform(MockMvcRequestBuilders.get("/getQuotesForPolicy/10/13")
				.header("Authorization", "Bearer "+token))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getQuotesForPolicy_noQuotes() throws Exception {
		MvcResult res = mockMvc.perform(MockMvcRequestBuilders.get("/getQuotesForPolicy/1000.0/200.0")).andReturn();
		assertTrue(res.getResponse().getContentAsString().isEmpty());
	}
	
	@Test
	public void testSwaggerEndPoint() throws Exception {
		this.mockMvc.perform(get("/v2/api-docs")).andExpect(status().isOk());
	}
	
	@Test
	public void testSwaggerUIEndPoint() throws Exception {
		this.mockMvc.perform(get("/swagger-ui.html")).andExpect(status().isOk());
	}
	
	

}
