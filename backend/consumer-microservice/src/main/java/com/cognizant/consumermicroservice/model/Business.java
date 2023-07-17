package com.cognizant.consumermicroservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Business")

@ApiModel(description ="Model object that stores the consumer business details.")
public class Business {
    
	@ApiModelProperty(notes ="id of business")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@ApiModelProperty(notes ="types of business")
	@Column
	private String type;
	
	@ApiModelProperty(notes ="business turnover")
	@Column
	private double turnover;
	
	@ApiModelProperty(notes ="total employees in the business")
	@Column
	private double totalEmployees;
	
	@ApiModelProperty(notes ="category of consumer's business")
	@Column
	private String businesscategory;
	
	@ApiModelProperty(notes ="type of the consumer's business")
	@Column
	private String businesstype;
	
	@ApiModelProperty(notes ="capital invested in the business")
	@Column
	private double capitalInvested;
	
	@ApiModelProperty(notes ="calculated business value")
	@Column
	private double businessValue;
	
	@ApiModelProperty(notes ="age of business")
	@Column
	private int businessAge;

	public int getBusinessAge() {
		return businessAge;
	}

	public void setBusinessAge(int businessAge) {
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

	public void setId(int id) {
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

	public double getCapitalInvested() {
		return capitalInvested;
	}

	public void setCapitalInvested(double capitalInvested) {
		this.capitalInvested = capitalInvested;
	}

	public double getBusinessValue() {
		return businessValue;
	}

	public void setBusinessValue(double businessValue) {
		this.businessValue = businessValue;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Business(int id, String type, double turnover, double totalEmployees, String businesscategory,
			String businesstype, double capitalInvested, double businessValue, int businessAge, Consumer consumer) {
		super();
		this.id = id;
		this.type = type;
		this.turnover = turnover;
		this.totalEmployees = totalEmployees;
		this.businesscategory = businesscategory;
		this.businesstype = businesstype;
		this.capitalInvested = capitalInvested;
		this.businessValue = businessValue;
		this.businessAge = businessAge;
		this.consumer = consumer;
	}

	
	
	
	
}
