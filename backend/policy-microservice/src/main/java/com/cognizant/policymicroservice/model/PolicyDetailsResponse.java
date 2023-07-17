package com.cognizant.policymicroservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Response details of the policy")
public class PolicyDetailsResponse {

	@ApiModelProperty("id of consumer")
	private Long consumerid;
	
	@ApiModelProperty("policy id of consumer")
	private String policyid;
	
	@ApiModelProperty("type of property")
	private String property_type;
	
	@ApiModelProperty("type of consumer")
	private String consumer_type;
	
	@ApiModelProperty("total sum covered for the policy")
	private String assured_sum;

	@ApiModelProperty("tenure of policy")
	private String tenure;
	
	@ApiModelProperty("business value of policy")
	private double business_value;
	
	@ApiModelProperty("value of property")
	private double property_value;
	
	@ApiModelProperty(notes="base location of the property")
	private String base_location;
	
	@ApiModelProperty(notes="types of the property")
	private String type;
	
	@ApiModelProperty(notes="id of business")
	private double businessid;
	
	@ApiModelProperty(notes="issue date of the property")
	private String eDate;
	
	@ApiModelProperty(notes="sum of the property")
	private String sum;
	
	@ApiModelProperty(notes="accepted quote for the property")
	private String acceptedquote;
	
	@ApiModelProperty(notes="details of the payment")
	private String paymentDetails;

	public PolicyDetailsResponse(Long consumerid, String policyid, String property_type, String consumer_type,
			String assured_sum, String tenure, double business_value, double property_value, String base_location,
			String type, double businessid, String eDate, String sum, String acceptedquote, String paymentDetails) {
		super();
		this.consumerid = consumerid;
		this.policyid = policyid;
		this.property_type = property_type;
		this.consumer_type = consumer_type;
		this.assured_sum = assured_sum;
		this.tenure = tenure;
		this.business_value = business_value;
		this.property_value = property_value;
		this.base_location = base_location;
		this.type = type;
		this.businessid = businessid;
		this.eDate = eDate;
		this.sum = sum;
		this.acceptedquote = acceptedquote;
		this.paymentDetails = paymentDetails;
	}
	
	
	
	
}
