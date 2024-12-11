package com.example.Vehicle.Renting.Application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.service.UserService;
import com.example.Vehicle.Renting.Application.util.ResponseStructure;

@RestController
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<User>>registration(@RequestBody User user){
		user= userService.registration(user);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(),"customer created",user));
		
	}
		
	
	

}
