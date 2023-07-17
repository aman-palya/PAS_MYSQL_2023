package com.cognizant.authorizationmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "user")

@ApiModel(description ="Model to be used for storing user details")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes ="for id")
    private long id;
    @Column
    @ApiModelProperty(notes ="for name")
    private String username;
    @Column
    @JsonIgnore
    @ApiModelProperty(notes ="for password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public UserDao(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public UserDao() {
		
	}
	
    

}