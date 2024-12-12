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
	private final ImageRepository imageRepository;

	public UserService(UserRepository userRepository,ImageRepository imageRepository) {
		super();
		this.userRepository = userRepository;
		this.imageRepository = imageRepository;
	}
	public User registration(User user) {
		return userRepository.save(user);
	}
	public void uploadProfile(int userId, MultipartFile file)  {
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			Image image = getImage(file);
			image = imageRepository.save(image);
			
			User user = optional.get();
			user.setProfilePicture(image);
			userRepository.save(user);	
		}else {
			throw new UserNotFoundByIdException("user not found by given id");
		}
		
	}
	private Image getImage(MultipartFile file) {
		Image image = new Image();
		try {
			byte[] imageBytes = file.getBytes();
			
			image.setContentType(file.getContentType());
			image.setImageBytes(imageBytes);
			imageRepository.save(image);
		}
		catch(IOException e) {
		       throw new FailedToUploadException("user failed to upload image");
		}
		return image;
		
	}
		
	

}
