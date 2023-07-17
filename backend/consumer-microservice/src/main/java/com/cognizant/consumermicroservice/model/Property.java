package com.cognizant.consumermicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Property")

@ApiModel(description ="Model object that stores property details of the consumer")
public class Property {

	@ApiModelProperty(notes ="id of the property")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int pid;
	
	@ApiModelProperty(notes ="area of the property")
	@Column
	private double area;
	
	@ApiModelProperty(notes ="type of the property")
	@Column
	private String propertytype;
	
	@ApiModelProperty(notes ="insurance of the property")
	@Column
	private String insurancetype;
	
	@ApiModelProperty(notes ="buildingtype of the property")
	@Column
	private String buildingtype;
	
	@ApiModelProperty(notes ="value of the property")
	@Column
	private double propertyValue;
	
	@ApiModelProperty(notes ="cost of asset")
	@Column
	private long costOfAsset;
	
	@ApiModelProperty(notes ="salvage value of asset")
	@Column
	private long salvageValue;
	
	@ApiModelProperty(notes ="lifetime of asset")
	@Column
	private long usefulLifeOfAsset;
	
	@ApiModelProperty(notes ="age of the property")
	@Column
	private int age;
	
	@ApiModelProperty(notes ="number of storey")
	@Column
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

	public double getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(double propertyValue) {
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

	public Property(int pid, double area, String propertytype, String insurancetype, String buildingtype,
			double propertyValue, long costOfAsset, long salvageValue, long usefulLifeOfAsset, int age, int storey,
			Consumer consumer) {
		super();
		this.pid = pid;
		this.area = area;
		this.propertytype = propertytype;
		this.insurancetype = insurancetype;
		this.buildingtype = buildingtype;
		this.propertyValue = propertyValue;
		this.costOfAsset = costOfAsset;
		this.salvageValue = salvageValue;
		this.usefulLifeOfAsset = usefulLifeOfAsset;
		this.age = age;
		this.storey = storey;
		this.consumer = consumer;
	}
	
	
}
