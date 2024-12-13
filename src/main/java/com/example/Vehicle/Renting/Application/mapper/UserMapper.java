package com.example.Vehicle.Renting.Application.mapper;

import org.springframework.stereotype.Component;

import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.requestdto.UserRequest;
import com.example.Vehicle.Renting.Application.responsedto.UserResponse;

@Component
public class UserMapper {
	public User mapToUser(UserRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setRole(request.getRole());
		return user;

	}

	public UserResponse mapToUserResponse(User user) {
		UserResponse response = new UserResponse();
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		response.setPhoneNumber(user.getPhoneNumber());
		response.setRole(user.getRole());

		return response;

	}

}
