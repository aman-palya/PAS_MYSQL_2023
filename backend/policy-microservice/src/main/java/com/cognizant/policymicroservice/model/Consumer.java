package com.cognizant.policymicroservice.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Consumer")
@ApiModel(value="Model object that stores the consumer's details")
public class Consumer {
	
	@Id
	@Column
	@ApiModelProperty("id of consumer")
	private Long id;

	@Column
	@ApiModelProperty("name of consumer")
	private String name;
	
	@Column
	@ApiModelProperty("date of birth of consumer")
	private Date dob;
	
	@Column
	@ApiModelProperty("pan of consumer")
	private String pan;
	
	@Column
	@ApiModelProperty("email of consumer")
	private String email;
	
	@Column
	@ApiModelProperty("validity of consumer")
	private double validity;
	
	@Column
	@ApiModelProperty("name of agent")
	private String agentName;
	
	@Column
	@ApiModelProperty("id of agent")
	private String agentId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="businessId", referencedColumnName="id")
	private Business business;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid", referencedColumnName="pid")
	private Property property;
	
	public Consumer() {
		super();
	}

	public Consumer(Long id, String name, Date dob, String pan, String email, double validity, String agentName,
			String agentId) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.pan = pan;
		this.email = email;
		this.validity = validity;
		this.agentName = agentName;
		this.agentId = agentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getValidity() {
		return validity;
	}

	public void setValidity(double validity) {
		this.validity = validity;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	
	
	
}
