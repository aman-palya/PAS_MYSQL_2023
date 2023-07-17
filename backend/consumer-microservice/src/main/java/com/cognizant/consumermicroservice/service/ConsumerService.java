package com.cognizant.consumermicroservice.service;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.consumermicroservice.exception.AuthorizationException;
import com.cognizant.consumermicroservice.model.BusinessMaster;
import com.cognizant.consumermicroservice.model.Consumer;
import com.cognizant.consumermicroservice.model.Property;
import com.cognizant.consumermicroservice.model.PropertyMaster;
import com.cognizant.consumermicroservice.repository.BusinessMasterRepository;
import com.cognizant.consumermicroservice.repository.BusinessRepository;
import com.cognizant.consumermicroservice.repository.ConsumerRepository;
import com.cognizant.consumermicroservice.repository.PropertyMasterRepository;
import com.cognizant.consumermicroservice.repository.PropertyRepository;

@Service
public class ConsumerService {

	@Autowired
	BusinessRepository businessRepo;
	
	@Autowired
	ConsumerRepository consumerRepo;
	
	@Autowired 
	PropertyRepository propertyRepo;
	
	@Autowired
	BusinessMasterRepository businessMasterRepo;
	
	@Autowired
	PropertyMasterRepository propertyMasterRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
	
	public ResponseEntity<?> createConsumerBusiness(Consumer consumer) {
		logger.debug("Create Consumer Service");
		Consumer c = consumer;
		double v = calculateBusinessValue(consumer.getBusiness().getTurnover(),consumer.getBusiness().getCapitalInvested());
		c.getBusiness().setBusinessValue(v);
	//	c.setId(consumer.getId());
		consumerRepo.save(c);
		System.out.println(c);
		return new ResponseEntity<>("Added Consumer",HttpStatus.OK);
	}
	
	public ResponseEntity<?>  updateConsumerBusiness (Consumer consumer) {
		logger.debug("Update Consumer Service");
		Consumer c = consumerRepo.findById(consumer.getId()).get();
		c.setAgentId(consumer.getAgentId());
		c.setAgentName(consumer.getAgentName());
		c.setBusiness(consumer.getBusiness());
		c.setDob(consumer.getDob());
		c.setEmail(consumer.getEmail());
		c.setName(consumer.getName());
		c.setPan(consumer.getPan());
		c.setValidity(consumer.getValidity());
		c.setProperty(consumer.getProperty());
		c.setBusiness(consumer.getBusiness());
		c.setProperty(consumer.getProperty());
	
		return new ResponseEntity<>("Updated Consumer Business",HttpStatus.OK);
	}
	
	public ResponseEntity<?> createBusinessProperty(Long id, Property property) {
		logger.debug("Create Property Service");
		Consumer c = consumerRepo.findById(id).get();
		Property p = property;
		double v = calculatePropertyValue(property.getCostOfAsset(),property.getSalvageValue(),property.getUsefulLifeOfAsset());
		p.setPropertyValue(v);
		c.setProperty(property);
		consumerRepo.save(c);
		propertyRepo.save(property);
		return new ResponseEntity<>("Added Business Property",HttpStatus.OK); 
	}
	
	public ResponseEntity<?> updateBusinessProperty(Long id,Property property) {
		logger.debug("Update Consumer Service");
		Consumer c = consumerRepo.findById(id).get();
		Property p = property;
		double v = calculatePropertyValue(property.getCostOfAsset(),property.getSalvageValue(),property.getUsefulLifeOfAsset());
		p.setPropertyValue(v);
		c.setProperty(property);
		consumerRepo.save(c);
		propertyRepo.save(property);
		return new ResponseEntity<>("Added Business Property",HttpStatus.OK); 
		
	}
	
	public Consumer viewConsumerBusiness(Long id){
		logger.debug("View Consumer Service");
		return consumerRepo.findById(id).get();
	}
	public List<Consumer> viewAllConsumerBusiness(){
		logger.debug("View Consumer Service");
		return (List<Consumer>) consumerRepo.findAll();
	}
	public Property viewConsumerProperty(int pid) {
		logger.debug("View Consumer Property Service");
		return propertyRepo.findById(pid).get();
	}
	
	
	public double calculateBusinessValue(double turnover, double capital) {
		
		double max = 10D;
		double min = 0D;
		double range_diff = max-min;
		double r = turnover/capital;
		double res = (r-capital)/(turnover-capital);
		double ans = range_diff*res;
		if(ans > 10) {
			ans = ans/10.0;
		}else if(ans > 100) {
			ans=ans/100.0;
		}
		return Math.abs(Math.round(ans));
	}
	
	public double calculatePropertyValue(long cost, long salvage, long life) {
		double max = 10D;
		double min = 0D;
		double range_diff = max-min;
		double r = (double)((cost-salvage)/life);
		double x_max = (double)(cost/life);
		double x_min = (double)(salvage/life);
		double res = (r-x_min)/(x_max-x_min);
		double ans = range_diff*res;
		if(ans > 10) {
			ans = ans/10.0;
		}else if(ans > 100) {
			ans=ans/100.0;
		}
		return Math.abs(Math.round(ans));
	}
	
}
