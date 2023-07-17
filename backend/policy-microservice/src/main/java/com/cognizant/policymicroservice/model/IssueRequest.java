package com.cognizant.policymicroservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Model object that stores the Issue Request details")
public class IssueRequest {

	@ApiModelProperty(value ="id of the policy")
	int policyid;
	@ApiModelProperty(value ="id of the consumer")
	Long consumerid;
	@ApiModelProperty(value ="id of the business")
	double businessid;
	@ApiModelProperty(value ="details of the policy")
	String pDetails;
	@ApiModelProperty(value ="accepted Quote for the policy")
	String acceptedQuote;
	public int getPolicyid() {
		return policyid;
	}
	public void setPolicyid(int policyid) {
		this.policyid = policyid;
	}
	public Long getConsumerid() {
		return consumerid;
	}
	public void setConsumerid(Long consumerid) {
		this.consumerid = consumerid;
	}
	public double getBusinessid() {
		return businessid;
	}
	public void setBusinessid(double businessid) {
		this.businessid = businessid;
	}
	public String getpDetails() {
		return pDetails;
	}
	public void setpDetails(String pDetails) {
		this.pDetails = pDetails;
	}
	public String getAcceptedQuote() {
		return acceptedQuote;
	}
	public void setAcceptedQuote(String acceptedQuote) {
		this.acceptedQuote = acceptedQuote;
	}
	
	
	
}
