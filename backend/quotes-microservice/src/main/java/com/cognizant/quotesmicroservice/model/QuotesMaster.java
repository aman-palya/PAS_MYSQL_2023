package com.cognizant.quotesmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="Model object that stores the quotes details based on business and property.")
@Entity
@Table(name="QuotesMaster")
public class QuotesMaster {

	@ApiModelProperty(notes ="id of the quotes")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@ApiModelProperty(notes ="value of the business")
	@Column
	private double businessValue;
	
	@ApiModelProperty(notes ="value of the property")
	@Column
	private double propertyValue;
	
	@ApiModelProperty(notes ="quotes value")
	@Column
	private String quotes;

	public QuotesMaster() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBusinessValue() {
		return businessValue;
	}

	public void setBusinessValue(double businessValue) {
		this.businessValue = businessValue;
	}

	public double getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(double propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getQuotes() {
		return quotes;
	}

	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}

	public QuotesMaster(int id, double businessValue, double propertyValue, String quotes) {
		super();
		this.id = id;
		this.businessValue = businessValue;
		this.propertyValue = propertyValue;
		this.quotes = quotes;
	}
	
	
	
}
