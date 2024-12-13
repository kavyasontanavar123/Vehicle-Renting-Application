package com.example.Vehicle.Renting.Application.service;

import org.springframework.stereotype.Service;

import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.mapper.UserMapper;
import com.example.Vehicle.Renting.Application.repository.UserRepository;
import com.example.Vehicle.Renting.Application.requestdto.UserRequest;
import com.example.Vehicle.Renting.Application.responsedto.UserResponse;

@Service
public class UserService {
	private  final UserRepository userRepository;
	private final UserMapper userMapper;
	

	public UserService(UserRepository userRepository,UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		
	}
	public UserResponse registration(UserRequest userRequest) {
		User user = userMapper.mapToUser(userRequest);
		User req = userRepository.save(user);
		return userMapper.mapToUserResponse(req);
	}
	

}
