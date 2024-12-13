package com.example.Vehicle.Renting.Application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vehicle.Renting.Application.enums.UserRole;
import com.example.Vehicle.Renting.Application.requestdto.UserRequest;
import com.example.Vehicle.Renting.Application.responsedto.UserResponse;
import com.example.Vehicle.Renting.Application.service.UserService;
import com.example.Vehicle.Renting.Application.util.ResponseStructure;

@RestController
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@PostMapping("/customer/register")
	public ResponseEntity<ResponseStructure<UserResponse>>registerCustomer(@RequestBody UserRequest userRequest){
		UserResponse userResponse= userService.register(userRequest,UserRole.CUSTOMER);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(),"customer created",userResponse));
		
	}
	@PostMapping("/renting-partner/register")
	public ResponseEntity<ResponseStructure<UserResponse>>registerRentingPartner(@RequestBody UserRequest userRequest){
		UserResponse userResponse= userService.register(userRequest,UserRole.RENTING_PARTNER);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(),"customer created",userResponse));
		
	}
	@GetMapping("/find-user")
	public ResponseEntity<ResponseStructure<UserResponse>>findUser(@RequestParam  int userId){
		 UserResponse userResponse = userService.findUserById(userId);
		 return ResponseEntity
					.status(HttpStatus.FOUND)
					.body(ResponseStructure.create(HttpStatus.CREATED.value(),"User found successfully",userResponse));
	}
	@PutMapping("/update-user")
	public ResponseEntity<ResponseStructure<UserResponse>>updateUser(@RequestParam  int userId,@RequestBody UserRequest userRequest){
		 UserResponse userResponse = userService.updateUser(userId,userRequest);
		 return ResponseEntity
					.status(HttpStatus.FOUND)
					.body(ResponseStructure.create(HttpStatus.CREATED.value(),"User found successfully",userResponse));
	}
	
	

}
