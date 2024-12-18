package com.example.Vehicle.Renting.Application.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.example.Vehicle.Renting.Application.security.OauthUtil;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder ;
	private final OauthUtil oauthUtil;

	public UserService(UserRepository userRepository,ImageRepository imageRepository, UserMapper userMapper, PasswordEncoder passwordEncoder,OauthUtil oauthUtil) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.passwordEncoder =passwordEncoder;
		this.oauthUtil =oauthUtil ;

	}

	public UserResponse register(UserRequest userRequest,UserRole role) {
		User user = userMapper.mapToUser(userRequest,new  User());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(role);
		User req = userRepository.save(user);
		return userMapper.mapToUserResponse(req);
	}

	public UserResponse findUser() {

		User user = oauthUtil.getCurrentUser();
		UserResponse response = userMapper.mapToUserResponse(user);
		this.setProfilePictureURL(response, user.getProfilePicture());

		return response;
	}
	private void setProfilePictureURL(UserResponse response, Image profilePicture) {

		if (profilePicture != null)
			response.setProfilePictureLink("/find-image-by-id?image-id=" + profilePicture.getImageId());

	}

	public UserResponse updateUser(UserRequest request) {
		User user = userMapper.mapToUser(request, oauthUtil.getCurrentUser());
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userRepository.save(user);

		UserResponse response = userMapper.mapToUserResponse(user);
		this.setProfilePictureURL(response, user.getProfilePicture());

		return response;
	}
	}

	


	



