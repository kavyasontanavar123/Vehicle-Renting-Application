package com.example.Vehicle.Renting.Application.mapper;

import org.springframework.stereotype.Component;

import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.requestdto.UserRequest;
import com.example.Vehicle.Renting.Application.responsedto.UserResponse;

@Component
public class UserMapper {
	public User mapToUser(UserRequest request,User user) {
		
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
	
		return user;

	}

	public UserResponse mapToUserResponse(User user) {
		UserResponse response = new UserResponse();
		response.setUserId(user.getUserId());
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		response.setPhoneNumber(user.getPhoneNumber());
		response.setRole(user.getRole());
		if(user.getProfilePicture() != null) {
			response.setProfilePictureLink("/find-image?imageId=" + user.getProfilePicture().getImageId());
		}else {
			response.setProfilePictureLink(null);
		}

		return response;

	}

}
