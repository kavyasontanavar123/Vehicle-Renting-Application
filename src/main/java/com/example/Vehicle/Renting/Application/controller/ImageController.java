package com.example.Vehicle.Renting.Application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Vehicle.Renting.Application.service.ImageService;
import com.example.Vehicle.Renting.Application.util.SimpleResponseStructure;

@RestController
public class ImageController {
	private final ImageService imageService;
	
	
	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}


	@PostMapping("/upload-profile")
	public ResponseEntity<SimpleResponseStructure>uploadProfile(@RequestParam ("userId")int userId,
			@RequestParam("file")MultipartFile file ){
		
	        imageService.uploadProfile(userId,file);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(SimpleResponseStructure.create(HttpStatus.CREATED.value(),"customer image uploaded"));
		
	  
	}

}
