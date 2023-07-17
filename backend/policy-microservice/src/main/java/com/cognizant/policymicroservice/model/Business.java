package com.cognizant.policymicroservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="Model value that stores the business details")
@Entity
@Table(name="Business")
public class Business {

	@ApiModelProperty(notes ="Id of the business")
	@Id
	@Column
	private double id;
	
	@ApiModelProperty(notes ="type of the business")
	@Column
	private String type;
	
	@ApiModelProperty(notes ="turnover of the business")
	@Column
	private double turnover;
	
	@ApiModelProperty(notes ="totalEmployees of the business")
	@Column
	private double totalEmployees;
	
	@ApiModelProperty(notes ="category of the business")
	@Column
	private String businesscategory;
	
	@ApiModelProperty(notes ="typ of the business")
	@Column
	private String businesstype;
	
	@Column
	private long capitalInvested;
	
	@Column
	private long businessValue;
	
	@Column
	private long businessAge;

	public long getBusinessAge() {
		return businessAge;
	}

	public void setBusinessAge(long businessAge) {
		this.businessAge = businessAge;
	}

	@JsonBackReference
	@OneToOne(mappedBy="business",cascade = CascadeType.ALL)
	private Consumer consumer;
	
	public Business() {
		super();
	}

	

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public double getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(double totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	public String getBusinesscategory() {
		return businesscategory;
	}

	public void setBusinesscategory(String businesscategory) {
		this.businesscategory = businesscategory;
	}

	public String getBusinesstype() {
		return businesstype;
	}

	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}

	public long getCapitalInvested() {
		return capitalInvested;
	}

	public void setCapitalInvested(long capitalInvested) {
		this.capitalInvested = capitalInvested;
	}

	public long getBusinessValue() {
		return businessValue;
	}

	public void setBusinessValue(long businessValue) {
		this.businessValue = businessValue;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	
	
	
	
}
