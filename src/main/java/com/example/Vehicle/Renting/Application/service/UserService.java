package com.example.Vehicle.Renting.Application.service;

import org.springframework.stereotype.Service;

import com.example.Vehicle.Renting.Application.repository.UserRepository;

@Service
public class UserService {
	private  final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	

}
