package com.cognizant.authorizationmicroservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Model to be used for user Details")
public class UserDto {
	
	@ApiModelProperty(notes="name of User")
    private String username;
	@ApiModelProperty(notes="password of User")
    private String password;

    public String getUsername() {
        return username;
    }

    public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
}