package com.example.Vehicle.Renting.Application.service;

import org.springframework.stereotype.Service;

import com.example.Vehicle.Renting.Application.repository.ImageRepository;

@Service
public class ImageService {
	private final ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}
	
	
}