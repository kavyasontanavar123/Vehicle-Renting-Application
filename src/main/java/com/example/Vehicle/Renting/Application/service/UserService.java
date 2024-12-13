package com.example.Vehicle.Renting.Application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

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
	        this.setProfilePictureURL(userResponse,user.getUserId());
	        return userResponse;
		}else {
			 throw new UserNotFoundByIdException("User not found");
			 
		}
	}
	private void setProfilePictureURL( UserResponse userResponse,int userId) {
		int imageId=userRepository.getProfilePictureIdByUserId(userId);
		
		if(imageId>0) {
			userResponse.setProfilePictureLink("/find-image?imageId=" + imageId);
		}
	}

	
	public UserResponse updateUser(int userId, UserRequest userRequest) {
		 Optional<User> optionalUser = userRepository.findById(userId);
		 if (optionalUser.isPresent()) {
	            User user = userMapper.mapToUser(userRequest, optionalUser.get());
	            userRepository.save(user);
	            
	            return userMapper.mapToUserResponse(user);
	        }
		 else {
			 throw  new UserNotFoundByIdException("Failed to find User");
		 }

		
	}

	


	}



