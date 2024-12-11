package com.example.Vehicle.Renting.Application.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Vehicle.Renting.Application.service.UserService;

@RestController
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	

}
