package com.cognizant.policymicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Property")
@ApiModel(description="Model value that stores the property details")
public class Property {

	@Id
	@Column
	@ApiModelProperty(notes="id of the property")
	private int pid;
	
	@Column
	@ApiModelProperty(notes="area of the property")
	private double area;
	
	@Column
	@ApiModelProperty(notes="type of the property")
	private String propertytype;
	
	@Column
	@ApiModelProperty(notes="type of insurnace")
	private String insurancetype;
	
	@Column
	@ApiModelProperty(notes="type of building")
	private String buildingtype;
	
	@Column
	@ApiModelProperty(notes="value of the property")
	private long propertyValue;
	
	@Column
	@ApiModelProperty(notes="cost of the asset")
	private long costOfAsset;
	
	@Column
	@ApiModelProperty(notes="salvage value of the asset")
	private long salvageValue;
	
	@Column
	@ApiModelProperty(notes="useful life of assedt")
	private long usefulLifeOfAsset;
	
	@Column
	@ApiModelProperty(notes="age of the property")
	private int age;
	
	@Column
	@ApiModelProperty(notes="number of storry in property")
	private int storey;

	@JsonIgnore
	@OneToOne(mappedBy="property")
	private Consumer consumer;
	
	public Property() {
		super();
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getPropertytype() {
		return propertytype;
	}

	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}

	public String getInsurancetype() {
		return insurancetype;
	}

	public void setInsurancetype(String insurancetype) {
		this.insurancetype = insurancetype;
	}

	public String getBuildingtype() {
		return buildingtype;
	}

	public void setBuildingtype(String buildingtype) {
		this.buildingtype = buildingtype;
	}

	public long getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(long propertyValue) {
		this.propertyValue = propertyValue;
	}

	public long getCostOfAsset() {
		return costOfAsset;
	}

	public void setCostOfAsset(long costOfAsset) {
		this.costOfAsset = costOfAsset;
	}

	public long getSalvageValue() {
		return salvageValue;
	}

	public void setSalvageValue(long salvageValue) {
		this.salvageValue = salvageValue;
	}

	public long getUsefulLifeOfAsset() {
		return usefulLifeOfAsset;
	}

	public void setUsefulLifeOfAsset(long usefulLifeOfAsset) {
		this.usefulLifeOfAsset = usefulLifeOfAsset;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStorey() {
		return storey;
	}

	public void setStorey(int storey) {
		this.storey = storey;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	
	
}
