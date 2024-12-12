package com.example.Vehicle.Renting.Application.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Vehicle.Renting.Application.entity.Image;
import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.exception.FailedToUploadException;
import com.example.Vehicle.Renting.Application.exception.UserNotFoundByIdException;
import com.example.Vehicle.Renting.Application.repository.ImageRepository;
import com.example.Vehicle.Renting.Application.repository.UserRepository;

@Service
public class UserService {
	private  final UserRepository userRepository;
	

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		
	}
	public User registration(User user) {
		return userRepository.save(user);
	}
	

}
