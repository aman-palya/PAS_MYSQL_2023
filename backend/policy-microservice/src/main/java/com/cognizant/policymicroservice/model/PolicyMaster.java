package com.cognizant.policymicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="PolicyMaster")
@ApiModel(description="Model value that stores the policy details")
public class PolicyMaster {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes ="primary key Id")
	private int id;
	
	@Column
	@ApiModelProperty(notes="assured sum for the consumer business")
	private String assured_sum;
	
	@Column
	@ApiModelProperty(notes="business value of the consumer's business")
	private double bvalue;
	
	@Column
	@ApiModelProperty(notes="property value of the consumer's business")
	private double pvalue;
	

	public PolicyMaster() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAssured_sum() {
		return assured_sum;
	}


	public void setAssured_sum(String assured_sum) {
		this.assured_sum = assured_sum;
	}


	public double getBvalue() {
		return bvalue;
	}


	public void setBvalue(double bvalue) {
		this.bvalue = bvalue;
	}


	public double getPvalue() {
		return pvalue;
	}


	public void setPvalue(double pvalue) {
		this.pvalue = pvalue;
	}

	
	
	
}
