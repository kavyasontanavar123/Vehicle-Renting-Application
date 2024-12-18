package com.example.Vehicle.Renting.Application.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Vehicle.Renting.Application.entity.Image;
import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.entity.Vehicle;
import com.example.Vehicle.Renting.Application.exception.FailedToUploadException;
import com.example.Vehicle.Renting.Application.exception.ImageNotFoundByIdException;
import com.example.Vehicle.Renting.Application.exception.UserNotFoundByIdException;
import com.example.Vehicle.Renting.Application.exception.VehicleNotFoundByIdExcepction;
import com.example.Vehicle.Renting.Application.repository.ImageRepository;
import com.example.Vehicle.Renting.Application.repository.UserRepository;
import com.example.Vehicle.Renting.Application.repository.VehicleRepository;
import com.example.Vehicle.Renting.Application.security.OauthUtil;

@Service
public class ImageService {
	private final ImageRepository imageRepository;
	private final UserRepository userRepository;
	private final OauthUtil oauthUtil;
	private final VehicleRepository vehicleRepository;

	public ImageService(ImageRepository imageRepository, UserRepository userRepository,OauthUtil oauthUtil, VehicleRepository vehicleRepository) {
		super();
		this.imageRepository = imageRepository;
		this.userRepository = userRepository;
		this.oauthUtil=oauthUtil;
		this.vehicleRepository=vehicleRepository;
		
	}

	public void uploadUserProfilePicture( MultipartFile file) {

		User user= oauthUtil.getCurrentUser();
		Image image1 = user.getProfilePicture();
		Image image=imageRepository.save(this.getImage(file));
		user.setProfilePicture(image);
		userRepository.save(user);
		imageRepository.delete(image1);
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

	public void uploadVehicleImage(List<MultipartFile> file, int vehiclId) {
		Vehicle vehicle=vehicleRepository.findById(vehiclId)
				.orElseThrow(() -> new VehicleNotFoundByIdExcepction("failed to upload vehicle"));
		List<Image>images = new ArrayList<Image>();
		for(MultipartFile files : file) {
			images.add(this.getImage(files));
		}
		images= imageRepository.saveAll(images);
		vehicle.setVehicleImage(images);
		vehicleRepository.save(vehicle);
	}

	

	
		
	}
