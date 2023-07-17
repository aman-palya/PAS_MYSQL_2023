package com.cognizant.policymicroservice;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.policymicroservice.model.Business;
import com.cognizant.policymicroservice.model.Consumer;
import com.cognizant.policymicroservice.model.PolicyDetailsResponse;
import com.cognizant.policymicroservice.model.PolicyMaster;
import com.cognizant.policymicroservice.model.Property;

@SpringBootTest
@AutoConfigureMockMvc
public class PolicyModelTest {

	@Autowired
	MockMvc mvc;
	
	@Test
	void testBusinessModel() {
    	Business b = new Business();
		Consumer c = new Consumer("C1","Customer",new Date(),"PAN","abc@test.com",10.0,"Agent","A1");
    	b.setBusinessAge(1);
    	b.setId(11.0);
    	b.setBusinesscategory("category");
    	b.setBusinesstype("type");
    	b.setBusinessValue(11L);
    	b.setCapitalInvested(100000);
    	b.setTotalEmployees(123);
    	b.setTurnover(500000);
    	b.setType("TYPE");
    	b.setConsumer(c);
		assertNotNull(b.getId());
		assertNotNull(b.getBusinessAge());
		assertNotNull(b.getBusinesscategory());
		assertNotNull(b.getBusinesstype());
		assertNotNull(b.getBusinessValue());
		assertNotNull(b.getCapitalInvested());
		assertNotNull(b.getTotalEmployees());
		assertNotNull(b.getTurnover());	
		assertNotNull(b.getType());	
		assertNotNull(b.getConsumer());	

	}
	
	@Test
	void testPropertyModel() {
		Property p = new Property();
		Consumer c = new Consumer("C1","Customer",new Date(),"PAN","abc@test.com",10.0,"Agent","A1");
		p.setConsumer(c);
		p.setAge(11);
		p.setArea(234.0);
		p.setBuildingtype("TYPE");
		p.setCostOfAsset(123456);
		p.setInsurancetype("ITYPE");
		p.setPid(100);
		p.setPropertytype("PTYPE");
		p.setPropertyValue(1234567);
		p.setSalvageValue(10101);
		p.setStorey(3);
		p.setUsefulLifeOfAsset(4);
		
		assertNotNull(p.getAge());	
		assertNotNull(p.getArea());
		assertNotNull(p.getBuildingtype());	
		assertNotNull(p.getCostOfAsset());	
		assertNotNull(p.getInsurancetype());
		assertNotNull(p.getPid());
		assertNotNull(p.getPropertytype());
		assertNotNull(p.getPropertyValue());
		assertNotNull(p.getSalvageValue());
		assertNotNull(p.getStorey());
		assertNotNull(p.getUsefulLifeOfAsset());
		assertNotNull(p.getConsumer());		

	}
	
	@Test
	void testConsumerModel() {
		Consumer c = new Consumer("C1","Customer",new Date(),"PAN","abc@test.com",10.0,"Agent","A1");
		Property p = new Property();
		Business b = new Business();
		b.setBusinessAge(1);
    	b.setId(11.0);
    	b.setBusinesscategory("category");
    	b.setBusinesstype("type");
    	b.setBusinessValue(11L);
    	b.setCapitalInvested(100000);
    	b.setTotalEmployees(123);
    	b.setTurnover(500000);
    	b.setType("TYPE");
    	b.setConsumer(c);
		p.setConsumer(c);
		p.setAge(11);
		p.setArea(234.0);
		p.setBuildingtype("TYPE");
		p.setCostOfAsset(123456);
		p.setInsurancetype("ITYPE");
		p.setPid(100);
		p.setPropertytype("PTYPE");
		p.setPropertyValue(1234567);
		p.setSalvageValue(10101);
		p.setStorey(3);
		p.setUsefulLifeOfAsset(4);
		c.setAgentId("A1");
		c.setDob(new Date());
		c.setEmail("emaik");
		c.setId("C1");
		c.setName("NAME");
		c.setPan("PAN");
		c.setValidity(10.0);
		c.setAgentName("Agent");
		c.setProperty(p);
		c.setBusiness(b);
		assertNotNull(c.getAgentId());
		assertNotNull(c.getAgentName());
		assertNotNull(c.getDob());
		assertNotNull(c.getEmail());
		assertNotNull(c.getId());
		assertNotNull(c.getName());
		assertNotNull(c.getPan());
		assertNotNull(c.getValidity());
		assertNotNull(c.getProperty());
		assertNotNull(c.getBusiness());
		
	}
	
	@Test
	void testPolicyDetails() {
		PolicyDetailsResponse po = new PolicyDetailsResponse(501,"100", "TYPE", "type","100", "10", 11.0, 12.0,"LOCATION","TPYE", 1.0, "DATE", "SUM", "QUOTE", "DETAILS");
		PolicyMaster m = new PolicyMaster();
		m.setAssured_sum("100000");
		m.setPvalue(11.0);
		m.setBvalue(13.0);
		m.setId(11);
		assertNotNull(po);
		assertNotNull(m.getAssured_sum());
		assertNotNull(m.getBvalue());
		assertNotNull(m.getPvalue());
	}

	
}
