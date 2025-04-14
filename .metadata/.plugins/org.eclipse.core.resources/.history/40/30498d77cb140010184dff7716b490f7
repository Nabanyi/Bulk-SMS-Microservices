package com.aseda.demo.requestobjs;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserUpdateRequest {
	@NotEmpty(message = "Username is required")
	private String username;
    
    @JsonProperty("firstname")
    @NotEmpty(message = "First name is required")
    private String firstName;
    
    @JsonProperty("middlename")
    private String middleName;
    
    @JsonProperty("lastname")
    @NotEmpty(message = "Last name is required")
    private String lastName;
    
    @Email(message = "Invalid email format")
    @NotEmpty(message = "Email is required")
    private String email;
    
    @NotEmpty(message = "Phone is required")
    private String phone;
    
    @NotEmpty(message = "Address is required")
    private String address;

	public UserUpdateRequest() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
