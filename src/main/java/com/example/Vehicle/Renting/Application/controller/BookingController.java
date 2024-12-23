package com.example.Vehicle.Renting.Application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vehicle.Renting.Application.requestdto.BookingRequest;
import com.example.Vehicle.Renting.Application.requestdto.LocationRequest;
import com.example.Vehicle.Renting.Application.responsedto.BookingResponse;
import com.example.Vehicle.Renting.Application.responsedto.LocationResponse;
import com.example.Vehicle.Renting.Application.service.BookingService;
import com.example.Vehicle.Renting.Application.util.ResponseStructure;

@RestController
public class BookingController {
	private final BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}

	@PostMapping("/add-booking")
	public ResponseEntity<ResponseStructure<BookingResponse>> createBooking(
			@RequestBody BookingRequest request,
			@RequestParam int vehicleListingId,
			@RequestParam int pickUpLocationId,
			@RequestParam int dropLocationId) {

		BookingResponse response = bookingService.createBooking(request, vehicleListingId, pickUpLocationId, dropLocationId);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Booking Created", response));

	}

	

}
