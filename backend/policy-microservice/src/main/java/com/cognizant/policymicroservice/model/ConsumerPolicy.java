package com.cognizant.policymicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="ConsumerPolicy")

@ApiModel(value="Model object that stores the consumer's policy details")
public class ConsumerPolicy {

	
	@Column
	@ApiModelProperty(notes ="Id of consumer policy")
	private Long consumerid;
	
	@Column
	@Id
	@ApiModelProperty(notes ="id of the policy")
	private int policyid;
	
	@Column
	@ApiModelProperty(notes ="id of the business")
	private double businessid;
	
	@Column
	@ApiModelProperty(notes ="payments details of the consumer")
	private String paymentdetails;
	
	@Column
	@ApiModelProperty(value="acceptance status of the policy")
	private String acceptance;
	
	@Column
	@ApiModelProperty(value="status of the policy")
	private String policystatus;
	
	@Column
	@ApiModelProperty(notes ="issue date of consumer policy")
	private String edate;
	
	@Column
	@ApiModelProperty(notes ="covered amount of the policy for the consumer")
	private String amount;
	
	@Column
	@ApiModelProperty(notes ="duration of consumer policy")
	private String duration;
	
	@Column 
	@ApiModelProperty(notes ="accepted quotes for the consumer business")
	private String acceptedquote;

	public ConsumerPolicy() {
		super();
	}


	public Long getConsumerid() {
		return consumerid;
	}

	public void setConsumerid(Long consumerid) {
		this.consumerid = consumerid;
	}

	public int getPolicyid() {
		return policyid;
	}

	public void setPolicyid(int policyid) {
		this.policyid = policyid;
	}

	public double getBusinessid() {
		return businessid;
	}

	public void setBusinessid(double d) {
		this.businessid = d;
	}

	public String getPaymentdetails() {
		return paymentdetails;
	}

	public void setPaymentdetails(String paymentdetails) {
		this.paymentdetails = paymentdetails;
	}

	public String getAcceptance() {
		return acceptance;
	}

	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}

	public String getPolicystatus() {
		return policystatus;
	}

	public void setPolicystatus(String policystatus) {
		this.policystatus = policystatus;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAcceptedquote() {
		return acceptedquote;
	}

	public void setAcceptedquote(String acceptedquote) {
		this.acceptedquote = acceptedquote;
	}
	
	
}
