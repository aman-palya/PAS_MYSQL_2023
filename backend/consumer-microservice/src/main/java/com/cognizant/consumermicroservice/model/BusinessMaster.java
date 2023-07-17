package com.cognizant.consumermicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="BusinessMaster")
@ApiModel(value ="Model object that stores the business master details")
public class BusinessMaster {

	@ApiModelProperty(notes ="id of the package")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
		
	@ApiModelProperty(notes ="types of employees in the business")
	@Column
	private double totalEmployees;
	
	@ApiModelProperty(notes="turnover of business master")
	@Column
	private double turnover;
	
	@ApiModelProperty(notes ="age of business")
	@Column
	private int businessAge;
		
	

	public BusinessMaster() {
		super();
	}



	public double getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getTotalEmployees() {
		return totalEmployees;
	}



	public void setTotalEmployees(double totalEmployees) {
		this.totalEmployees = totalEmployees;
	}



	public double getTurnover() {
		return turnover;
	}



	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}



	public int getBusinessAge() {
		return businessAge;
	}



	public void setBusinessAge(int businessAge) {
		this.businessAge = businessAge;
	}



	

	
	
}
