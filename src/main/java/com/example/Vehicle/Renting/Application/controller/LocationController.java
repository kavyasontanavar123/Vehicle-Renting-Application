package com.example.Vehicle.Renting.Application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vehicle.Renting.Application.entity.Location;
import com.example.Vehicle.Renting.Application.requestdto.LocationRequest;
import com.example.Vehicle.Renting.Application.responsedto.LocationResponse;
import com.example.Vehicle.Renting.Application.service.LocationService;
import com.example.Vehicle.Renting.Application.service.VehicleListingService;
import com.example.Vehicle.Renting.Application.util.ResponseStructure;

@RestController
public class LocationController {
	private final LocationService locationService;
	private final VehicleListingService vehicleListingService;
	
	 public LocationController(LocationService locationService,VehicleListingService vehicleListingService) {
		super();
		this.locationService = locationService;
		this.vehicleListingService= vehicleListingService;
	}

	@PostMapping("/add-location")
	    public ResponseEntity<ResponseStructure<LocationResponse>> addLocation(
	            @RequestBody LocationRequest locationRequest) {
		LocationResponse locationResponse = locationService. addLocation(locationRequest);

       
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseStructure.create(HttpStatus.CREATED.value(), 
                        "Location added successfully", locationResponse));
		
	 
	 }

@GetMapping("/find-all-location")
public ResponseEntity<ResponseStructure<List<LocationResponse>>> findAllLocations(@RequestParam
		("vehicleListingId") int vehicleListingId) {

	List<LocationResponse> responses = locationService.findAllLocationsByVehicleListing(vehicleListingId);

	return ResponseEntity.status(HttpStatus.FOUND).body(
			ResponseStructure.create(HttpStatus.FOUND.value(), "Locations are fetched", responses));

}
}

