package com.example.Vehicle.Renting.Application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Vehicle.Renting.Application.util.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundByIdException(UserNotFoundByIdException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"user not found by the given ID"));
	
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleFailedToUploadException(FailedToUploadException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"Failed to upload the image"));
	
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleImageNotFoundByIdException(ImageNotFoundByIdException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"Failed to find the image"));
	
	}

}
