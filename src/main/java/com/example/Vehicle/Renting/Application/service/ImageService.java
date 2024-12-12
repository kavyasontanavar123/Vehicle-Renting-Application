package com.example.Vehicle.Renting.Application.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Vehicle.Renting.Application.entity.Image;
import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.exception.FailedToUploadException;
import com.example.Vehicle.Renting.Application.exception.ImageNotFoundByIdException;
import com.example.Vehicle.Renting.Application.exception.UserNotFoundByIdException;
import com.example.Vehicle.Renting.Application.repository.ImageRepository;
import com.example.Vehicle.Renting.Application.repository.UserRepository;

@Service
public class ImageService {
	private final ImageRepository imageRepository;
	private final UserRepository userRepository;

	public ImageService(ImageRepository imageRepository, UserRepository userRepository) {
		super();
		this.imageRepository = imageRepository;
		this.userRepository = userRepository;
		
	}

	public void uploadProfile(int userId, MultipartFile file)  {
		Optional<User> optional = userRepository.findById(userId);
		
		if(optional.isPresent()) {
			Image image = imageRepository.save(this.getImage(file));
			
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

	public Image findImageById(int imageId) {
		Optional<Image> optional =imageRepository.findById(imageId);
		if(optional.isPresent()) {
		Image image = optional.get();
		
		return image;
		
	}else {
		throw new ImageNotFoundByIdException("Image not found");
	}
	}
}