package com.cognizant.consumermicroservice.model;

import java.util.Date;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Consumer")

@ApiModel(description ="Model object that stores the consumer details")
public class Consumer {
	
	@Id
	@Column
	@ApiModelProperty(notes ="id of the consumer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    //	private String id;
	private Long id;

	@ApiModelProperty(notes ="name of consumer")
	@Column
	private String name;
	
	@ApiModelProperty(notes ="dob of consumer")
	@Column
	private Date dob;
	
	@ApiModelProperty(notes ="pan of consumer")
	@Column
	private String pan;
	
	@ApiModelProperty(notes ="email of consumer")
	@Column
	private String email;
	
	@ApiModelProperty(notes ="validity of consumer")
	@Column
	private double validity;
	
	@ApiModelProperty(notes ="agentName of consumer")
	@Column
	private String agentName;
	
	@ApiModelProperty(notes ="agentId of consumer")
	@Column
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
