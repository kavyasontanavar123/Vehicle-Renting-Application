package com.example.Vehicle.Renting.Application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	//@PreAuthorize("hasAuthority('CUSTOMER')")
	@PostMapping("/customer/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerCustomer(@RequestBody UserRequest userRequest){
		UserResponse userResponse= userService.register(userRequest,UserRole.CUSTOMER);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "customer created", userResponse));
		
	}
	
	//@PreAuthorize("hasAuthority('RENTING_PARTNER')")
	@PostMapping("/renting-partner/register")
	public ResponseEntity<ResponseStructure<UserResponse>>registerRentingPartner(@RequestBody UserRequest userRequest){
		UserResponse userResponse= userService.register(userRequest,UserRole.RENTING_PARTNER);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(),"Renting partner created",userResponse));
		
	}
	//@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/admin/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerAdmin(@RequestBody UserRequest userRequest){
		UserResponse userResponse= userService.register(userRequest,UserRole.ADMIN);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Admin created", userResponse));
		
	}
	@GetMapping("/find-user")
	public ResponseEntity<ResponseStructure<UserResponse>>findUser(){
		 UserResponse userResponse = userService.findUser();
		 return ResponseEntity
					.status(HttpStatus.FOUND)
					.body(ResponseStructure.create(HttpStatus.CREATED.value(),"User found successfully",userResponse));
	}
	@PutMapping("/update-user")
	public ResponseEntity<ResponseStructure<UserResponse>>updateUser(@RequestBody UserRequest userRequest){
		 UserResponse userResponse = userService.updateUser(userRequest);
		 return ResponseEntity
					.status(HttpStatus.OK)
					.body(ResponseStructure.create(HttpStatus.OK.value(),"User updated successfully",userResponse));
	}
	
	
	

}
