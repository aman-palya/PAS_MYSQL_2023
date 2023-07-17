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
@Table(name="PropertyMaster")

@ApiModel(value ="Model object that stores property details")
public class PropertyMaster {

	@ApiModelProperty(notes="id of property master")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	
	@ApiModelProperty(notes ="value of the property master")
	@Column
	private long propertyValue;
	
	@ApiModelProperty(notes ="age of the property")
	@Column
	private int age;
	

	public PropertyMaster() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getPropertyValue() {
		return propertyValue;
	}


	public void setPropertyValue(long propertyValue) {
		this.propertyValue = propertyValue;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
