package com.example.Vehicle.Renting.Application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Vehicle.Renting.Application.entity.Image;
import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.enums.UserRole;
import com.example.Vehicle.Renting.Application.exception.UserNotFoundByIdException;
import com.example.Vehicle.Renting.Application.mapper.UserMapper;
import com.example.Vehicle.Renting.Application.repository.ImageRepository;
import com.example.Vehicle.Renting.Application.repository.UserRepository;
import com.example.Vehicle.Renting.Application.requestdto.UserRequest;
import com.example.Vehicle.Renting.Application.responsedto.UserResponse;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository,ImageRepository imageRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;

	}

	public UserResponse register(UserRequest userRequest,UserRole role) {
		User user = userMapper.mapToUser(userRequest,new  User());
		user.setRole(role);
		User req = userRepository.save(user);
		return userMapper.mapToUserResponse(req);
	}

	public UserResponse findUserById(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
	
		if (optionalUser.isPresent()) {
	        User user = optionalUser.get();
	        UserResponse userResponse = userMapper.mapToUserResponse(user);
	        this.setProfilePictureURL(userResponse,user.getProfilePicture());
	        return userResponse;
		}else {
			 throw new UserNotFoundByIdException("User not found");
			 
		}
	}
	private void setProfilePictureURL(UserResponse response, Image profilePicture) {

		if (profilePicture != null)
			response.setProfilePictureLink("/find-image-by-id?image-id=" + profilePicture.getImageId());

	}

	public UserResponse updateUser(UserRequest request,int userId) {
		
		Optional<User> optional = userRepository.findById(userId);

		if (optional.isPresent()) {
			User user = userMapper.mapToUser(request, optional.get());
			
			userRepository.save(user);
			
			UserResponse response = userMapper.mapToUserResponse(user);
			this.setProfilePictureURL(response, user.getProfilePicture()); 
			
			return response;
			
		} else {
			throw new UserNotFoundByIdException("Failed To Find The User");
		}
	}

	


	}



