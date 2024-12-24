package com.example.Vehicle.Renting.Application.requestdto;

import com.example.Vehicle.Renting.Application.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {
	
	@NotBlank(message = "username cannot  be blank")
	@NotNull(message = "username cannot be null ")
	@Pattern(regexp = "^[a-zA-Z0-9-_ ]+$")
	private String username;
	
	@NotBlank(message = "email cannot  be blank")
	@NotNull(message = "email cannot be null ")
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$" ,message ="invalid email format")
	private String email;
	
	@NotBlank(message = "phone number cannot  be blank")
	@NotNull(message = "phone number cannot be null ")
	private String phoneNumber;
	
	@NotBlank(message = "password cannot  be blank")
	@NotNull(message = "password cannot be null ")
	@Pattern(regexp ="^(?=(.*[A-Z]))(?=(.*[0-9]))(?=(.*[@#^$*&]))[A-Za-z0-9@#^$*&]{8,12}$",message="Invalid password")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
